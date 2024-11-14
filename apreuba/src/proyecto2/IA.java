/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import Funciones.ControlMainUI;
import Funciones.AudioManager;
import Funciones.ImageMovie;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


/**
 *
 * @author sisir
 */
public class IA extends Thread {

    private Administrador administrator;
    private Personaje peleadorStarWars;
    private Personaje peleadorStrarTrek;
    private int victoriaStarWars = 0;
    private int victoriaStarTrek = 0;

    private final Semaphore mutex;

    private long time;
    private int round;

    public IA() {
        this.administrator = App.getApp().getAdmin();
        this.mutex = App.getApp().getMutex();
        this.time = App.getApp().getBattleDuration();
        this.round = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.mutex.acquire();

                this.round += 1;

                ControlMainUI.getHome().getWinnerLabelID().setText("");
                ControlMainUI.getHome().getIaStatusLabel().setText("Determinando el resultado del combate...");
                updateCardsUI(getPeleadorStarWars(), getPeleadorStrarTrek());

                ControlMainUI.getHome().getRoundLabel().setText("Round: " + String.valueOf(round));

                Thread.sleep((long) (this.getTime() * 1000 * 0.7));

                double aux = Math.random();
                AudioManager audioManager = new AudioManager(); 

                if (aux <= 0.4) {
                    ControlMainUI.getHome().getIaStatusLabel().setText("¡Hay un ganador!");
                    Personaje winner = getWinnerCharacter(this.peleadorStarWars, this.peleadorStrarTrek);
                    ControlMainUI.getHome().getWinnerLabelID().setText(winner.getCharacterId());
                    audioManager.playSoundEffect("/GUI/Assets/victory.wav", 2.0f);
                    Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.6));

                } else if (aux > 0.40 && aux <= 0.67) {
                    ControlMainUI.getHome().getIaStatusLabel().setText("¡El combate termina en empate!");
                    audioManager.playSoundEffect("/GUI/Assets/tie.wav", 2.0f);
                    Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.6));
                    

                    this.getAdministrator().getStarWars().getQueue1().enqueue(this.peleadorStarWars);
                    this.getAdministrator().getStarTrek().getQueue1().enqueue(this.peleadorStrarTrek);
                } else {
                    ControlMainUI.getHome().getIaStatusLabel().setText("El combate no se llevará a cabo.");
                    audioManager.playSoundEffect("/GUI/Assets/fail.wav", 2.0f);
                    Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.6));

                    this.getAdministrator().getStarWars().getQueue4().enqueue(this.peleadorStarWars);
                    this.getAdministrator().getStarTrek().getQueue4().enqueue(this.peleadorStrarTrek);
                }

                clearFightersUI();

                Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.4));
                this.mutex.release();
                Thread.sleep(100);

            } catch (InterruptedException ex) {
                Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void clearFightersUI() {
        ControlMainUI.getHome().getIaStatusLabel().setText("Esperando nuevos personajes...");
        ControlMainUI.getHome().getWinnerLabelID().setText("");
        ControlMainUI.getHome().getRegularShowFighter().clearFightersLabels();
        ControlMainUI.getHome().getAvatarFighter().clearFightersLabels();
    }

    private Personaje getWinnerCharacter(Personaje peleadorStarWars, Personaje peleadorStarTrek) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + getTime() * 1000; // Convierte tiempo de combate a milisegundos
        boolean combatEnd = false;

        // Determina quién ataca primero basado en la velocidad inicialmente
        boolean isStarWarsTurn = peleadorStarWars.getSpeedVelocity() >= peleadorStarTrek.getSpeedVelocity();

        while (System.currentTimeMillis() < endTime && !combatEnd) {
            int damage;
            if (isStarWarsTurn) {
                // Regular Show ataca
                ControlMainUI.getHome().getRegularShowFighter().getStatusLabel().setText("Enviando daño");
                ControlMainUI.getHome().getAvatarFighter().getStatusLabel().setText("Recibiendo daño");
                damage = calculateDamage(peleadorStarWars, peleadorStarTrek);
                peleadorStarTrek.takeDamage(damage);
                ControlMainUI.getHome().getAvatarFighter().getHPLabel().setText(String.valueOf(peleadorStarTrek.getHitPoints()));
                if (peleadorStarTrek.getHitPoints() <= 0) combatEnd = true;
            } else {
                // Avatar ataca
                ControlMainUI.getHome().getAvatarFighter().getStatusLabel().setText("Enviando daño");
                ControlMainUI.getHome().getRegularShowFighter().getStatusLabel().setText("Recibiendo daño");
                damage = calculateDamage(peleadorStarTrek, peleadorStarWars);
                peleadorStarWars.takeDamage(damage);
                ControlMainUI.getHome().getRegularShowFighter().getHPLabel().setText(String.valueOf(peleadorStarWars.getHitPoints()));
                if (peleadorStarWars.getHitPoints() <= 0) combatEnd = true;
            }

            // Alterna el turno para el próximo ciclo
            isStarWarsTurn = !isStarWarsTurn;
            ControlMainUI.getHome().getAvatarFighter().getHPLabel().setText(String.valueOf(peleadorStarTrek.getHitPoints()));
            ControlMainUI.getHome().getRegularShowFighter().getHPLabel().setText(String.valueOf(peleadorStarWars.getHitPoints()));

            // Simula una pausa por ronda
            try {
                Thread.sleep(1000); // Ajusta según necesidad para permitir actualización de UI
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (combatEnd) break; // Salir del bucle si el combate terminó.
        }
        
        if (!combatEnd) {
        // Aquí se decide el ganador basado en quién tiene más HP.
            if (peleadorStarWars.getHitPoints() > peleadorStarTrek.getHitPoints()) {
                this.victoriaStarWars++;
                ControlMainUI.getHome().getTvPanelUI1().getVictoriesLabel().setText(String.valueOf(this.victoriaStarWars));
                return peleadorStarWars;
            } else if (peleadorStarWars.getHitPoints() < peleadorStarTrek.getHitPoints()) {
                this.victoriaStarTrek++;
                ControlMainUI.getHome().getTvPanelUI2().getVictoriesLabel().setText(String.valueOf(this.victoriaStarTrek));
                return peleadorStarTrek;
            } else {
                // En caso de empate por HP
                return peleadorStarTrek;
            }
        }

        // Determinar ganador basado en HP restante.
        if (peleadorStarWars.getHitPoints() > 0) {
            this.victoriaStarWars++;
            ControlMainUI.getHome().getTvPanelUI1().getVictoriesLabel().setText(String.valueOf(this.victoriaStarWars));
            return peleadorStarWars;
        } else if (peleadorStarTrek.getHitPoints() > 0) {
            this.victoriaStarTrek++;
            ControlMainUI.getHome().getTvPanelUI2().getVictoriesLabel().setText(String.valueOf(this.victoriaStarTrek));
            return peleadorStarTrek;
        } else {
            return null; // Manejo de empate
        }
    }


    private int calculateDamage(Personaje attacker, Personaje defender) {
        // Daño base con la lógica que el ataque no puede ser completo porque sino lo matariamos de one.
         int baseDamage = (attacker.getSpeedVelocity() + (attacker.getAgility() / 2)) / 2;

         // Inicializamos el daño
         int damage = baseDamage;

         switch (attacker.getHability()) {
             case "Ataque Crítico":
                 //INCREMENTE EL DAÑO BASE DE X1.5
                 damage *= 1.5;
                 break;
             case "Curación":
                 // RECUPERA EN VIDA LA MITAD DE LO QUE LO ATACARÍA 
                 int healAmount = baseDamage / 2;
                 attacker.heal(healAmount);
                 damage = (attacker.getSpeedVelocity() + (attacker.getAgility() / 2)) / 4;
                 break;
             case "Parálisis":
                 // Se le disminuye la agilidad al enemigo en un 50%
                 defender.setAgility(defender.getAgility() / 2);
                 break;
             case "Congelamiento":
                 // Se le disminuye la velocidad al enemigo en un 50%
                 defender.setSpeedVelocity(defender.getSpeedVelocity() / 2);
                 break;
             default:
                 // No special ability
                 break;
         }

         return damage;
     }

    private void updateCardsUI(Personaje peleadorStarWars, Personaje peleadorStarTrek) {
        ImageMovie imageUtils = new ImageMovie();

        ImageIcon starWarsCardIA = imageUtils.loadScaledImage(peleadorStarWars.getUrlSource(), 150, 200
        );

        ImageIcon starTrekIA = imageUtils.loadScaledImage(peleadorStarTrek.getUrlSource(), 150, 200
        );

        ControlMainUI.getHome().getRegularShowFighter().getFighterCard().setIcon(starWarsCardIA);
        ControlMainUI.getHome().getRegularShowFighter().getCharacterIDLabel().setText(peleadorStarWars.getCharacterId());
        ControlMainUI.getHome().getRegularShowFighter().getHPLabel().setText(String.valueOf(peleadorStarWars.getHitPoints()));

        ControlMainUI.getHome().getAvatarFighter().getFighterCard().setIcon(starTrekIA);
        ControlMainUI.getHome().getAvatarFighter().getCharacterIDLabel().setText(peleadorStarTrek.getCharacterId());
        ControlMainUI.getHome().getAvatarFighter().getHPLabel().setText(String.valueOf(peleadorStarTrek.getHitPoints()));
    }

    /**
     * @return the peleadorStarWars
     */
    public Personaje getPeleadorStarWars() {
        return peleadorStarWars;
    }

    /**
     * @param peleadorStarWars the peleadorStarWars to set
     */
    public void setPeleadorStarWars(Personaje peleadorStarWars) {
        this.peleadorStarWars = peleadorStarWars;
    }

    /**
     * @return the peleadorStrarTrek
     */
    public Personaje getPeleadorStrarTrek() {
        return peleadorStrarTrek;
    }

    /**
     * @param peleadorStrarTrek the peleadorStrarTrek to set
     */
    public void setPeleadorStrarTrek(Personaje peleadorStrarTrek) {
        this.peleadorStrarTrek = peleadorStrarTrek;
    }

    /**
     * @return the administrator
     */
    public Administrador getAdministrator() {
        return administrator;
    }

    /**
     * @param administrator the administrator to set
     */
    public void setAdministrator(Administrador administrator) {
        this.administrator = administrator;
    }

    /**
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(long time) {
        this.time = time;
    }

}

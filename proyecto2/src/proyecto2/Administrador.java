/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import Funciones.ControlMainUI;
import Funciones.Lista;
import Funciones.Cola;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sisir
 */
public class Administrador extends Thread {

    private IA ia;
    private final Semaphore mutex;
    private final Pelicula starwars;
    private final Pelicula starTrek;
    private int numRound = 0;

    public Administrador(IA ia, Semaphore mutex, Lista greenCards1, Lista yellowCards1, Lista redCards1,
            Lista greenCards2, Lista yellowCards2, Lista redCards2) {

        this.ia = ia;
        this.mutex = mutex;
        this.starwars = new Pelicula("Star Wars", "/GUI/Assets/StarWars", greenCards1, yellowCards1, redCards1);
        this.starTrek = new Pelicula("Star Trek", "/GUI/Assets/StarTrek", greenCards2, yellowCards2, redCards2);
    }

    public void startSimulation() {
//        ControlMainUI.getHome().setVisible(true);

        for (int i = 0; i < 17; i++) {
            getStarWars().createCharacter();
            System.out.println("Llego1");
            getStarTrek().createCharacter();
            System.out.println("Llego2");
        }

        ControlMainUI.getHome().getTvPanelUI1().updateUIQueue(getStarWars().getQueue1(),
                getStarWars().getQueue2(),
                getStarWars().getQueue3(),
                getStarWars().getQueue4()
        );

        ControlMainUI.getHome().getTvPanelUI2().updateUIQueue(getStarTrek().getQueue1(),
                getStarTrek().getQueue2(),
                getStarTrek().getQueue3(),
                getStarTrek().getQueue4()
        );

        ControlMainUI.getHome().setVisible(true);

        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.start();
        this.getIa().start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int battleDuration = ControlMainUI.getHome().getBattleDuration().getValue();
                ia.setTime(battleDuration);

                updateReinforcementQueue(this.starwars);
                updateReinforcementQueue(this.starTrek);

                if (numRound == 2) {
                    tryCreateCharacters();
                    numRound = 0;
                }

                Personaje peleadorStarWars = chooseFighters(this.getStarWars());
                Personaje peleadorStarTrek = chooseFighters(this.getStarTrek());

                //------------------
                //TODO: Pasarle los fighters a la IA
                // Aca 0j0
                //------------------
                this.getIa().setPeleadorStarWars(peleadorStarWars);
                this.getIa().setPeleadorStrarTrek(peleadorStarTrek);

                updateUIqueue();
                mutex.release();
                Thread.sleep(100);
                mutex.acquire();

                this.numRound += 1;
                
                risePriorities(this.getStarWars());
                risePriorities(this.getStarTrek());

                updateUIqueue();

            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void risePriorities(Pelicula tvShow) {
        riseQueue(tvShow.getQueue2(), tvShow.getQueue1());
        riseQueue(tvShow.getQueue3(), tvShow.getQueue2());
    }

    private void riseQueue(Cola currentLevel, Cola nextLevel) {
        int len = currentLevel.getLength();

        for (int i = 0; i < len; i++) {
            Personaje character = currentLevel.dequeue();
            character.setCounter(character.getCounter() + 1);

            if (character.getCounter() >= 8) {
                character.setCounter(0);
                nextLevel.enqueue(character);
            } else {
                currentLevel.enqueue(character);
            }
        }
    }

    private Personaje chooseFighters(Pelicula tvShow) {
        if (tvShow.getQueue1().isEmpty()) {
            tvShow.updateQueue1();
            this.updateUIqueue();
        }
        Personaje fighter = tvShow.getQueue1().dequeue();
        fighter.setCounter(0);
        return fighter;
    }

    public void updateUIqueue() {
        ControlMainUI.updateUIQueue("regularshow",
                this.getStarWars().getQueue1(),
                this.getStarWars().getQueue2(),
                this.getStarWars().getQueue3(),
                this.getStarWars().getQueue4());
        ControlMainUI.updateUIQueue("avatar",
                this.getStarTrek().getQueue1(),
                this.getStarTrek().getQueue2(),
                this.getStarTrek().getQueue3(),
                this.getStarTrek().getQueue4());
    }

    private void updateReinforcementQueue(Pelicula tvShow) {
        if (!(tvShow.getQueue4().isEmpty())) {
            double randomNum = Math.random();

            if (randomNum <= 0.4) {
                Personaje character = tvShow.getQueue4().dequeue();
                character.setCounter(0);
                tvShow.getQueue1().enqueue(character);
            }else {
            Personaje character = tvShow.getQueue4().dequeue();
            tvShow.getQueue4().enqueue(character);
            }
        }
    }

    private void tryCreateCharacters() {
        double randomNum = Math.random();

        if (randomNum <= 0.8) {
            getStarWars().createCharacter();
            getStarTrek().createCharacter();
        }
    }


    public Pelicula getStarWars() {
        return starwars;
    }

    public Pelicula getStarTrek() {
        return starTrek;
    }

    public IA getIa() {
        return ia;
    }


    public void setIa(IA ia) {
        this.ia = ia;
    }

}

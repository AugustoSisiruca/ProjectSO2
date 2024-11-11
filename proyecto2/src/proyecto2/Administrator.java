/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import Funciones.Cola;
import Funciones.ControlMainUI;
import Funciones.LinkedList;


/**
 *
 * @author sisir
 */
public class Administrator extends Thread {

    private IA ia;
    private final Semaphore mutex;
    private final Pelicula regularShow;
    private final Pelicula avatar;
    private int numRound = 0;

    public Administrator(IA ia, Semaphore mutex, LinkedList greenCards1, LinkedList yellowCards1, LinkedList redCards1,
            LinkedList greenCards2, LinkedList yellowCards2, LinkedList redCards2) {

        this.ia = ia;
        this.mutex = mutex;
        this.regularShow = new Pelicula("StarWars", "/GUI/Assets/RegularShow",
                greenCards1, yellowCards1, redCards1);
        this.avatar = new Pelicula("StarTrek", "/GUI/Assets/Avatar",
                greenCards2, yellowCards2, redCards2);
    }

    public void startSimulation() {
//        ControlMainUI.getHome().setVisible(true);

        for (int i = 0; i < 20; i++) {
            getRegularShow().createCharacter();
            getAvatar().createCharacter();
        }

        ControlMainUI.getHome().getTvPanelUI1().updateUIQueue(getRegularShow().getQueue1(),
                getRegularShow().getQueue2(),
                getRegularShow().getQueue3(),
                getRegularShow().getQueue4()
        );

        ControlMainUI.getHome().getTvPanelUI2().updateUIQueue(getAvatar().getQueue1(),
                getAvatar().getQueue2(),
                getAvatar().getQueue3(),
                getAvatar().getQueue4()
        );

        ControlMainUI.getHome().setVisible(true);

        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
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

                updateReinforcementQueue(this.regularShow);
                updateReinforcementQueue(this.avatar);

                if (numRound == 2) {
                    tryCreateCharacters();
                    numRound = 0;
                }

                Personaje regularShowFighter = chooseFighters(this.getRegularShow());
                Personaje avatarFighter = chooseFighters(this.getAvatar());

                //------------------
                //TODO: Pasarle los fighters a la IA
                // Aca 0j0
                //------------------
                this.getIa().setStarWarsFighter(regularShowFighter);
                this.getIa().setStarTrekFighter(avatarFighter);

                updateUIqueue();
                mutex.release();
                Thread.sleep(100);
                mutex.acquire();

                this.numRound += 1;
                
                risePriorities(this.getRegularShow());
                risePriorities(this.getAvatar());

                updateUIqueue();

            } catch (InterruptedException ex) {
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
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
                this.getRegularShow().getQueue1(),
                this.getRegularShow().getQueue2(),
                this.getRegularShow().getQueue3(),
                this.getRegularShow().getQueue4());
        ControlMainUI.updateUIQueue("avatar",
                this.getAvatar().getQueue1(),
                this.getAvatar().getQueue2(),
                this.getAvatar().getQueue3(),
                this.getAvatar().getQueue4());
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
            getRegularShow().createCharacter();
            getAvatar().createCharacter();
        }
    }

    /**
     * @return the regularShow
     */
    public Pelicula getRegularShow() {
        return regularShow;
    }

    /**
     * @return the avatar
     */
    public Pelicula getAvatar() {
        return avatar;
    }

    /**
     * @return the ia
     */
    public IA getIa() {
        return ia;
    }

    /**
     * @param ia the ia to set
     */
    public void setIa(IA ia) {
        this.ia = ia;
    }

}

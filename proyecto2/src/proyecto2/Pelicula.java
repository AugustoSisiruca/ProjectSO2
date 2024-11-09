/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import Funciones.LinkedList;
import Funciones.Node;
import Funciones.Cola;
import Funciones.HelpersFunctions;

/**
 *
 * @author sisir
 */

public class Pelicula {

    private LinkedList yellowCards;
    private LinkedList greenCards;
    private LinkedList redCards;

    private Cola queue1 = new Cola();
    private Cola queue2 = new Cola();
    private Cola queue3 = new Cola();
    private Cola queue4 = new Cola();
    private String packageImg;
    private String logoUrl;
    private String tvShow;

    public Pelicula(String tvShow, String packageImg, LinkedList yellowCards, LinkedList greenCards, LinkedList redCards) {
        this.yellowCards = yellowCards;
        this.greenCards = greenCards;
        this.redCards = redCards;

        this.packageImg = packageImg;
        this.logoUrl = this.packageImg + "/logo.png";

    }

    private void createAndEnqueueCharacter(Node characterNode) {
        characterNode.setIdNode(characterNode.getIdNode() + 1);

        Personaje personaje = characterNode.getTInfo();

        int priorityLevel = personaje.getPriorityLevel();

        String characterId = personaje.getNameCharacter() + "-"
                + HelpersFunctions.priority[priorityLevel - 1] + "-"
                + characterNode.getIdNode();

        String nameCharacter = personaje.getNameCharacter();
        int hitPoints = personaje.getHitPoints();
        int speedVelocity = personaje.getSpeedVelocity();
        int agility = personaje.getAgility();
        String hability = personaje.getHability();
        String urlSource = personaje.getUrlSource();

        Personaje newCharacter = new Personaje(
                characterId,
                nameCharacter,
                hitPoints,
                speedVelocity,
                agility,
                hability,
                urlSource
        );

        newCharacter.setPriorityLevel(priorityLevel);

        if (priorityLevel == 1) {
            this.queue1.enqueue(newCharacter);
        } else if (priorityLevel == 2) {
            this.queue2.enqueue(newCharacter);
        } else {
            this.queue3.enqueue(newCharacter);
        }
    }

    public void createCharacter() {
        int quality = 0;
        double randomValueHP = Math.random();
        double randomValueSpeed = Math.random();
        double randomValueHability = Math.random();
        double randomValueAgility = Math.random();

        quality = (randomValueHability <= 0.6) ? quality + 1 : quality;
        quality = (randomValueHP <= 0.7) ? quality + 1 : quality;
        quality = (randomValueSpeed <= 0.5) ? quality + 1 : quality;
        quality = (randomValueAgility <= 0.4) ? quality + 1 : quality;

        Node node = new Node();

        if (quality == 4) {
            node = greenCards.getRandomNode();
        } else if (quality == 3 || quality == 2) {
            node = yellowCards.getRandomNode();
        } else {
            node = redCards.getRandomNode();
        }

        createAndEnqueueCharacter(node);
    }

    public void updateQueue1() {
        if (!(this.queue2.isEmpty())) {
            Personaje aux = this.queue2.dequeue();
            aux.setCounter(0);
            this.queue1.enqueue(aux);
        } else {
            Personaje aux = this.queue3.dequeue();
            aux.setCounter(0);
            this.queue1.enqueue(aux);
        }
    }

    public LinkedList getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(LinkedList yellowCards) {
        this.yellowCards = yellowCards;
    }

    public LinkedList getGreenCards() {
        return greenCards;
    }

    public void setGreenCards(LinkedList greenCards) {
        this.greenCards = greenCards;
    }

    public LinkedList getRedCards() {
        return redCards;
    }

    public void setRedCards(LinkedList redCards) {
        this.redCards = redCards;
    }

    public Cola getQueue1() {
        return queue1;
    }

    public void setQueue1(Cola queue1) {
        this.queue1 = queue1;
    }

    public Cola getQueue2() {
        return queue2;
    }

    public void setQueue2(Cola queue2) {
        this.queue2 = queue2;
    }

    public Cola getQueue3() {
        return queue3;
    }

    public void setQueue3(Cola queue3) {
        this.queue3 = queue3;
    }

    public Cola getQueue4() {
        return queue4;
    }

    public void setQueue4(Cola queue4) {
        this.queue4 = queue4;
    }

    public String getPackageImg() {
        return packageImg;
    }

    public void setPackageImg(String packageImg) {
        this.packageImg = packageImg;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getTvShow() {
        return tvShow;
    }

    public void setTvShow(String tvShow) {
        this.tvShow = tvShow;
    }


    @Override
    public String toString() {
        String ListInfo = "\n\n\nListas:\n"
                + "-GreenCards:" + this.getGreenCards().toString() + "\n\n"
                + "-YellowCards:" + this.getYellowCards().toString() + "\n\n"
                + "-RedCards:" + this.getRedCards().toString() + "\n\n";

        String queueInfo = "\n\nColas:\n"
                + "Prioridad 1: " + this.getQueue1().toString() + "\n\n"
                + "Prioridad 2: " + this.getQueue2().toString() + "\n\n"
                + "Prioridad 3: " + this.getQueue3().toString() + "\n\n"
                + "Prioridad 4: " + this.getQueue4().toString() + "\n\n";

        return ListInfo + queueInfo;
    }

}

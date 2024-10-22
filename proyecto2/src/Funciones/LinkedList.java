/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
import java.util.Random;

/**
 *
 * @author sisir
 */

public class LinkedList {

    // Atributos de la clase
    private Nodo pFirst;
    private int iSize;


    public LinkedList() {
        this.pFirst = null;
        this.iSize = 0;
    }


    public void destroy() {
        Nodo pAux = getpFirst();
        while (pAux != null) {
            pAux = getpFirst();
            setpFirst(next(pAux));
            pAux = null;
        }
        setiSize(0);
        System.gc();
    }


    public Nodo next(Nodo pNode) {
        if (pNode != null) {
            return (Nodo) pNode.getNext();
        } else {
            return null;
        }
    }


    public boolean isEmpty() {
        return getpFirst() == null;
    }


    public int size() {
        return getiSize();
    }


    public Nodo first() {
        return getpFirst();
    }


    public void deleteFirst() {
        if (!isEmpty()) {
            Nodo pAux = getpFirst();
            setpFirst(next(pAux));
            pAux = null;
            setiSize(getiSize() - 1);
        }
    }

    public Nodo deleteAndReturn(int index) {
        if (!isEmpty()) {
            if (index >= 0 && index < getiSize()) {
                Nodo pAux = getpFirst();
                if (index == 0) {
                    setpFirst(next(pAux));
                    setiSize(getiSize() - 1);
                    return pAux;
                } else {
                    for (int i = 0; i < index - 1; i++) {
                        pAux = next(pAux);
                    }
                    pAux.setNext(next(next(pAux)));
                    setiSize(getiSize() - 1);
                    return pAux;
                }
            }
            return null;
        }
        return null;
    }



    public Nodo getRandomNode() {
        if (isEmpty()) {
            return null;
        }

        int index = new Random().nextInt(iSize);
        Nodo current = pFirst;

        for (int i = 0; i < index; i++) {
            current = (Nodo) current.getNext();
        }

        return current;
    }

    public Nodo getpFirst() {
        return pFirst;
    }


    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }


    public int getiSize() {
        return iSize;
    }


    public void setiSize(int iSize) {
        this.iSize = iSize;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "La lista está vacía.";
        }

        StringBuilder builder = new StringBuilder();
        Nodo current = pFirst;
        while (current != null) {
            builder.append(current.toString());
            builder.append(" -> ");
            current = (Nodo) current.getNext();
        }
        return builder.toString();
    }

}

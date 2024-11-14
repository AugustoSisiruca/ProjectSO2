/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import proyecto2.Personaje;
import java.util.Random;

/**
 *
 * @author sisir
 */
public class Lista {

    // Atributos de la clase
    private Nodo head;
    private int length;

    /**
     * Constructor de la clase
     */
    public Lista() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Destruye la lista completamente.
     */
    public void destroy() {
        Nodo pAux = getHead();
        while (pAux != null) {
            pAux = getHead();
            setHead(next(pAux));
            pAux = null;
        }
        setLength(0);
        System.gc();
    }

    /**
     * Dado un nodo de la lista, retorna el siguiente nodo enlazado.
     *
     * @param pNode, un nodo que pertenece a la lista.
     * @return null si el nodo dado no pertenece a la lista o si es el ultimo,
     * en caso contrario retorna el siguiente nodo enlazado.
     */
    public Nodo next(Nodo pNode) {
        if (pNode != null) {
            return pNode.getNextNode();
        } else {
            return null;
        }
    }

    /**
     * Verifica si la lista es vacia.
     *
     * @return retorna true si la lista esta vacia, en caso contrario retorna
     * false.
     */
    public boolean isEmpty() {
        return getHead() == null;
    }

    /**
     * Retorna el numero de nodos que conforman la lista.
     *
     * @return el tamaño de la lista.
     */
    public int size() {
        return getLength();
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return el primer nodo.
     */
    public Nodo first() {
        return getHead();
    }

    /**
     * Elimina el primer nodo de la lista.
     */
    public void deleteFirst() {
        if (!isEmpty()) {
            Nodo pAux = getHead();
            setHead(next(pAux));
            pAux = null;
            setLength(getLength() - 1);
        }
    }

    /**
     * Elimina el nodo de la posicion dada y lo retorna.
     *
     * @param index, la posicion dada.
     * @return el nodo que ha sido eliminado, si no pertenece a la lista
     * entonces retorna null.
     */
    public Nodo deleteAndReturn(int index) {
        if (!isEmpty()) {
            if (index >= 0 && index < getLength()) {
                Nodo pAux = getHead();
                if (index == 0) {
                    setHead(next(pAux));
                    setLength(getLength() - 1);
                    return pAux;
                } else {
                    for (int i = 0; i < index - 1; i++) {
                        pAux = next(pAux);
                    }
                    pAux.setNextNode(next(next(pAux)));
                    setLength(getLength() - 1);
                    return pAux;
                }
            }
            return null;
        }
        return null;
    }

    /**
     * Guarda la informacion dada en un nuevo nodo que sera insertado en la
     * ultima posicion de la lista.
     *
     * @param tInfo, la informacion a guardar.
     */
    public void addEnd(Personaje tInfo) {
        Nodo pNode = new Nodo(tInfo);
        if (isEmpty()) {
            setHead(pNode);
        } else {
            Nodo pAux = first();
            while (next(pAux) != null) {
                pAux = next(pAux);
            }
            pAux.setNextNode(pNode);
        }
        setLength(getLength() + 1);
    }

    /**
     * Retorna un nodo aleatorio de la lista.
     *
     * @return un nodo aleatorio.
     */
    public Nodo getRandomNode() {
        if (isEmpty()) {
            return null;
        }

        int index = new Random().nextInt(length);
        Nodo current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }

        return current;
    }

    /**
     * @return the head
     */
    public Nodo getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Nodo head) {
        this.head = head;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "La lista está vacía.";
        }

        StringBuilder builder = new StringBuilder();
        Nodo current = head;
        while (current != null) {
            builder.append(current.toString());
            builder.append(" -> ");
            current = current.getNextNode();
        }
        return builder.toString();
    }

}

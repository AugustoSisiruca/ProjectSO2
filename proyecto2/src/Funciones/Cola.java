/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;
import proyecto2.Personaje;

/**
 *
 * @author sisir
 */
public class Cola {

    private int length;
    /**
     * Primer elemento de la cola, primero en salir.
     */
    private Node front;
    /**
     * Ultimo elemento de la cola, ultimo en salir
     */
    private Node back;

    /**
     * Constructor de la clase.
     */
    public Cola() {
        this.length = 0;
        this.front = this.back = null;
    }

    /**
     * Getter para acceder a length.
     *
     * @return length el tamaño de la cola.
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter para modificarl a length.
     *
     * @param newLength nuevo tamaño de la cola.
     */
    public void setLegth(int newLength) {
        this.length = newLength;
    }

    /**
     * Getter para acceder al primer nodo en cola.
     *
     * @return front primer nodo en la cola.
     */
    public Node getFront() {
        return front;
    }

    /**
     * Setter para modificar el primer nodo en cola.
     *
     * @param newFront el nuevo nodo que estara al inicio de la cola.
     */
    public void setFrond(Node newFront) {
        this.front = newFront;
    }

    /**
     * Getter para acceder al ultimo nodo en cola.
     *
     * @return back el ultimo nodo en cola.
     */
    public Node getback() {
        return back;
    }

    /**
     * Setter para modificar el ultimo nodo en cola.
     *
     * @param newback nuevo nodo que sera el ultimo de la cola.
     */
    public void setback(Node newback) {
        this.back = newback;
    }

    /**
     * Retorna el nodo que le precede.
     *
     * @param nodo nodo dado
     * @return nextNodo
     */
    public Node next(Node nodo) {
        return nodo.getNextNode();
    }

    /**
     * Verifica si no hay elementos en cola.
     *
     * @return boolean true si no hay nodos en cola false si hay al menos un
     * nodo en la cola.
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Inserta un nodo con la informacion dada despues del ultimo nodo en cola,
     * y desplaza el back nodo al siguiente nodo.
     *
     * @param tInfo informacion a almacenar
     */
    public void enqueue(Personaje tInfo) {
        Node newNodo = new Node(tInfo);
        if (isEmpty()) {
            front = newNodo;
        } else {
            back.setNextNode(newNodo);
        }
        back = newNodo;
        length++;
    }

    /**
     * Saca el primer nodo en cola.
     *
     * @return aux el elemento que guarda el primer nodo en cola.
     */
    public Personaje dequeue() {
        Personaje aux = null;
        if (!isEmpty()) {
            aux = front.getTInfo();
            this.front = next(front);
            length--;
        }
        return aux;
    }

    /**
     * Libera todos los nodo que estan en la cola.
     */
    public void destroyQueue() {
        for (; front != null;) {
            this.front = next(front);
        }
        System.gc();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "La cola está vacía.";
        }

        StringBuilder builder = new StringBuilder();
        Node current = front;
        while (current != null) {
            builder.append(current.toString());
            if (current.getNextNode() != null) {
                builder.append(" -> ");
            }
            current = current.getNextNode();
        }

        return builder.toString();
    }

    public Cola cloneQueue() {
        Cola newQueue = new Cola();

        Node node = this.getFront();
        for (int i = 0; i < this.getLength(); i++) {
            Personaje character = node.getTInfo();

            Personaje newCharacter = new Personaje(
                    character.getCharacterId(),
                    character.getNameCharacter(),
                    character.getHitPoints(),
                    character.getSpeedVelocity(),
                    character.getAgility(),
                    character.getHability(),
                    character.getUrlSource());

            newQueue.enqueue(newCharacter);
            node = node.getNextNode();
        }
        return newQueue;
    }

}

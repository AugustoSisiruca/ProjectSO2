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
 *
 */
public class Node {

    /**
     * La infomacion a guardad en el nodo.
     */
    private Personaje tInfo;
    /**
     * El siguiente nodo.
     */
    private Node pNextNode;

    private int idNode;

    /**
     * Constructor de la clase.
     *
     * @param tInfo, la informacion a almacenar en el nodo.
     */
    public Node(Personaje tInfo) {
        this.tInfo = tInfo;
        this.pNextNode = null;
    }

    /**
     * Constructor de la clase.
     */
    public Node() {
        this.tInfo = null;
        this.pNextNode = null;
    }

    /**
     * Getter para acceder a la informacion que guarda el nodo.
     *
     * @return
     */
    public Personaje getTInfo() {
        return this.tInfo;
    }

    /**
     * Setter para modificar la informacion que guarda el nodo.
     *
     * @param tInfo
     */
    public void setTInfo(Personaje tInfo) {
        this.tInfo = tInfo;
    }

    /**
     * Getter para acceder al siguiente nodo enlazado.
     *
     * @return el nodo siguiente que esta enlazado.
     */
    public Node getNextNode() {
        return this.pNextNode;
    }

    /**
     * Setter para nodo siguiente que esta enlazado.
     *
     * @param pNextNode
     */
    public void setNextNode(Node pNextNode) {
        this.pNextNode = pNextNode;
    }

    @Override
    public String toString() {
        return "\n" + this.tInfo.toString();
    }

    /**
     * @return the idNode
     */
    public int getIdNode() {
        return idNode;
    }

    /**
     * @param idNode the idNode to set
     */
    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }

}
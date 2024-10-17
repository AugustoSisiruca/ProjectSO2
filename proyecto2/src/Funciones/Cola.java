/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

/**
 *
 * @author sisir
 */
public class Cola {
    private Nodo head;
    private Nodo tail;
    private int size;

    public Cola() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return getHead() == null && getTail() == null;
    }
    
    public void printCola() {
        Nodo pointer = getHead();
        while(pointer != null){
            System.out.print("["+pointer.getElement()+"]");
            pointer = (Nodo) pointer.getNext();    
        }
        System.out.println("\nTamano de la cola: "+ size);
    }
    
    public void encolar(int element){
        Nodo node = new Nodo(element);
        if (isEmpty()){
            setHead(node);
            setTail(node);
        } 
        else{
            Nodo pointer = getTail();
            pointer.setNext(node);
            setTail(node);
        }
        size++;
    }
    
    public void desencolar(){
        if (isEmpty()){
            System.out.println("Cola is Empty");
        }
        
        else{
            Nodo pointer = getHead();
            setHead((Nodo) pointer.getNext());
            pointer.setNext(null);
            if (getHead() == null ){
                setTail(null);
            }
        size --;
        }
    }
    public Nodo dispach(){
        if (isEmpty()){
            System.out.println("Cola is Empty");
        }
        else{
            Nodo pointer = getHead();
            setHead((Nodo) pointer.getNext());
            pointer.setNext(null);
            if (getHead() == null){
                setTail(null);
            }
            size--;
            return pointer;
        }
    return null;}
    
    public void invertirCola() {
        if (!isEmpty()) {
            Nodo newPointer = null;
            Nodo pointer = getHead();

            while (pointer != null) {
                Nodo pointerNext = (Nodo) pointer.getNext();
                pointer.setNext(newPointer);
                newPointer = pointer;
                pointer = pointerNext;
            }
            setTail(getHead());
            setHead(newPointer);
        }
    }
    
    
}

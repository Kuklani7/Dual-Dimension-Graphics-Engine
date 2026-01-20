package app.gameengine.model.datastructures;

import app.gameengine.model.physics.Vector2D;

public class LinkedListNode<T> {

    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode(T val, LinkedListNode<T> next) {
        this.value = val;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public void append(T val) {
        if(this==null){
            this.value=val;
            this.next=null;
        }
        if (this.next == null) {
            this.next = new LinkedListNode<>(val, null);
        } else {
            this.next.append(val);
        }
    }
    public int size(){
        if(this.getValue()==null){
            return 0;
        }
        if(this.next==null){
            return 1;
        }
        else{
            return 1 + this.next.size();
        }
    }
    public String toString(){
        String out="";
        out+=this.value;
        if(this.next!=null){
            out+=this.next.value;
        }
        return out;
    }

    public void append(LinkedListNode<T> val) {

        if (this.next == null) {
            this.next = val;
        } else {
            this.next.append(val);
        }
    }
    public LinkedListNode<Vector2D> LastNode(LinkedListNode<Vector2D> vectors){
        if(vectors == null){
            return null;
        }
        while(vectors.getNext()!=null){
            vectors=vectors.getNext();
        }
        return vectors;
    }

}

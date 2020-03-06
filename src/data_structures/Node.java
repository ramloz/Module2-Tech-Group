package data_structures;

public class Node<E> {

    private Node<E> next;
    private Node<E> previous;
    private E value;

    public Node(E value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public Node<E> getNext() {
        return next;
    }
    public Node<E> getPrevious() {
        return previous;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}

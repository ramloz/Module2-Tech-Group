package doublycircularlist;

public class Node<T> {
    public Node next;
    public Node previous;
    private T value;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}

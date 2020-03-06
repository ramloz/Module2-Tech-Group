package com.company.doublycircularlist;

public class Node<T> {
    private T key;
    private T value;
    private Node<T> previous;
    private Node<T> next;

    public Node(T key, T value) {
        this.key = key;
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    public T getKey() { return key;  }

    private void setKey(T key) { this.key = key; }

    private T getValue() {
        return value;
    }

    private void setValue(T value) {
        this.value = value;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

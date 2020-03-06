package com.company.doublycircularlist;

public class DoublyCircularLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private Integer size;

    public DoublyCircularLinkedList() {
        this.size = 0;
    }

    public Node<T> add(T key,T element) {
        Node<T> newNode = new Node<>(key ,element);
        if (this.size == 0) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
            newNode.setPrevious(this.last);
        }
        this.last = newNode;
        this.size++;
        return newNode;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index does not exists in the list");
        }
        Node<T> cursor = this.first;
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNext();
        }

        return cursor.getKey();

    }

    public boolean contains(T key) {
        Node<T> current = first;
        while (current != null) {
            if (current.getKey().equals(key)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public String getDefinition(T key){
        String result="";



        return result;
    }

    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public boolean remove(T key) {
        Node<T> current = first;
        boolean isRemoved = false;
        while (current != null) {
            if (current.getKey().equals(key)) {
                if (current == this.first) {
                    this.first = current.getNext();
                } else {
                    current.getPrevious().setNext(current.getNext());
                }
                if (current == this.last) {
                    this.last = current.getPrevious();
                } else {
                    current.getNext().setPrevious(current.getPrevious());
                }
                Node<T> removed = current;
                current = current.getNext();
                removed.setNext(null);
                removed.setPrevious(null);
                isRemoved = true;
                this.size--;
            } else {
                current = current.getNext();
            }
        }
        return isRemoved;
    }

    public Node<T> getFirst() {
        return this.first;
    }

    public Node<T> getLast() {
        return this.last;
    }

    /*@Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> cursor = this.first;
        while (cursor != null) {
            result.append(cursor.getValue().toString());
            if (cursor != this.last) {
                result.append(", ");
            }
            cursor = cursor.getNext();
        }
        return result.append("]").toString();
    }*/
}

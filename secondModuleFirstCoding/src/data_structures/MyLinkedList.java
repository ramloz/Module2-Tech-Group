package data_structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {

    private Node first;
    private Node last;
    private Integer size;


    public MyLinkedList(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }


    public Node getFirst() {

        return first;
    }

    private void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    private void setLast(Node last) {
        this.last = last;
    }

    public Integer getSize() {
        return size;
    }

    private void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public int size() {

        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (first == null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {


        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(T data) {
        Node node = new Node(data);
        if (first == null) {
            first = node;
            last = node;
            size++;
            return true;
        }
        else {
            this.last.setNext(node);
            last = node;
            size++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {

        Node<T> f = first;

        // If index is bigger / smaller than Linked List size throw IndexOutOfBounds
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }


        // Index Less than size and is not the first or last node.
        if (index < size && index > 0) {
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            return f.getValue();
        }

        // If the Linked List is empty + Index = 0 return null
        if (first == null && index == 0) {
            return null;
        }

        // If Linked List is not empty and index = 0 return first value
        if (index == 0) {
            f = first;
            return f.getValue();
        }

        // If index = end of list
        if (index == size) {
            f = last;
            return f.getValue();
        }


        // Return null if not found.
        return null;

    }

    @Override
    public T remove(int index) {
        return null;
    }


    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}

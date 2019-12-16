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
    public boolean contains(Object value) {
        Node node = first;
        while (node != null) {
            if (node.getValue().equals(value)) {
                return true;
            }
            node = node.getNext();
        }
        return false;

    }

    public boolean contains(Object o, MyLinkedList list) {
        if(size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object value = new Object();
            value = list.get(i);
            if(o == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public String toString() {
        String value = "[";
        Node nodeAux = first;
        while (nodeAux != null) {
            if (nodeAux == last) {
                value = value + nodeAux.getValue().toString();
            } else {
                value = value + nodeAux.getValue().toString() + ", ";

            }

            nodeAux = nodeAux.getNext();
        }
        return value + "]";
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


        Node nodeAux1 = first;
        Node nodeAux2 = null;
        boolean deleted = false;
        while(o.equals((first.getValue()))) {

            if (nodeAux1.getNext() == null) {
                if(o.equals(nodeAux1.getValue())) {
                    first = null;
                    last = null;
                    size = 0;
                    return true;
                }
            } else {
                if(o.equals(nodeAux1.getValue())) {
                    Node nodenext = nodeAux1.getNext();
                    first = nodenext;
                    size = size - 1;
                    if (size == 1) {
                        last = nodenext;
                    }
                    deleted = true;
                }
            }

        }
        nodeAux2 = nodeAux1;
        nodeAux1 = nodeAux1.getNext();

        while(nodeAux1.getNext() != null) {

            if(o.equals(nodeAux1.getValue())){
                Node nodenext = nodeAux1.getNext();
                nodeAux2.setNext(nodenext);
                size = size - 1;
                deleted = true;
            }
            nodeAux2 = nodeAux1;
            nodeAux1 = nodeAux1.getNext();
        }
        if(o.equals(nodeAux1.getValue())){
            last = nodeAux2;
            nodeAux2.setNext(null);
            size = size - 1;
            deleted = true;
        }
        if(deleted == true){
            return true;
        }else{
            return false;
        }

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
        Node nodeAux = first;
        for(int i =0; i< size;i++) {
            Node aux = nodeAux.getNext();
            nodeAux.setNext(null);
            nodeAux.setValue(null);
            nodeAux = aux;
        }
        size= 0;
        last=null;
        first=null;
    }

    @Override
    public T get(int index) {

        Node<T> f = first;

        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        // When the index is part of a value inside the List and is not the first or the last
        if (index < size && index > 0) {
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            return f.getValue();
        }

        // When the list is empty return null
        if (first == null) {
            return null;
        }

        // When the target value have the index of 0 and the list contains elements
        if (index == 0) {
            return f.getValue();
        }
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

package doublycircularlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.LinkedList;

public class DoublyCircularLinkedList <E>{

    private Node first;
    private Node last;
    public Integer size;

    public DoublyCircularLinkedList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }


    boolean add(E data) {

        Node node = new Node(data);
        if(this.size == 0){
            this.first = node;
            this.last = node;

            first.setPrevious(last);
            last.setNext(first);
            size++;
        }else{

            node.setPrevious(last);
            last.setNext(node);
            node.setNext(first);
            this.last = node;
            size++;
        }

        return false;
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node node = first;

        if(size > 0){
            for(int i=0; i < size; i++){
                result.append(node.getValue().toString());
                node = node.getNext();
                if(node==first){
                    result.append("]");

                }else {
                    result.append(", ");
                }

            }

            return result.toString();
        }else{
            result.append("]");
            return result.toString();
        }

    }


    public String get(int index){

        if(index>=size){
            throw new IndexOutOfBoundsException("Index is greater than the size");
        }
        Node node = first;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                return node.getValue().toString();

            } else {
                node = node.getNext();
            }

        }

        return node.getValue().toString();
    }

    public boolean contains(E data){
        Node node = first;
        if(size > 0){
            for(int i=0; i < size; i++){
                if(data == node.getValue()){
                    return true;
                }else{
                    node = node.getNext();
                }
            }
            return false;
        }
        return false;
    }


    public boolean clear(){
        Node node = first;
        Node nextNode = node.next;
        if(size > 0){
            for(int i=0; i < size; i++){
                node.setNext(null);
                node.setPrevious(null);
                node.setValue(null);
                node = nextNode;
                if(i<size){
                    nextNode = node.next;
                }
            }
            size = 0;
            first = null;
            last = null;
        }
        return true;
    }

    public boolean remove(E data){

        boolean control = false;
        if(size>0) {
            Node node = first;
            Node nextNode = node.getNext();
            Node prevNode = node.getPrevious();

            if(size==1){
                if(data == node.getValue()){
                    this.clear();
                    control = true;
                    return control;
                }
            }
            int i = 0;

            while(size >= i) {

                if (data == node.getValue()) {
                    nextNode.setPrevious(node.getPrevious());
                    prevNode.setNext(node.getNext());
                    if(node == first){
                        first = nextNode;
                    }
                    if(node == last){
                        last = prevNode;
                    }
                    node.setNext(null);
                    node.setPrevious(null);
                    node.setValue(null);
                    size--;
                    control = true;
                    node = nextNode;
                    nextNode = node.getNext();
                    prevNode = node.getPrevious();
                } else {
                    node = node.getNext();
                    nextNode = node.getNext();
                    prevNode = node.getPrevious();
                }
                i++;
            }
            if(node == last){
                if (data == node.getValue()) {
                    last = node.getPrevious();
                    first.setPrevious(node.getPrevious());
                    node.setNext(null);
                    node.setPrevious(null);
                    node.setValue(null);
                    size--;
                    control = true;
                }
            }
            return control;
        }else{
            return control;
        }
    }

    public Node<E> getFirst(){
        return first;
    }

    public Node<E> getLast(){
        return last;
    }
}

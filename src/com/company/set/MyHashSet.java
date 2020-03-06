package com.company.set;

import com.company.doublycircularlist.DoublyCircularLinkedList;
import java.util.HashSet;
import java.util.LinkedList;

public class MyHashSet<T> {
    private static final int LIST_SIZE_LIMIT = 3;
    private static final int INIT_ARRAY_SIZE = 10;

    private DoublyCircularLinkedList<T>[] index;
    private int indexSize;

    private int size;
    private double loadFactor = 0.75;

    public MyHashSet() {
        this.init(INIT_ARRAY_SIZE);
    }

    public MyHashSet(int initArraySize) {
        this.init(initArraySize);
    }

    private void init(int indexSize) {
        this.indexSize = indexSize;
        this.index = new DoublyCircularLinkedList[this.indexSize];
        initArrayLists(this.index);
    }

    private void initArrayLists(DoublyCircularLinkedList[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = new DoublyCircularLinkedList<>();
        }
    }

    private static int getHashCode(Object value) {
        if (value instanceof String) {
            return value.toString().length();
        }

        return value.hashCode();
    }

    public int getIndexSize() {
        return this.indexSize;
    }

    public DoublyCircularLinkedList<T> get(int index) {
        if (this.indexSize <= index) {
            throw new ArrayIndexOutOfBoundsException("Nono");
        }
        return this.index[index];
    }

    public boolean contains(T newKey) {
        int hashKey = getHashCode(newKey) % this.indexSize;

        return contains(this.index, newKey, hashKey);
    }

    private static boolean contains(DoublyCircularLinkedList[] array, Object newKey, int hashKey) {
        DoublyCircularLinkedList currentList = array[hashKey];

        return currentList.contains(newKey);
    }

    public boolean add(T key, T newValue) {

        int hashKey = getHashCode(key) % this.indexSize;

        boolean result = add(this.index, key, newValue, hashKey);

        if (result) {
            DoublyCircularLinkedList currentList = this.index[hashKey];
            if (currentList.size() > LIST_SIZE_LIMIT /*LOAD_FACTOR > THISINDEXSIZSE/SIZE*/) {
                rearrangeSet();
            }
            this.size++;
        }
        return result;
    }

    private static boolean add(DoublyCircularLinkedList[] currentArray, Object key, Object newValue, int hashKey) {

        if (contains(currentArray, key, hashKey)) {
            return false;
        }

        DoublyCircularLinkedList currentList = currentArray[hashKey];

        currentList.add(key, newValue);

        return true;
    }

    public boolean addLf(T key, T newValue){
        int hashKey = getHashCode(key) % this.indexSize;
        boolean result = add(this.index, key, newValue, hashKey);
        if (result){
            //DoublyCircularLinkedList currentList = this.index[index];

            this.size++;

            double currentLoad = ((double) this.size)/indexSize;
            if (currentLoad >= loadFactor){
                rearrangeSet();
            }

        }
        return result;
    }

    private void rearrangeSet() {
        this.indexSize *= 2;
        DoublyCircularLinkedList<T>[] newIndex = new DoublyCircularLinkedList[this.indexSize];
        initArrayLists(newIndex);

        for (DoublyCircularLinkedList<T> currentList : this.index) {
            for (int i = 0; i < currentList.size(); ++i) {
                T key = currentList.get(i);

                T currentItem = currentList.get(i);

                int hashKey = getHashCode(currentItem) % newIndex.length;

                add(newIndex, key , currentItem, hashKey);
            }
        }
        this.index = newIndex;
    }

    public String getDefinition(T key){

        int hashKey = getHashCode(key) % this.indexSize;

        return getDefinition(this.index, key, hashKey);
    }

    public String getDefinition(DoublyCircularLinkedList[] array,  Object newKey, int hashKey){
        DoublyCircularLinkedList currentList = array[hashKey];

        return currentList.getDefinition(newKey);
    }

    public int size() {
        return this.size;
    }
}

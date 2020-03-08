package com.company.dictionary;



import com.company.doublycircularlist.DoublyCircularLinkedList;
import com.company.dictionary.MyLinkedHashMap;

import java.util.LinkedHashMap;

public class Dictionary<T,M>{
    private static final int LIST_SIZE_LIMIT = 3;
    private static final int INIT_ARRAY_SIZE = 10;

    private LinkedHashMap<T, M>[] index;

    private int indexSize;
    private double loadFactor = 0.75;
    private int size;

    public Dictionary() {this.init(INIT_ARRAY_SIZE);}

    /*public Dictionary(int initArraySize) {
        this.init(initArraySize);
    }*/

    private void init(int indexSize) {
        this.indexSize = indexSize;
        this.index = new LinkedHashMap[this.indexSize];
        initArrayLists(this.index);
    }

    private void initArrayLists(LinkedHashMap[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = new LinkedHashMap<>();
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

    public LinkedHashMap<T,M> get(int index) {
        if (this.indexSize <= index) {
            throw new ArrayIndexOutOfBoundsException("Not Found");
        }
        return this.index[index];
    }

    public boolean contains(T newValue) {
        int hashKey = getHashCode(newValue) % this.indexSize;

        return contains(this.index, newValue, hashKey);
    }

    private static boolean contains(LinkedHashMap[] array, Object newValue, int hashKey) {
        LinkedHashMap currentList = array[hashKey];

        return currentList.containsKey(newValue);
    }

    public boolean addTerm(T key, M value){

        int hashKey = getHashCode(key) % this.indexSize;

        boolean result = addTermToList(this.index, key, value, hashKey);

        if (result) {
            LinkedHashMap currentList = this.index[hashKey];

            //fix here for the load factor
            if (currentList.size()/LIST_SIZE_LIMIT > loadFactor) {
                rearrangeDictionary();
            }
            this.size++;
        }
        return result;
    }

    public boolean addTermToList(LinkedHashMap[] currentArray, Object key, Object value, int hashKey){

        if (contains(currentArray, key, hashKey)) {
            return false;
        }

        LinkedHashMap currentList = currentArray[hashKey];

        currentList.put(key, value);

        return true;

    }

    private void rearrangeDictionary(){
        this.indexSize *= 2;
        LinkedHashMap<T,M>[] newIndex = new LinkedHashMap[this.indexSize];
        initArrayLists(newIndex);

        for (LinkedHashMap<T,M> currentList : this.index) {
            currentList.keySet().forEach(key ->{
                int hashKey = getHashCode(key);
                M value = currentList.get(key);
                addTermToList(newIndex, key, value, hashKey);
            });

        }
        this.index = newIndex;
    }

    public String getDefinition(T key){
        int hashKey = getHashCode(key) % this.indexSize;

        String result = getDefinition(this.index, key, hashKey);


        return result;
    }

    public String getDefinition(LinkedHashMap[] array, Object targetKey,int hashKey){

        LinkedHashMap currentList = array[hashKey];

        String result="Not Found";

        if(currentList.containsKey(targetKey)){
            result = currentList.get(targetKey).toString();
        }

        return result;
    }

    public int getSize() {
        return size;
    }
}

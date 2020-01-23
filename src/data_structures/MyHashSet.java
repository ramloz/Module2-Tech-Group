package data_structures;

public class MyHashSet<T> {
    private DoublyCircularLinkedList<T>[] index;
    private Integer indexSize;
    private Integer size;
    private static final Integer INIT_SIZE = 10;

    public MyHashSet(int indexSize) {
        this.indexSize = indexSize;
        initIndex();
    }

    public MyHashSet() {
        this.indexSize = INIT_SIZE;
        initIndex();
    }

    public void initIndex() {
        this.index = new DoublyCircularLinkedList[indexSize];
        this.size = 0;
        for (int i = 0; i < indexSize; i++) {
            this.index[i] = new DoublyCircularLinkedList<T>();
        }
    }

    public int getHashCode(T value) {
        if (value instanceof String) {
            return value.toString().length();
        }
        return (Integer) value;
    }

    public int size() {
        return this.size;
    }

    public boolean add(T element) {
        int hashKey = getHashCode(element) % this.indexSize;
        if (contains(element, hashKey)) return false;
        if (this.size == this.indexSize) {
            this.reInsert();
        }
        DoublyCircularLinkedList<T> currentList = this.index[hashKey];
        currentList.add(element);
        this.size++;
        return true;
    }

    private void reInsert() {
        this.indexSize *= 2;
        DoublyCircularLinkedList<T>[] oldIndex = this.index;
        this.initIndex();
        for (DoublyCircularLinkedList<T> currentList : oldIndex) {
            Node<T> currentNode = currentList.getFirst();
            while (currentNode != null){
                this.add(currentNode.getValue());
                currentNode = currentNode.getNext();
            }
        }
    }

    public int getIndexSize(){
        return this.indexSize;
    }

    public boolean contains(T element) {
        int hashKey = this.getHashCode(element) % this.indexSize;
        DoublyCircularLinkedList indexList = index[hashKey];
        return contains(element, hashKey);
    }

    public boolean contains(T element, int hashKey) {
        DoublyCircularLinkedList currentList = index[hashKey];
        return currentList.contains(element);
    }
}

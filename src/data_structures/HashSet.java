package data_structures;

public class HashSet<T> {
    private DoublyCircularLinkedList<T>[] index;
    private Integer indexSize;
    private Integer size;

    public HashSet(int indexSize){
        this.indexSize = indexSize;
        this.index = new DoublyCircularLinkedList[indexSize];
        this.size = 0;
        for(int i = 0; i < indexSize; i++){
            this.index[i] = new DoublyCircularLinkedList<T>();
        }
    }
    public int hashCode(T value){
        return (Integer) value % this.indexSize;
    }
    public int size(){
        return this.size;
    }
    public void add(T element){
        if(contains(element)) return;
        int elementIndex = hashCode(element);
        DoublyCircularLinkedList<T> list = this.index[elementIndex];
        list.add(element);
        this.size++;
    }
    public boolean contains(T element){
        int elementIndex = hashCode(element);
        DoublyCircularLinkedList indexList = index[elementIndex];
        return indexList.contains(element);
    }
}

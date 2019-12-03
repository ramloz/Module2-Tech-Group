import java.util.LinkedList;

public class Main {
    public static void main(String[] args)
    {
        LinkedList testList = new LinkedList<Integer>();
        LinkedListUtils actions = new LinkedListUtils();
        actions.insertSorted(testList, 1);
        System.out.println(testList);
        actions.insertSorted(testList, 3);
        System.out.println(testList);
        actions.insertSorted(testList, 2);
        System.out.println(testList);
    }
}

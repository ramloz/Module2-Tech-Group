import sun.awt.SunHints;

import javax.naming.LinkException;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value) {

        /* This marker is used in case of the value wasn't insert on the list */
        boolean set = false;
        /* navigate all the components of the list */
        int index = 0;

        while (index <= list.size()) {
            //System.out.println(index);

            if(index == list.size()) {
                list.addLast(value);
                set = true;
                index = index + 1;
            }
            index = index + 1;
        }
        /* if the new value doesn't have a position in the middle of the list then we add the element at the end of the list */
        if(!set) list.addLast(value);


    }


    public static void removeMaximumValues(LinkedList<String> list, int N) {

        /* IMPLEMENT THIS METHOD! */

    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

        /* IMPLEMENT THIS METHOD! */

        return true; // this line is here only so this code will compile if you don't modify it
    }
}


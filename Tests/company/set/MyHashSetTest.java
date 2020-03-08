package company.set;

import com.company.doublycircularlist.DoublyCircularLinkedList;
import com.company.set.MyHashSet;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashSetTest {
    @Test
    public void testHashSetCreation() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        assertEquals(5, myHashSet.getIndexSize());
        DoublyCircularLinkedList<Integer> test = myHashSet.get(2);
        assertNotNull(myHashSet.get(0));
        assertNotNull(myHashSet.get(1));
        assertNotNull(myHashSet.get(2));
        assertNotNull(myHashSet.get(3));
        assertNotNull(myHashSet.get(4));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testHashSetGetNonExistingIndex() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        assertEquals(5, myHashSet.getIndexSize());
        DoublyCircularLinkedList<Integer> test = myHashSet.get(2);
        myHashSet.get(5);
    }

    @Test
    public void testAddHashSetAddSuccess() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        myHashSet.add(10);
        myHashSet.add(5);
        myHashSet.add(4);
        myHashSet.add(2);

        assertEquals(4, myHashSet.size());
    }

    @Test
    public void testContains() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        myHashSet.add(10);
        myHashSet.add(5);
        myHashSet.add(4);
        myHashSet.add(2);

        assertTrue(myHashSet.contains(10));
        assertTrue(myHashSet.contains(4));
        assertFalse(myHashSet.contains(1));
    }

    @Test
    public void testRearrange() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(3);

        myHashSet.add(3);
        myHashSet.add(9);
        myHashSet.add(12);

        assertEquals(3, myHashSet.get(0).size());
        assertEquals(3, myHashSet.getIndexSize());

        myHashSet.add(15);

        assertEquals(1, myHashSet.get(0).size());
        assertEquals(3, myHashSet.get(3).size());
        assertEquals(6, myHashSet.getIndexSize());

        assertTrue(myHashSet.contains(9));
        assertTrue(myHashSet.contains(15));
        assertFalse(myHashSet.contains(18));
    }
}

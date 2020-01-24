package data_structures;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class MyHashSetTest {
    @Test
    public void testAddMethodShouldIncreaseTheSizeOfTheList() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        myHashSet.add(2);
        myHashSet.add(6);
        myHashSet.add(10);

        assertEquals(3, myHashSet.size());
    }

    @Test
    public void testConstainsShouldReturnTrueIfExists() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        myHashSet.add(7);
        myHashSet.add(9);
        myHashSet.add(0);

        assertFalse(myHashSet.contains(1));
        assertTrue(myHashSet.contains(9));
    }

    @Test
    public void testAddStringShouldDuplicateSizeOfHashSet() {
        MyHashSet<String> myHashSet = new MyHashSet<>(3);

        myHashSet.add("hello");
        myHashSet.add("lion");
        myHashSet.add("cat");

        assertEquals("cat", myHashSet.getByIndex(0).getFirst().getValue());
        assertEquals("lion", myHashSet.getByIndex(1).getFirst().getValue());
        assertEquals("hello", myHashSet.getByIndex(2).getFirst().getValue());

        assertTrue(myHashSet.add("hippopotamus"));
        assertEquals("hippopotamus", myHashSet.getByIndex(0).getFirst().getValue());
        assertNull(myHashSet.getByIndex(1).getFirst());
        assertNull(myHashSet.getByIndex(2).getFirst());
        assertEquals("cat", myHashSet.getByIndex(3).getFirst().getValue());
        assertEquals("lion", myHashSet.getByIndex(4).getFirst().getValue());
        assertEquals("hello", myHashSet.getByIndex(5).getFirst().getValue());

        assertEquals(4, myHashSet.size());
        assertEquals(6, myHashSet.getIndexSize());
    }

    @Test
    public void testAddIntegersShouldDuplicateSizeOfHashSet() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(3);

        myHashSet.add(5);
        myHashSet.add(4);
        myHashSet.add(3);

        assertEquals(3, (int) myHashSet.getByIndex(0).getFirst().getValue());
        assertEquals(4, (int) myHashSet.getByIndex(1).getFirst().getValue());
        assertEquals(5, (int) myHashSet.getByIndex(2).getFirst().getValue());

        assertTrue(myHashSet.add(12));
        assertEquals(12, (int) myHashSet.getByIndex(0).getFirst().getValue());
        assertNull(myHashSet.getByIndex(1).getFirst());
        assertNull(myHashSet.getByIndex(2).getFirst());
        assertEquals(3, (int) myHashSet.getByIndex(3).getFirst().getValue());
        assertEquals(4, (int) myHashSet.getByIndex(4).getFirst().getValue());
        assertEquals(5, (int) myHashSet.getByIndex(5).getFirst().getValue());

        assertEquals(4, myHashSet.size());
        assertEquals(6, myHashSet.getIndexSize());
    }
}

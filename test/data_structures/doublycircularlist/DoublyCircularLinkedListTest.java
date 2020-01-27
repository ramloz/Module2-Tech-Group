package data_structures.doublycircularlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyCircularLinkedListTest {
    @Test
    public void testAddMethodShouldIncreaseTheSizeOfTheList() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("sdsdf");
        myLinkedList.add("dsdf");
        myLinkedList.add("hello");

        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void testToString() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("hello");
        myLinkedList.add("gat");
        assertEquals("[world, hello, gat]", myLinkedList.toString());
    }

    @Test
    public void testGetMethodShouldReturnTheValueOfTheNodeOnTheSpecifiedIndex() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("people");
        myLinkedList.add("hello");

        assertEquals("world", myLinkedList.get(0));
        assertEquals("people", myLinkedList.get(1));
        assertEquals("hello", myLinkedList.get(2));
    }

    @Test
    public void testConstainsShouldReturnTrueIfExists() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("people");
        myLinkedList.add("hello");

        assertFalse(myLinkedList.contains("hola"));
        assertTrue(myLinkedList.contains("people"));
    }


    @Test
    public void testClearLinkedList() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("people");
        myLinkedList.add("hello");

        assertEquals(3, myLinkedList.size());
        myLinkedList.clear();
        assertEquals(0, myLinkedList.size());
    }

    @Test
    public void testRemoveElementInTheMiddleOfTheList() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertEquals(3, myLinkedList.size());
        assertEquals("hello", myLinkedList.get(1));

        assertTrue(myLinkedList.remove("hello"));

        assertEquals(2, myLinkedList.size());
        assertEquals("world", myLinkedList.get(1));
    }

    @Test
    public void testRemoveFirstElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertEquals(3, myLinkedList.size());
        assertEquals("people", myLinkedList.get(0));
        assertEquals("people", myLinkedList.getFirst().getValue());

        assertTrue(myLinkedList.remove("people"));

        assertEquals(2, myLinkedList.size());
        assertEquals("hello", myLinkedList.get(0));
        assertEquals("hello", myLinkedList.getFirst().getValue());
    }

    @Test
    public void testRemoveLastElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertEquals(3, myLinkedList.size());
        assertEquals("world", myLinkedList.get(2));
        assertEquals("world", myLinkedList.getLast().getValue());

        assertTrue(myLinkedList.remove("world"));

        assertEquals(2, myLinkedList.size());
        assertEquals("hello", myLinkedList.getLast().getValue());
    }

    @Test
    public void testRemoveNonExistentElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertEquals(3, myLinkedList.size());

        assertFalse(myLinkedList.remove("worlds"));

        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void testRemoveTheOnlyElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");

        assertEquals(1, myLinkedList.size());

        assertTrue(myLinkedList.remove("people"));

        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getFirst());
        assertNull(myLinkedList.getLast());
    }

    @Test
    public void testRemoveMultipleCoincidences() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");
        myLinkedList.add("around");
        myLinkedList.add("the");
        myLinkedList.add("digital");
        myLinkedList.add("people");
        myLinkedList.add("heavy");
        myLinkedList.add("sound");
        myLinkedList.add("safe");
        myLinkedList.add("world");
        myLinkedList.add("people");

        assertEquals(12, myLinkedList.size());
        assertEquals("people", myLinkedList.get(0));
        assertEquals("people", myLinkedList.getFirst().getValue());
        assertEquals("people", myLinkedList.get(11));
        assertEquals("people", myLinkedList.getLast().getValue());
        assertEquals("people", myLinkedList.get(6));


        assertTrue(myLinkedList.remove("people"));

        assertEquals(9, myLinkedList.size());
        assertEquals("hello", myLinkedList.get(0));
        assertEquals("hello", myLinkedList.getFirst().getValue());
        assertEquals("world", myLinkedList.get(8));
        assertEquals("world", myLinkedList.getLast().getValue());
        assertEquals("sound", myLinkedList.get(6));
    }
}

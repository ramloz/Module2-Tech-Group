package doublycircularlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoublyCircularLinkedListTest {

    @Test
    public void testAddMethodShouldIncreaseTheSizeOfTheList() {
        DoublyCircularLinkedList<String> myList = new DoublyCircularLinkedList<>();

        myList.add("sdsdf");
        myList.add("dsdf");
        myList.add("hello");

        assertEquals(3, myList.getSize());
    }

    @Test
    public void testToString() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();
        assertEquals("[]", myLinkedList.toString());
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

        assertEquals(3, myLinkedList.getSize());
        myLinkedList.clear();
        assertEquals(0, myLinkedList.getSize());
    }

    @Test
    public void testRemoveElementInTheMiddleOfTheList() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertEquals(3, myLinkedList.getSize());
        assertEquals("hello", myLinkedList.get(1));

        assertTrue(myLinkedList.remove("hello"));

        assertEquals(2, myLinkedList.getSize());
        assertEquals("world", myLinkedList.get(1));
    }

    @Test
    public void testRemoveFirstElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertEquals(3, myLinkedList.getSize());
        assertEquals("people", myLinkedList.get(0));
        assertEquals("people", myLinkedList.getFirst().getValue());

        assertTrue(myLinkedList.remove("people"));

        assertEquals(2, myLinkedList.getSize());
        assertEquals("hello", myLinkedList.get(0));
        assertEquals("hello", myLinkedList.getFirst().getValue());
    }

    @Test
    public void testRemoveLastElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertEquals(3, myLinkedList.getSize());
        assertEquals("world", myLinkedList.get(2));
        assertEquals("world", myLinkedList.getLast().getValue());

        assertTrue(myLinkedList.remove("world"));

        assertEquals(2, myLinkedList.getSize());
        assertEquals("hello", myLinkedList.getLast().getValue());
    }

    @Test
    public void testRemoveNonExistentElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertEquals(3, myLinkedList.getSize());

        assertFalse(myLinkedList.remove("worlds"));

        assertEquals(3, myLinkedList.getSize());
    }

    @Test
    public void testRemoveTheOnlyElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people");

        assertEquals(1, myLinkedList.getSize());

        assertTrue(myLinkedList.remove("people"));

        assertEquals(0, myLinkedList.getSize());
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

        assertEquals(12, myLinkedList.getSize());
        assertEquals("people", myLinkedList.get(0));
        assertEquals("people", myLinkedList.getFirst().getValue());
        assertEquals("people", myLinkedList.get(11));
        assertEquals("people", myLinkedList.getLast().getValue());
        assertEquals("people", myLinkedList.get(6));


        assertTrue(myLinkedList.remove("people"));

        assertEquals(9, myLinkedList.getSize());
        assertEquals("hello", myLinkedList.get(0));
        assertEquals("hello", myLinkedList.getFirst().getValue());
        assertEquals("world", myLinkedList.get(8));
        assertEquals("world", myLinkedList.getLast().getValue());
        assertEquals("sound", myLinkedList.get(6));
    }
}

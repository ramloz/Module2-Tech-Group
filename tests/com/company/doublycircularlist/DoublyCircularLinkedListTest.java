package com.company.doublycircularlist;

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
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("Car", "Ground method of transport");
        myLinkedList.add("Airplane", "Aerial method of transport");
        myLinkedList.add("hello", "Common way to salutate");

        assertEquals(3, myLinkedList.size());
    }

    /*@Test
    public void testToString() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("hello");
        myLinkedList.add("gat");
        assertEquals("[world, hello, gat]", myLinkedList.toString());
    }*/

    @Test
    public void testGetMethodShouldReturnTheValueOfTheNodeOnTheSpecifiedIndex() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("world", "Our planet");
        myLinkedList.add("people", "human beens");
        myLinkedList.add("hello", "Common way to salutate");

        assertEquals("world", myLinkedList.get(0));
        assertEquals("people", myLinkedList.get(1));
        assertEquals("hello", myLinkedList.get(2));
    }

    @Test
    public void testConstainsShouldReturnTrueIfExists() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("world", "Our planet");
        myLinkedList.add("people", "human beens");
        myLinkedList.add("hello", "Common way to salutate");

        assertFalse(myLinkedList.contains("hola"));
        assertTrue(myLinkedList.contains("people"));
    }


    @Test
    public void testClearLinkedList() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("world", "Our planet");
        myLinkedList.add("people", "human beens");
        myLinkedList.add("hello", "Common way to salutate");

        assertEquals(3, myLinkedList.size());
        myLinkedList.clear();
        assertEquals(0, myLinkedList.size());
    }

    @Test
    public void testRemoveElementInTheMiddleOfTheList() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("world", "Our planet");
        myLinkedList.add("people", "human beens");
        myLinkedList.add("hello", "Common way to salutate");

        assertEquals(3, myLinkedList.size());
        assertEquals("people", myLinkedList.get(1));

        assertTrue(myLinkedList.remove("hello"));

        assertEquals(2, myLinkedList.size());
        assertEquals("world", myLinkedList.get(0));
    }

    @Test
    public void testRemoveFirstElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people", "human beens");
        myLinkedList.add("hello", "Common way to salutate");
        myLinkedList.add("world", "Our planet");

        assertEquals(3, myLinkedList.size());
        assertEquals("people", myLinkedList.get(0));
        assertEquals("people", myLinkedList.getFirst().getKey());

        assertTrue(myLinkedList.remove("people"));

        assertEquals(2, myLinkedList.size());
        assertEquals("hello", myLinkedList.get(0));
        assertEquals("hello", myLinkedList.getFirst().getKey());
    }

    @Test
    public void testRemoveLastElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people", "human beens");
        myLinkedList.add("hello", "Common way to salutate");
        myLinkedList.add("world", "Our planet");

        assertEquals(3, myLinkedList.size());
        assertEquals("world", myLinkedList.get(2));
        assertEquals("world", myLinkedList.getLast().getKey());

        assertTrue(myLinkedList.remove("world"));

        assertEquals(2, myLinkedList.size());
        assertEquals("hello", myLinkedList.getLast().getKey());
    }

    @Test
    public void testRemoveNonExistentElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people", "human beens");
        myLinkedList.add("hello", "Common way to salutate");
        myLinkedList.add("world", "Our planet");

        assertEquals(3, myLinkedList.size());

        assertFalse(myLinkedList.remove("worlds"));

        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void testRemoveTheOnlyElement() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people", "human beens");

        assertEquals(1, myLinkedList.size());

        assertTrue(myLinkedList.remove("people"));

        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getFirst());
        assertNull(myLinkedList.getLast());
    }

    @Test
    public void testRemoveMultipleCoincidences() {
        DoublyCircularLinkedList<String> myLinkedList = new DoublyCircularLinkedList<>();

        myLinkedList.add("people", "human beens");
        myLinkedList.add("hello", "Common way to salutate");
        myLinkedList.add("world", "Our planet");
        myLinkedList.add("around", "The space outside of an object");
        myLinkedList.add("the", "common word");
        myLinkedList.add("digital", "based on numeric codification");
        myLinkedList.add("people", "human beens");
        myLinkedList.add("heavy", "An object with more weight");
        myLinkedList.add("sound", "A wave of energy that can travel on air or water");
        myLinkedList.add("safe", "keep under security");
        myLinkedList.add("world", "Our planet");
        myLinkedList.add("people", "human beens");

        assertEquals(12, myLinkedList.size());
        assertEquals("people", myLinkedList.get(0));
        assertEquals("people", myLinkedList.getFirst().getKey());
        assertEquals("people", myLinkedList.get(11));
        assertEquals("people", myLinkedList.getLast().getKey());
        assertEquals("people", myLinkedList.get(6));


        assertTrue(myLinkedList.remove("people"));

        assertEquals(9, myLinkedList.size());
        assertEquals("hello", myLinkedList.get(0));
        assertEquals("hello", myLinkedList.getFirst().getKey());
        assertEquals("world", myLinkedList.get(8));
        assertEquals("world", myLinkedList.getLast().getKey());
        assertEquals("sound", myLinkedList.get(6));
    }
}

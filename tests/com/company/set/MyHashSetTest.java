package com.company.set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.company.doublycircularlist.DoublyCircularLinkedList;
import com.company.doublycircularlist.Node;
import org.junit.Test;

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

        myHashSet.add(10, 10);
        myHashSet.add(5, 5);
        myHashSet.add(4, 4);
        myHashSet.add(2,2);

        assertEquals(4, myHashSet.size());
    }

    @Test
    public void testAddHashSetAddStrings() {
        MyHashSet<String> myHashSet = new MyHashSet<>(5);

        myHashSet.add("car", "Ground method of transport");
        myHashSet.add("Hello", "Common way to saludate");
        myHashSet.add("Airplane", "An aerial method of transport");
        myHashSet.add("People","Human Beens");

        assertEquals(4, myHashSet.size());
    }

    @Test
    public void testAddLfHashSetAddSuccess() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        myHashSet.addLf(10,10);
        myHashSet.addLf(5, 5);
        myHashSet.addLf(4,4);
        myHashSet.addLf(2,2);

        assertEquals(4, myHashSet.size());
    }

    @Test
    public void testAddLfHashSetAddStrings() {
        MyHashSet<String> myHashSet = new MyHashSet<>(5);

        myHashSet.addLf("car", "Ground method of transport");
        myHashSet.addLf("Hello", "Common way to saludate");
        myHashSet.addLf("Airplane", "An aerial method of transport");
        myHashSet.addLf("People","Human Beens");

        assertEquals(4, myHashSet.size());
    }

    @Test
    public void testContains() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        myHashSet.add(10,10);
        myHashSet.add(5,5);
        myHashSet.add(4,4);
        myHashSet.add(2,2);

        assertTrue(myHashSet.contains(10));
        assertTrue(myHashSet.contains(4));
        assertFalse(myHashSet.contains(1));
    }

    @Test
    public void testContainsStrings() {
        MyHashSet<String> myHashSet = new MyHashSet<>(5);

        myHashSet.addLf("car", "Ground method of transport");
        myHashSet.addLf("Hello", "Common way to saludate");
        myHashSet.addLf("Airplane", "An aerial method of transport");
        myHashSet.addLf("People","Human Beens");

        assertTrue(myHashSet.contains("car"));
        assertTrue(myHashSet.contains("Hello"));
        assertFalse(myHashSet.contains("Hola"));
    }

    @Test
    public void testGetDefinition(){
        MyHashSet<String> myHashSet = new MyHashSet<>(5);

        myHashSet.add("car", "Ground method of transport");
        myHashSet.add("Hello", "Common way to saludate");
        myHashSet.add("Airplane", "An aerial method of transport");
        myHashSet.add("People","Human Beens");

        assertEquals("Ground method of transport", myHashSet.getDefinition("car"));
        assertEquals("Not found", myHashSet.getDefinition("auto"));
    }

    @Test
    public void testRearrange() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(3);

        myHashSet.add(3,3);
        myHashSet.add(9,9);
        myHashSet.add(12,12);

        assertEquals(3, myHashSet.get(0).size());
        assertEquals(3, myHashSet.getIndexSize());

        myHashSet.add(15,15);

        assertEquals(1, myHashSet.get(0).size());
        assertEquals(3, myHashSet.get(3).size());
        assertEquals(6, myHashSet.getIndexSize());

        assertTrue(myHashSet.contains(9));
        assertTrue(myHashSet.contains(15));
        assertFalse(myHashSet.contains(18));
    }

    @Test
    public void testRearrangeLf() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(3);

        myHashSet.addLf(3,3);
        myHashSet.addLf(9,9);
        //myHashSet.addLf(12);


        assertEquals(2, myHashSet.get(0).size());
        assertEquals(3, myHashSet.getIndexSize());

        myHashSet.addLf(15,15);

        assertEquals(0, myHashSet.get(0).size());
        assertEquals(3, myHashSet.get(3).size());
        assertEquals(6, myHashSet.getIndexSize());

        assertTrue(myHashSet.contains(9));
        assertTrue(myHashSet.contains(15));
        assertFalse(myHashSet.contains(18));
    }
}

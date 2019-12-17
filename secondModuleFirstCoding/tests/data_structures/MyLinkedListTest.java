package data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


import data_structures.MyLinkedList;
import data_structures.Node;
import org.junit.jupiter.api.Test;
import sun.net.www.content.text.Generic;


public class MyLinkedListTest {

    @Test
    public void testAddMethodShouldIncreaseTheSizeOfTheList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("sdsdf");
        myLinkedList.add("dsdf");
        myLinkedList.add("hello");

        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void testToString() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("hello");
        myLinkedList.add("gat");
        assertEquals("[world, hello, gat]", myLinkedList.toString());
    }

    @Test
    public void testGetMethodShouldReturnTheValueOfTheNodeOnTheSpecifiedIndex() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("people");
        myLinkedList.add("hello");

        assertEquals("world", myLinkedList.get(0));
        assertEquals("people", myLinkedList.get(1));
        assertEquals("hello", myLinkedList.get(2));
    }

    @Test
    public void testConstainsShouldReturnTrueIfExists() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("people");
        myLinkedList.add("hello");

        assertFalse(myLinkedList.contains("hola"));
        assertTrue(myLinkedList.contains("people"));
    }

    @Test
    public void testClearLinkedList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("world");
        myLinkedList.add("people");
        myLinkedList.add("hello");

        assertEquals(3, myLinkedList.size());
        myLinkedList.clear();
        assertEquals(0, myLinkedList.size());
    }

    @Test
    public void testRemoveElementInTheMiddleOfTheList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

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
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

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
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

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
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("people");
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertEquals(3, myLinkedList.size());

        assertFalse(myLinkedList.remove("worlds"));

        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void testRemoveTheOnlyElement() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("people");

        assertEquals(1, myLinkedList.size());

        assertTrue(myLinkedList.remove("people"));

        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getFirst());
        assertNull(myLinkedList.getLast());
    }

    @Test
    public void testRemoveMultipleCoincidences() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

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
        assertNull(myLinkedList.getLast().getNext());
    }

    @Test
    void TestAdd(){
        MyLinkedList list = new MyLinkedList<>();

        list.add("asdfgasf");
        list.add("hello");
        list.add("asqtga");
        assertEquals(3 , list.size());
        list.add(1);
        list.add(true);
        list.add('a');
        assertEquals(6 , list.size());
    }

    @Test
    void getNext(){
        MyLinkedList list = new MyLinkedList<>();
        list.add("Node 1");
        Node node = new Node("");
        node = list.getFirst();
        assertNull(node.getNext());
        list.add("Node 2");
        node = list.getFirst();
        Node nextNode = new Node("");
        nextNode = node.getNext();
        assertEquals("Node 2", nextNode.getValue());
    }

    @Test
    void get(){
        MyLinkedList list = new MyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () ->{
            String test = list.get(0).toString();
        });
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () ->{
            String test = list.get(1).toString();
        });
        list.add("b");
        list.add('c');
        assertEquals(1, list.get(0));
        assertEquals("b", list.get(1));
        assertEquals('c', list.get(2));
    }

    @Test
    void getFirst(){
        MyLinkedList list = new MyLinkedList<>();
        assertNull(list.getFirst());
        list.add("Node 1");
        assertNotNull(list.getFirst());
        assertEquals("Node 1", list.getFirst().getValue().toString());
        list.add("Node 2");
        list.add("Node 3");
        assertEquals("Node 1", list.getFirst().getValue().toString());
    }


    @Test
    void getLast(){
        MyLinkedList list = new MyLinkedList<>();
        assertNull(list.getLast());
        list.add("Node 1");
        assertEquals("Node 1" , list.getLast().getValue().toString());
        list.add("Node 2");
        list.add("Node 3");
        assertNotEquals("Node 1", list.getLast().getValue().toString());
        assertEquals("Node 3", list.getLast().getValue().toString());
    }

    @Test
    void getSize(){
        MyLinkedList list = new MyLinkedList<>();
        assertEquals(0, list.getSize());
        list.add("Node 1");
        list.add("Node 2");
        list.add("Node 3");
        assertEquals(3, list.getSize());
    }

    @Test
    void isEmpty(){
        MyLinkedList list = new MyLinkedList();
        assertTrue(list.isEmpty());
        list.add("fill");
        assertFalse(list.isEmpty());
    }

    @Test
    void contains(){
        MyLinkedList list = new MyLinkedList();
        assertFalse(list.contains("Node 1"));
        list.add("Node 1");
        assertTrue(list.contains("Node 1"));
        list.add(1);
        list.add('a');
        list.add(false);
        assertTrue(list.contains(1));
        assertTrue(list.contains('a'));
        assertTrue(list.contains(false));
    }

    @Test
    void positionedAdd(){
        MyLinkedList list = new MyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () ->{
            list.add(1, "invalid");
        });

        list.add(0, "valid");
        assertEquals("valid", list.getFirst().getValue());
        assertEquals("valid", list.getLast().getValue());
        assertEquals("valid", list.get(0));
        list.add(0, "new_first");
        assertEquals("new_first", list.getFirst().getValue());
        assertEquals("new_first", list.get(0));
        list.add(1, "now_valid");
        assertEquals("now_valid", list.get(1));
        assertEquals("valid", list.getLast().getValue());
        list.add(1, "new_valid");
        assertEquals("new_valid", list.get(1));
        assertEquals("valid", list.getLast().getValue());
        assertEquals("new_first", list.getFirst().getValue());
    }



}

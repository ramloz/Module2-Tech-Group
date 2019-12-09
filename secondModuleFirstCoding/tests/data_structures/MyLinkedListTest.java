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
        assertFalse(list.contains("Node 1", list));
        list.add("Node 1");
        assertTrue(list.contains("Node 1", list));
        list.add(1);
        list.add('a');
        list.add(false);
        assertTrue(list.contains(1, list));
        assertTrue(list.contains('a', list));
        assertTrue(list.contains(false, list));
    }



}

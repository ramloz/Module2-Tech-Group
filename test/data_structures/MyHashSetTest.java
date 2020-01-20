package data_structures;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}

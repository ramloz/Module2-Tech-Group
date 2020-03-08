package company.dictionary;

import org.junit.Test;
import com.company.dictionary.Dictionary;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void dictionaryAdd(){
        Dictionary<String, String> myDictionary = new Dictionary<>();

        myDictionary.addTerm("Car", "Land transport");
        myDictionary.addTerm("dog", "a domestic animal");
        myDictionary.addTerm("Plane", "Aerial transport");
        myDictionary.addTerm("On", "button to turn on");
        myDictionary.addTerm("book", "Source of printed information");
        myDictionary.addTerm("Chemistry", "Branch of the science");

        assertEquals(6, myDictionary.getSize());
        assertEquals(0, myDictionary.get(0).size());
        assertEquals(2, myDictionary.get(3).size());
        assertEquals(1, myDictionary.get(2).size());
        assertEquals(1, myDictionary.get(4).size());
        assertEquals(1, myDictionary.get(9).size());
    }

    @Test
    public void testContains() {
        Dictionary<String, String> myDictionary = new Dictionary<>();

        myDictionary.addTerm("Car", "Land transport");
        myDictionary.addTerm("dog", "a domestic animal");
        myDictionary.addTerm("Plane", "Aerial transport");

        assertTrue(myDictionary.contains("Car"));
        assertTrue(myDictionary.contains("dog"));
        assertFalse(myDictionary.contains("none"));
    }

    @Test
    public void testRearrange() {
        Dictionary<String, String> myDictionary = new Dictionary<>();

        myDictionary.addTerm("Car", "Land transport");
        myDictionary.addTerm("dog", "a domestic animal");
        myDictionary.addTerm("Plane", "Aerial transport");

        assertEquals(10, myDictionary.getIndexSize());
        assertEquals(2, myDictionary.get(3).size());


        myDictionary.addTerm("for", "Common auxiliary word");

        assertEquals(0, myDictionary.get(0).size());
        assertEquals(3, myDictionary.get(3).size());
        assertEquals(20, myDictionary.getIndexSize());
    }

    @Test
    public void testGetDefinition(){
        Dictionary<String, String> myDictionary = new Dictionary<>();

        myDictionary.addTerm("Car", "Land transport");
        myDictionary.addTerm("dog", "a domestic animal");
        myDictionary.addTerm("Plane", "Aerial transport");
        myDictionary.addTerm("Chemistry", "Branch of the science");

        assertEquals("Land transport", myDictionary.getDefinition("Car"));
        assertEquals("Aerial transport", myDictionary.getDefinition("Plane"));
        assertEquals("Branch of the science", myDictionary.getDefinition("Chemistry"));
        assertEquals("Not Found", myDictionary.getDefinition("Defect"));
    }

}

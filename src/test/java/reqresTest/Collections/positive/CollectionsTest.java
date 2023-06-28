package reqresTest.Collections.positive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CollectionsTest {

    @Test
    public void arrayListTest() {
        ArrayList birds = new ArrayList();
        birds.add("Канарейка");
        birds.add("Канарейка");
        birds.add(0, "Ворон");

        //add

        //generic
        ArrayList<String> birds1 = new ArrayList();

        // remove
        birds.remove(0);
        birds.remove("Сорока");

        // set
        birds.equals("Ворона");

        // clear
        // isEmpty
        // size
        // contains
        // equals
    }

    @Test
    public void linkedListTest() {
        LinkedList<String> birds = new LinkedList();
        birds.add("Канарейка");
        birds.add("Канарейка");
        birds.add(0, "Ворон");

        //add

        //generic
        ArrayList<String> birds1 = new ArrayList();

        // remove
        birds.remove(0);
        birds.remove("Сорока");

        // set
        birds.equals("Ворона");

        // clear
        // isEmpty
        // size
        // contains
        // equals
    }

    @Test
    public void setHashTest() {
        Set<String> birds = new HashSet<>();
        birds.add("Канарейка");
        birds.add("Канарейка");
        birds.add("Ворон");

        //add

        //generic
        ArrayList<String> birds1 = new ArrayList();

        // remove
        birds.remove(0);
        birds.remove("Сорока");

        // set
        birds.equals("Ворона");

        // clear
        // isEmpty
        // size
        // contains
        // equals
    }
}

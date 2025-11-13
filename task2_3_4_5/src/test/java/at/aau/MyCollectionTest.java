package at.aau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyCollectionTest {
    @Test
    void removeItemTest() {
        MyCollection coll = new MyCollection(3);
        coll.add("a");
        coll.add("b");
        coll.add("c");

        assertEquals(3, coll.size());

        // remove an element then check size is reduced
        coll.remove("b");
        assertEquals(2, coll.size());
    }

    @Test
    void emptyTest() {
        MyCollection coll = new MyCollection(2);
        coll.add("a");
        coll.add("b");
        assertEquals(2, coll.size());

        coll.empty();
        assertEquals(0, coll.size());

        coll.add("new");
        assertEquals(1, coll.size());
    }


    @Test
    void removeFromEmptyTest() {
        MyCollection coll = new MyCollection(1);
        assertThrows(IllegalArgumentException.class, () -> coll.remove("y"));
    }

    @Test
    void removeNonExistentTest() {
        MyCollection coll = new MyCollection(1);
        coll.add("x");
        assertThrows(IllegalArgumentException.class, () -> coll.remove("y"));
    }
}

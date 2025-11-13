package at.aau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}

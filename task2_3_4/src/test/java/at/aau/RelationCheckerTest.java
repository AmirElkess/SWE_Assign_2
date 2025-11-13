package at.aau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RelationCheckerTest {
    @Test
    void testCase1() {
        assertEquals(0, RelationChecker.checkRelation(0, 0));
    }

    @Test
    void testCase2() {
        assertEquals(22, RelationChecker.checkRelation(10, 17));
    }
}

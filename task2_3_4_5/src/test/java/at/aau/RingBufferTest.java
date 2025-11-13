package at.aau;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class RingBufferTest {

    @Test
    void iteratorTest1() {
        RingBuffer<Integer> ring = new RingBuffer<>(3);
        ring.push(1);
        ring.push(2);
        ring.push(3);
        ring.pop();
        ring.push(4);

        // after popping 1 and pushing 4, the buffer internally contains [4, 2, 3],
        // but iterator should start at index 1, then iterate over index 2 then 0 (the wrap around)
        // this test fails for the current iterator implementation
        Iterator<Integer> it = ring.iterator();
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertEquals(4, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void iteratorTest2() {
        RingBuffer<String> ring = new RingBuffer<>(4);
        ring.push("A");
        ring.push("B");
        ring.push("C");
        ring.pop();
        ring.pop();

        // after popping A and B, the buffer internally contains [null, null, C, null],
        // but iterator should start at index 2 containing "C"
        // this test also fails.
        Iterator<String> it = ring.iterator();
        assertEquals("C", it.next());
    }

    @Test
    void constructorCapacityTest() {
        assertThrows(Exception.class, () -> new RingBuffer<>(-1));
        assertThrows(Exception.class, () -> new RingBuffer<>(0));
        assertDoesNotThrow(() -> new RingBuffer<>(1));
    }

    @Test
    void singleElementTest() {
        RingBuffer<Integer> ring = new RingBuffer<>(1);
        ring.push(42);
        assertEquals(1, ring.size());
        assertEquals(42, ring.pop());
        assertTrue(ring.isEmpty());
    }

    @Test
    void popEmptyBufferTest() {
        RingBuffer<Integer> ring = new RingBuffer<>(3);
        assertThrows(RuntimeException.class, ring::pop,
                "Ring buffer underflow");
    }

    @Test
    void pushFullBufferTest() {
        RingBuffer<Integer> ring = new RingBuffer<>(2);
        ring.push(1);
        ring.push(2);
        assertThrows(RuntimeException.class, () -> ring.push(3),
                "Ring buffer overflow");
    }
}

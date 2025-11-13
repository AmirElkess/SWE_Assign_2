package at.aau;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ring buffer (fixed size queue) implementation using a circular array (array
 * with wrap-around).
 * This is a corrected version of RingBuffer for doing the full branch coverage exercise.
 */
// suppress unchecked warnings in Java 1.5.0_6 and later
@SuppressWarnings("unchecked")
public class NonFaultyRingBuffer<T> implements Iterable<T> {
    private T[] buffer;          // queue elements
    private int count = 0;          // number of elements on queue
    private int indexOut = 0;       // index of first element of queue
    private int indexIn = 0;       // index of next available slot

    // cast needed since no generic array creation in Java
    public NonFaultyRingBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be > 0");
        }
        buffer = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void push(T item) {
        if (count == buffer.length) {
            throw new RuntimeException("Ring buffer overflow");
        }
        buffer[indexIn] = item;
        indexIn = (indexIn + 1) % buffer.length;     // wrap-around
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T item = buffer[indexOut];
        buffer[indexOut] = null;                  // to help with garbage collection
        count--;
        indexOut = (indexOut + 1) % buffer.length; // wrap-around
        return item;
    }

    public Iterator<T> iterator() {
        return new RingBufferIterator();
    }

    private class RingBufferIterator implements Iterator<T> {
        private final int start = indexOut;
        private final int snapshotCount = count;
        private int i = 0;

        public boolean hasNext() {
            return i < snapshotCount;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = buffer[(start + i) % buffer.length];
            i++;
            return item;
        }
    }
}
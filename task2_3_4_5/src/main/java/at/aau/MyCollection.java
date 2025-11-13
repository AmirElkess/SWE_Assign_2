package at.aau;

public class MyCollection {
    private String[] list;
    private int cursor = 0;

    public MyCollection(int capacity) {
        list = new String[capacity];
        cursor = 0;
    }

    /**
     * Returns the size of the collection
     *
     * @return The number of instances in the collection
     */
    public int size() {
        return cursor;
    }

    /**
     * Adds the String from to list. If the list is full it throws an IllegalArgumentException
     *
     * @param s String to remove
     */
    public void add(String s) {
        list[cursor++] = s;
    }

    /**
     * Removes the String from the list. If the String is not in the list it throws an
     * IllegalArgumentException. If the list is empty it throws an IllegalArgumentException
     *
     * @param s String to remove
     */
    public void remove(String s) throws IllegalArgumentException {
        if (cursor == 0) {
            throw new IllegalArgumentException("Collection is empty");
        }

        for (int i = 0; i < cursor; i++) {
            if (java.util.Objects.equals(list[i], s)) {
                for (int j = i; j < cursor - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[cursor - 1] = null;
                cursor--;
                return;
            }
        }

        throw new IllegalArgumentException("Element not found: " + s);
    }


    /**
     * Removes all items from the list and initializes a new list
     */
    public void empty() {
        list = new String[list.length];
        cursor = 0;
    }
}
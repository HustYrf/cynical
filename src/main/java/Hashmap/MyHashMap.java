package Hashmap;

import java.util.ArrayList;

/**
 * a concrete class named MyHashMap that implements AbsHashMap
 */
public class MyHashMap extends AbsHashMap<ArrayList<Entry>> {
    /**
     * number of entries
     */
    private int size;

    /**
     * initial Capacity
     */
    private int initialCapacity;

    /**
     * Parameterized constructor,initialize class attributes
     *
     * @param initialCapacity initial Capacity
     */
    public MyHashMap(int initialCapacity) {
        super(initialCapacity);
        this.initialCapacity = initialCapacity;
        size = 0;
        for (int i = 0; i < initialCapacity; i++) {
            table[i] = new ArrayList<>();
        }
    }

    /**
     * get size
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * judge whether is empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * get value by key,
     *
     * @param key key
     * @return Returns the value v associated with key k
     */
    public Integer get(Integer key) {
        if (isEmpty()) return null;
        long currentTime = System.nanoTime();
        int keyHashCode = hashCode(key);
        int index = modN(keyHashCode);
        ArrayList<Entry> entries = table[index];
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.getKey().equals(key)) {
                printlnTime("Get", currentTime, System.nanoTime());
                return entry.getValue();
            }
        }
        printlnTime("Get", currentTime, System.nanoTime());
        return null;
    }

    /**
     * put key,value into entry
     *
     * @param key   entry key
     * @param value entry value
     * @return returns the old value.
     */
    public Integer put(Integer key, Integer value) {
        try {
            long currentTime = System.nanoTime();
            int collision = 0;
            int keyHashCode = hashCode(key);
            int index = modN(keyHashCode);
            ArrayList<Entry> entries = table[index];
            for (int i = 0; i < entries.size(); i++) {
                Entry entry = entries.get(i);
                if (entry.getKey().equals(key)) {
                    Integer oldVal = entry.getValue();
                    if (System.nanoTime() - currentTime > Integer.MAX_VALUE) {
                        throw new RuntimeException();
                    }
                    entry.setValue(value);
                    System.out.println(size + " " + entries.size() + " " + collision + " " + (System.nanoTime() - currentTime));
                    return oldVal;
                }
                System.out.println(entry.toString() + ",the number of collisions is " + collision);
                collision++;
            }
            if (System.nanoTime() - currentTime > Integer.MAX_VALUE) {
                throw new RuntimeException();
            }
            entries.add(new Entry(key, value));
            size++;
            System.out.println(size + " " + entries.size() + " " + collision + " " + (System.nanoTime() - currentTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * remove entry by key
     *
     * @param key entry key
     * @return returns its value
     */
    public Integer remove(Integer key) {
        long currentTime = System.nanoTime();
        int keyHashCode = hashCode(key);
        int index = modN(keyHashCode);
        ArrayList<Entry> entries = table[index];
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.getKey().equals(key)) {
                Integer oldVal = entry.getValue();
                entries.remove(entry);
                size--;
                printlnTime("Remove", currentTime, System.nanoTime());
                return oldVal;
            }
        }
        printlnTime("Remove", currentTime, System.nanoTime());
        return null;
    }

    /**
     * uses the function h(k) = k mod N as the hash (compression) function
     *
     * @param keyHashCode key Hash Code
     * @return h(k)
     */
    private int modN(int keyHashCode) {
        return Math.abs(keyHashCode % initialCapacity);
    }

    /**
     * key`s hashcode
     *
     * @param key key
     * @return hash code
     */
    private int hashCode(Integer key) {
        int keyHashCode = key.hashCode();
        return (keyHashCode << 9) | (keyHashCode >>> 23);
    }

    /**
     * print the time used to run the method
     *
     * @param methodName  method Name
     * @param currentTime start Time
     * @param endTime     end time
     */
    private void printlnTime(String methodName, long currentTime, long endTime) {
        System.out.println("Method " + methodName + " run the method used time " + (endTime - currentTime) + " ns");
    }
}

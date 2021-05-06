package Hashmap;

import java.util.Objects;

/**
 * a class Entry to represent <Key, Value> entry pairs in the hash map
 */
public class Entry {
    private Integer key;
    private Integer value;

    /**
     * A constructor that generates a new Entry object using a random integer
     */
    public Entry() {
        this.key = getRandomNum();
        this.value = getRandomNum();
    }

    /**
     * Parameterized constructor
     *
     * @param key   key
     * @param value value
     */
    public Entry(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    /**
     * get Key
     *
     * @return
     */
    public Integer getKey() {
        return key;
    }

    /**
     * get Value
     *
     * @return
     */
    public Integer getValue() {
        return value;
    }

    /**
     * set Value
     *
     * @param value
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Override toString method
     *
     * @return
     */
    @Override
    public String toString() {
        return "Entry(" + key + "," + value + ")";
    }


    /**
     * equals method
     *
     * @param o Object
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
    }

    /**
     * hashCode method
     *
     * @return
     */
    @Override
    public int hashCode() {
        int h = key.hashCode();
        return (h << 9) | (h >>> 23);
    }

    /**
     * get Random Number
     *
     * @return Numbers within 1000
     */
    private int getRandomNum() {
        int floor = (int) Math.floor(Math.random() * 1000 + 1);
        return floor;
    }
}

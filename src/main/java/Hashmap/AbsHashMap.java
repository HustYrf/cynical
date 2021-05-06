package Hashmap;

import java.util.ArrayList;

/**
 * This abstract class models a hash table without providing any concrete representation of the
 * underlying data structure of a table of “buckets.”
 *
 * @param <T>
 */
public abstract class AbsHashMap<T> {

    /**
     * buckets hash table
     */
    ArrayList<Entry>[] table;

    /**
     * a constructor that accepts the initial capacity for the hash table as a
     * parameter
     *
     * @param initialCapacity
     */
    public AbsHashMap(int initialCapacity) {
        this.table = new ArrayList[initialCapacity];
    }

    /**
     * get size
     *
     * @return
     */
    public abstract int size();

    /**
     * judge whthere is empty
     *
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * get value by key
     *
     * @param key key
     * @return
     */
    public abstract Integer get(Integer key);

    /**
     * put key,value into entry
     *
     * @param key   entry key
     * @param value entry value
     * @return
     */
    public abstract Integer put(Integer key, Integer value);

    /**
     * remove entry by key
     *
     * @param key entry key
     * @return
     */
    public abstract Integer remove(Integer key);

}

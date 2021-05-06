package Hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MyHashMap Driver
 */
public class HashMapDriver {
    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        validate();
        experiment_interpret();
    }

    /**
     * validate method
     */
    public static void validate() {
        List<Entry> data = new ArrayList<>();
        //a Create a local Java.util ArrayList (say, data) of 50 random <Key, Value> pairs.
        for (int i = 0; i < 50; i++) {
            data.add(new Entry());
        }
        //b Create a MyHashMap object using 100 as the initial capacity (N) of the hash map
        MyHashMap myHashMap = new MyHashMap(100);

        //c Add all 50 entries from the data array to the map, using the put(k,v) method, of course
        for (int i = 0; i < 50; i++) {
            Entry entry = data.get(i);
            myHashMap.put(entry.getKey(), entry.getValue());
        }

        //d Run get(k) on each of the 50 elements in data
        for (int i = 0; i < 50; i++) {
            Entry entry = data.get(i);
            myHashMap.get(entry.getKey());
        }

        //e  Run remove(k) on the first 25 keys, followed by get(k) on each of the 50 keys.
        for (int i = 0; i < 25; i++) {
            Entry entry = data.get(i);
            myHashMap.remove(entry.getKey());
        }
    }

    /**
     * experiment interpret method
     */
    public static void experiment_interpret() {
        List<Entry> data = new ArrayList<>();

        //a Create a hash map of initial capacity 100
        MyHashMap myHashMap = new MyHashMap(100);

        //b Create a local Java.util ArrayList (say, data) of 150 random <Key, Value> pairs
        for (int i = 0; i < 150; i++) {
            data.add(new Entry());
        }

        for (int i = 0; i < 150; i++) {
            Entry entry = data.get(i);
            myHashMap.put(entry.getKey(), entry.getValue());
        }
    }


}

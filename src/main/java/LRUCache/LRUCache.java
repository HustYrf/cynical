package LRUCache;

import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 */
//使用双端链表加hashmap
public class LRUCache {
    private class DoubleNode {
        int key;
        int value;
        DoubleNode pre;
        DoubleNode next;

        public DoubleNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int len;

    private DoubleNode head;
    private DoubleNode tail;
    private Map<Integer, DoubleNode> map;

    public LRUCache(int capacity) {
        this.size = 0;
        this.len = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        DoubleNode doubleNode = getDoubleNode(key);
        if (doubleNode == null) {
            return -1;
        }
        return doubleNode.value;
    }

    public void put(int key, int value) {
        DoubleNode node = new DoubleNode(key, value);
        DoubleNode doubleNode = getDoubleNode(key);
        if (doubleNode == null) { //如果不存在
            map.put(key, node);
            addNodeToTail(node);
            size++;
            removeHeadNode(size);
        } else {   //之前就已经存在,更新node，value
            doubleNode.value = value;
        }
    }

    private void removeHeadNode(int size) {
        if (size > len) {  //长度超标了，需要移除头节点
            DoubleNode headCopy = head;
            head = head.next;
            head.pre = null;
            size--;
            map.remove(headCopy.key);
        }
    }

    private DoubleNode getDoubleNode(int key) {
        DoubleNode doubleNode = map.get(key);
        if (doubleNode == null) {
            return null;
        }
        if (doubleNode != tail) {
            if (doubleNode == head) {
                head = head.next;
                head.pre = null;
            } else {
                doubleNode.next.pre = doubleNode.pre;
                doubleNode.pre.next = doubleNode.next;
            }
            addNodeToTail(doubleNode);
        }
        return doubleNode;
    }

    private void addNodeToTail(DoubleNode node) {
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
            tail.next = null;
        }
    }
}



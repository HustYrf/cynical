package AddTwoNumbers;

import CITS2200.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Priority Queue implements by single link
 */

@SuppressWarnings("unchecked")
public class PriorityQueueLinked implements PriorityQueue<Object> {
    /**
     * The current length of the queue
     */
    private int size;
    private OrderLinkList list;

    /**
     * No-argument constructor
     */
    public PriorityQueueLinked() {
        this.size = 0;
        this.list = new OrderLinkList();
    }

    /**
     * is empty method
     * @return queue is empty
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    /**
     * enqueue method
     * @param o data
     * @param i priority
     * @throws IllegalValue exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public void enqueue(Object o, int i) throws IllegalValue {
        if (o == null) {
            throw new IllegalValue("PriorityQueueLinked Illegal Value");
        }
        this.list.insert(o, i);
        this.size++;
    }

    /**
     * examine method
     * @return data of index 0
     * @throws Underflow exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object examine() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("PriorityQueueLinked method examine Underflow");
        }
        return this.list.get(0);
    }

    /**
     * dequeue method
     * @return data of index 0
     * @throws Underflow exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object dequeue() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("PriorityQueueLinked method dequeue Underflow");
        }
        Object result = this.list.get(0);
        list.removeFirst();
        this.size--;
        return result;
    }

    /**
     * iterator method
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Iterator iterator() {
        List<Object> resultList = getResultList();
        java.util.Iterator<Object> iterator = resultList.iterator();
        Iterator eIterator = new Iterator() {
            @Override
            public Object next() throws OutOfBounds {
                try {
                    return iterator.next();
                } catch (Exception e) {
                    throw new OutOfBounds("PriorityQueueLinked exception");
                }
            }

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }
        };
        return eIterator;
    }

    @SuppressWarnings("unchecked")
    private List<Object> getResultList() {
        ArrayList<Object> objects = new ArrayList<Object>();
        if (!isEmpty()) {
            for (int i = 0; i < this.size; i++) {
                objects.add(this.list.get(i));
            }
        }
        return objects;
    }

    /**
     * inner class Link
     */
    @SuppressWarnings("unchecked")
    public class Link {
        public Object data;
        public int priority;
        /**
         *  next Link
         */
        public Link next;
    }

    /**
     * inner class OrderLinkList
     */
    @SuppressWarnings("unchecked")
    public class OrderLinkList {
        /**
         * New head node
         */
        public Link first;
        /**
         * Save the intermediate node information to ensure
         * that the node does not lose the previous node information during the movement
         */
        public Link current;
        /**
         * Old head node
         */
        public Link previous;
        public boolean flag = false;
        /**
         * The length of the linked list
         */
        public int size = 0;

        /**
         * Data insertion method
         * @param data data
         * @param val priority
         */
        @SuppressWarnings("unchecked")
        public void insert(Object data, int val) {
            /**
             * Insert data into the first node of the linked list
             */
            Link link = new Link();
            link.data = data;
            link.priority = val;
            link.next = first;
            first = link;

            current = first;
            previous = first.next;

            /**
             * Get the data insertion position, flag is used to control whether to move the node
             */
            while (current.next != null && link.priority <= current.next.priority) {
                flag = true;
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }

            /**
             * Move the node to the target location
             */
            if (flag) {
                link.next = current.next;
                current.next = link;
                first = previous;
                flag = false;
            }
            size++;
        }

        /**
         * get data by index
         * @param index data index
         * @return result
         */
        @SuppressWarnings("unchecked")
        public Object get(int index) {
            /**
             * Without checking the index, a null pointer error may occur
             */
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        /**
         * remove First link node
         */
        @SuppressWarnings("unchecked")
        public void removeFirst() {
            first = first.next;
        }
    }
}




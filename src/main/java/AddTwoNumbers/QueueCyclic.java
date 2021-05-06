package AddTwoNumbers;

import CITS2200.Overflow;
import CITS2200.Queue;
import CITS2200.Underflow;

public class QueueCyclic implements Queue {

    private int first;

    private int count;

    private Object[] data;

    public QueueCyclic() {
        this(1000);
    }

    public QueueCyclic(int size) {
        first = 0;
        count = 0;
        data = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return first == count ? true : false;
    }

    @Override
    public void enqueue(Object o) throws Overflow {
        if (count == data.length) {
            throw new Overflow("Queue is full");
        } else {
            data[count++] = 0;
        }
    }

    @Override
    public Object examine() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Queue is empty");
        }
        return data[first];

    }

    @Override
    public Object dequeue() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Queue is empty");
        }
        Object result = data[first];
        data[first++] = null;
        return result;
    }

}

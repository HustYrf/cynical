package AddTwoNumbers;


import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

/**
 * Double-ended circular queue
 * @param <E>
 */
public class DequeCyclic<E> implements Deque<E> {

    public int dequeSize;
    public int current;
    public Node<E> left;
    public Node<E> right;

    /**
     * Constructor DequeCyclic<E>
     * @param s init size
     */
    public DequeCyclic(int s) {
        this.dequeSize = s;
        this.current = 0;
    }

    /**
     * Data is inserted into the leftmost node
     * @param e date
     */
    @SuppressWarnings("unchecked")
    @Override
    public void pushLeft(E e) throws Overflow {
        if (isFull()) {
            throw new Overflow("Deque is full!");
        }
        Node node = new Node(e);
        node.next = left;
        if (left != null) {
            left.prev = node;
        }
        left = node;
        if (right == null) {
            right = node;
        }
        current++;

    }

    /**
     * Data is inserted into the rightmost node
     * @param e date
     */
    @SuppressWarnings("unchecked")
    @Override
    public void pushRight(E e) throws Overflow {
        if (isFull()) {
            throw new Overflow("Deque is full!");
        }
        Node node = new Node(e);
        node.prev = right;
        if (right != null) {
            right.next = node;
        }
        right = node;
        if (left == null) {
            left = node;
        }
        current++;
    }

    /**
     * remove and return the leftmost node data in the deque
     * @return result data
     */
    @SuppressWarnings("unchecked")
    @Override
    public E popLeft() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Deque is empty!");
        }
        E result = peekLeft();
        Node popLeft = left.next;
        if (popLeft != null) {
            popLeft.prev = null;
            left.next = null;
        } else {
            right = null;
        }
        left = popLeft;
        current--;
        return result;
    }

    /**
     * remove and return the rightmost node data in the deque
     * @return result data
     */
    @SuppressWarnings("unchecked")
    @Override
    public E popRight() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Deque is empty!");
        }
        E result = peekRight();
        Node popRight = right.prev;
        if (popRight != null) {
            popRight.next = null;
            right.prev = null;
        } else {
            left = null;
        }
        right = popRight;
        current--;
        return result;
    }

    /**
     *  return the rightmost node data in the deque
     * @return result data
     */
    @SuppressWarnings("unchecked")
    @Override
    public E peekRight() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Deque is empty!");
        }

        return right == null ? null : right.data;
    }

    /**
     *  return the leftmost node data in the deque
     * @return result data
     */
    @SuppressWarnings("unchecked")
    @Override
    public E peekLeft() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Deque is empty!");
        }
        return left == null ? null : left.data;
    }

    /**
     * judge whether queue is empty
     * @return whether queue is empty
     */
    @Override
    public boolean isEmpty() {
        return current == 0;
    }

    /**
     * Judge whether queue is full
     * @return whether queue is full
     */
    @Override
    public boolean isFull() {
        return current == dequeSize;
    }


//    public static void main(String[] args) {
//        DequeCyclic<Integer> obj = new DequeCyclic<Integer>(8);
//        obj.pushLeft(1);
//        obj.pushRight(2);
//        obj.pushRight(3);
//        obj.pushRight(4);
//        System.out.println(obj.popRight());
//        System.out.println(obj.popRight());
//        System.out.println(obj.popRight());
//        System.out.println(obj.popRight());
//        System.out.println(obj.popRight());
//        System.out.println(obj.isEmpty());
//        System.out.println(obj.isFull());
//    }
}

/**
 * Maintain a linked list node and become a LinkedList of java
 *
 * @param <E>
 */
class Node<E> {
    public Node<E> prev;
    public Node<E> next;
    public E data;


    public Node(E data) {
        this.data = data;
    }

}

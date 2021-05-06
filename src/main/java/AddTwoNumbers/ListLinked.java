package AddTwoNumbers;

import CITS2200.Link;
import CITS2200.List;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;

/**
 * Single linked list Class
 */
public class ListLinked implements List {
    /**
     * Head pointer
     */
    private Link head;

    /**
     * Tail pointer
     */
    private Link tail = new Link((Object) null, (Link) null);

    /**
     * Constructor
     * <p>
     * public Link(Object var1, Link var2) {
     * this.item = var1;
     * this.successor = var2;
     * }
     * <p>
     * var2 is next pointer
     */
    public ListLinked() {
        this.head = new Link((Object) null, this.tail);
    }

    /**
     * Determine whether the list is empty
     *
     * @return is empty
     */
    @Override
    public boolean isEmpty() {
        if (this.head.successor == this.tail) {
            return true;
        }
        return false;
    }

    /**
     * Determine whether it is the head node
     *
     * @param windowLinked Elements to be judged
     * @return result
     */
    @Override
    public boolean isBeforeFirst(WindowLinked windowLinked) {
        if (this.head == windowLinked.link) {
            return true;
        }
        return false;
    }

    /**
     * Determine whether it is the tail node
     *
     * @param windowLinked Elements to be judged
     * @return result
     */
    @Override
    public boolean isAfterLast(WindowLinked windowLinked) {
        if (this.tail == windowLinked.link) {
            return true;
        }
        return false;
    }

    /**
     * Assign the head node to windowLinked
     *
     * @param windowLinked Elements to be operating
     */
    @Override
    public void beforeFirst(WindowLinked windowLinked) {
        windowLinked.link = this.head;
    }

    /**
     * Assign the tail node to windowLinked
     *
     * @param windowLinked Elements to be operating
     */
    @Override
    public void afterLast(WindowLinked windowLinked) {
        windowLinked.link = this.tail;
    }

    /**
     * the current node go next
     *
     * @param windowLinked Elements to be operating
     */
    @Override
    public void next(WindowLinked windowLinked) throws OutOfBounds {
        if (isAfterLast(windowLinked)) {
            throw new OutOfBounds("this linked node is last");
        }
        windowLinked.link = windowLinked.link.successor;
    }

    /**
     * the current node go previous
     *
     * @param windowLinked Elements to be operating
     */
    @Override
    public void previous(WindowLinked windowLinked) throws OutOfBounds {
        if (isBeforeFirst(windowLinked)) {
            throw new OutOfBounds("this linked node is first");
        }

        Link successorNode = this.head.successor;

        Link resultLink;
        for (resultLink = this.head; successorNode != windowLinked.link; successorNode = successorNode.successor) {
            resultLink = successorNode;
        }
        windowLinked.link = resultLink;
    }

    /**
     * Insert an element at the next node
     *
     * @param o            value
     * @param windowLinked Elements to be operating
     */
    @Override
    public void insertAfter(Object o, WindowLinked windowLinked) throws OutOfBounds {
        if (isAfterLast(windowLinked)) {
            throw new OutOfBounds("this linked node is last");
        }
        windowLinked.link.successor = new Link(o, windowLinked.link.successor);
    }

    /**
     * Insert an element at the before node
     *
     * @param o            value
     * @param windowLinked Elements to be operating
     */
    @Override
    public void insertBefore(Object o, WindowLinked windowLinked) throws OutOfBounds {
        if (isBeforeFirst(windowLinked)) {
            throw new OutOfBounds("this linked node is first");
        }
        windowLinked.link.successor = new Link(windowLinked.link.item, windowLinked.link.successor);
        if (isAfterLast(windowLinked)) {
            this.tail = windowLinked.link.successor;
        }
        windowLinked.link.item = o;
        windowLinked.link = windowLinked.link.successor;
    }

    /**
     * Get node element
     *
     * @param windowLinked Elements to be operating
     * @return item
     */
    @Override
    public Object examine(WindowLinked windowLinked) throws OutOfBounds {
        if (isBeforeFirst(windowLinked) || isAfterLast(windowLinked)) {
            throw new OutOfBounds("this linked node is first or last");
        }
        return windowLinked.link.item;
    }

    /**
     * Replacement node
     *
     * @param o            element
     * @param windowLinked Elements to be operating
     * @return item value
     */
    @Override
    public Object replace(Object o, WindowLinked windowLinked) throws OutOfBounds {
        if (isBeforeFirst(windowLinked) || isAfterLast(windowLinked)) {
            throw new OutOfBounds("this linked node is first or last");
        }
        Object itemValue = windowLinked.link.item;
        windowLinked.link.item = o;
        return itemValue;
    }

    /**
     * Delete node
     *
     * @param windowLinked Elements to be operating
     * @return item
     */
    @Override
    public Object delete(WindowLinked windowLinked) throws OutOfBounds {
        if (isBeforeFirst(windowLinked) || isAfterLast(windowLinked)) {
            throw new OutOfBounds("this linked node is first or last");
        }
        Object itemValue = windowLinked.link.item;
        windowLinked.link.item = windowLinked.link.successor.item;
        if (windowLinked.link.successor == this.tail) {
            this.tail = windowLinked.link;
        }
        windowLinked.link.successor = windowLinked.link.successor.successor;
        return itemValue;
    }

    public static void main(String[] args) {
        String s = "Hello, World!";
        System.out.println(s.split(""));
    }
}

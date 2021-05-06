package AddTwoNumbers;

import CITS2200.Overflow;
import CITS2200.Stack;
import CITS2200.Underflow;


/**
 * Block Implementation of a stack
 * <p>
 * Stack is a linear data structure which follows a particular order in which the operations are performed.
 * The order may be LIFO(Last In First Out) or FILO(First In Last Out).
 *
 * @Author Kaiser
 */
public class StackBlock implements Stack {


    /**
     * Initialize an Object array as the bottom container of the StackBlock
     */
    private Object[] stackArr;

    /**
     * This variable is used to record the subscript index of the top data of the StackBlock
     */
    private int topPointer;



    /**
     * Constructor of stack with space size s
     * create an empty stack of size s
     *
     * @param size the length of Initialize StackBlock size
     */
    public StackBlock(int size) {
        stackArr = new Object[size];
        topPointer = -1;
    }

    /**
     * By comparison index of the top data of the StackBlock with init data array list length
     * Judge whether it is full
     * <p>
     * return true if the stack is full,false otherwise
     *
     * @return
     */
    public boolean isFull() {
        if (topPointer == stackArr.length - 1) {
            return true;
        }
        return false;
    }

    /**
     * By comparison index of the top data of the StackBlock with -1
     * Judge whether it is empty
     * <p>
     * return true if the stack is empty,false otherwise
     *
     * @return
     */

    public boolean isEmpty() {
        if (topPointer == -1) {
            return true;
        }
        return false;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed onto this stack.
     * @throws Overflow – if this stack is full.
     */


    public void push(Object item) throws Overflow {
        if (isFull()) {
            throw new Overflow("pushing on full stack");
        } else {
            stackArr[++topPointer] = item;
        }

    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return the object at the top of this stack (the last item of the Vector object).
     * @throws Underflow – if this stack is empty.
     */

    public Object examine() throws Underflow {

        if (isEmpty()) {
            throw new Underflow("examining on empty stack");
        } else {
            return stackArr[topPointer];
        }
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return the object at the top of this stack (the last item of the Vector object).
     * @throws Underflow – if this stack is empty.
     */

    public Object pop() throws Underflow {

        if (isEmpty()) {
            throw new Underflow("popping from empty stack");
        } else {
            Object popData = stackArr[topPointer--];
            return popData;
        }


    }
}

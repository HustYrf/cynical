package AddTwoNumbers;

import CITS2200.BinaryTree;
import CITS2200.Iterator;
import CITS2200.OutOfBounds;

import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class BinTree<E> extends BinaryTree<E> {

    /**
     * NO-param constructor
     */
    @SuppressWarnings("unchecked")
    public BinTree() {
        super();
    }

    /**
     * param constructor
     *
     * @param item value
     * @param b1   left node
     * @param b2   right node
     */
    @SuppressWarnings("unchecked")
    public BinTree(E item, BinaryTree b1, BinaryTree b2) {
        super(item, b1, b2);
    }


    /**
     * iterator method
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        ArrayList<E> print = print(this);
        java.util.Iterator<E> iterator = print.iterator();
        Iterator<E> eIterator = new Iterator<E>() {
            @Override
            public E next() throws OutOfBounds {
                try {
                    return iterator.next();
                } catch (Exception e) {
                    throw new OutOfBounds("BinTree exception");
                }
            }

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }
        };
        return eIterator;
    }

    /**
     * equals method
     *
     * @param o binaryTree
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (o instanceof BinTree) {
            BinTree binTree = (BinTree) o;

            ArrayList<E> print = print(binTree);
            ArrayList<E> print1 = print(this);
            int size = print.size();
            int size1 = print1.size();
            if (size != size1) {
                return false;
            } else {
                for (int i = 0; i < size; i++) {
                    if (!((E)print.get(i)).equals((E)print1.get(i))) {
                        return false;
                    }
                }
            }


            if (this.isEmpty() && binTree.isEmpty()) {
                return true;
            } else if (this.isEmpty() || binTree.isEmpty()) {
                return false;
            } else {
                if (this.isEmpty() && binTree.isEmpty()) {
                    return true;
                } else if (this.isEmpty() || binTree.isEmpty()) {
                    return false;
                } else {
                    return this.getLeft().equals(binTree.getLeft()) && this.getRight().equals(binTree.getRight());
                }
            }
        }
        return false;

    }

    /**
     * @param pRoot this
     * @return item List
     */
    @SuppressWarnings("unchecked")
    private ArrayList<E> print(BinaryTree<E> pRoot) {
        ArrayList<E> result = new ArrayList<>();
        LinkedList<BinaryTree<E>> queue1 = new LinkedList<>();
        ArrayList<ArrayList<E>> arrays = new ArrayList<>();
        if (pRoot != null) {
            queue1.add(pRoot);
            while (!queue1.isEmpty()) {
                LinkedList<BinaryTree<E>> queue2 = new LinkedList<>();
                ArrayList<E> array = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    BinaryTree<E> node = queue1.poll();
                    if (!node.isEmpty()) {
                        if (node.getLeft() != null)
                            queue2.add(node.getLeft());
                        if (node.getRight() != null)
                            queue2.add(node.getRight());
                        array.add(node.getItem());
                    }
                }
                arrays.add(array);
                queue1 = queue2;
            }
        }

        for (ArrayList<E> array : arrays) {
            for (E e : array) {
                result.add(e);
            }
        }
        return result;
    }
}

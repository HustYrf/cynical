package hw5;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MetaCollection<E> extends AbstractCollection<E> {

    /**
     * the only Collection<E> use as a field
     */
    private final ArrayList<Collection<E>> collectionList;


    /**
     * which takes in a variable number of Collection<E>s, and initializes the MetaCollection<E> to be
     * the concatenation of them.
     *
     * @param c_arr
     */
    public MetaCollection(Collection<E>... c_arr) {
        collectionList = new ArrayList<>();
         //Iterate over the collection c_arr
        for (Collection<E> collection : c_arr) {
            //add data into collectionList
            collectionList.add(collection);
        }
    }

    /**
     * other way to add a Collection<E> to the MetaCollection<E>
     *
     * @param coll
     */
    public void addCollection(Collection<E> coll) {
        // if coll is not null , add coll into collectionList
        if (coll != null) {
            collectionList.add(coll);
        }
    }

    /**
     *
     * @return the element size of collectionList
     */
    @Override
    public int size() {
        int result = 0;
        if (collectionList != null) {
            //Iterate over the collection collectionList
            for (Collection<E> collection : collectionList) {
                for (E e : collection) {
                    if (e != null) {
                        // if element is not null,The value of result plus one
                        result++;
                    }
                }
            }
        }
        return result;
    }


    @Override
    public Iterator<E> iterator() {
        return new JoinedIter();
    }

    /**
     * an inner class of MetaCollection<E>
     */
    private class JoinedIter implements Iterator<E> {

        //Record the cursor index of the currently fetched value
        private int itrCounter = 0;


        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            // if this value of itrCounter is Less than the value of the element size of collectionList, return true.
            if (itrCounter < size()) {
                return true;
            }
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws  if the iteration has no more elements
         */
        @Override
        public E next() {
            Object[] arr = new Object[size()];
            if (collectionList != null) {
                int i = 0;
                //Iterate over the collection collectionList
                for (Collection<E> collection : collectionList) {
                    for (E e : collection) {
                        //if element is not null , put element into the array of result
                        if (e != null) {
                            arr[i++] = e;
                        }
                    }
                }
            }
            if (hasNext()) {
                //return the data of array
                return (E) arr[itrCounter++];
            }
            return null;
        }
    }
}



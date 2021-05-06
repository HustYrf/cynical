package hw5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class ListUtil {


    /**
     * merge returns an ArrayList<E> that contains all elements of c1 and c2
     * @param c1 Collection 1
     * @param c2 Collection 2
     * @param <E> Generic Type
     * @return
     */
    public static <E> ArrayList<E> merge(Collection<? extends E> c1, Collection<? extends E> c2) {
        // Define the result return List
        ArrayList<E> result = new ArrayList<>();

        //the length of result
        int size = 0;

        //Convert the elements in the collection c1 to an array
        Object[] a = c1.toArray();
        int numNew = a.length;

        //Convert the elements in the collection c2 to an array
        Object[] a2 = c2.toArray();
        int numNew2 = a2.length;

        //Define an array to store the data of collection c1 and c2
        Object[] elementData = new Object[numNew + numNew2];

        //Call the system arraycopy method
        //Params:
        //src – the source array.(a)
        //srcPos – starting position in the source array.(0)
        //dest – the destination array.(elementData)
        //destPos – starting position in the destination data.(size)
        //length – the number of array elements to be copied.(numNew)
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;

        System.arraycopy(a2, 0, elementData, size, numNew2);

        for (int i = 0; i < elementData.length; i++) {
            result.add((E) elementData[i]);
        }
        return result;
    }

    /**
     * select returns an ArrayList<E> that contains all elements of coll for which pred.test(...)
     * evaluates to true.
     * @param coll Collection
     * @param pred Predicate
     * @param <E> Generic Type
     * @return
     */
    public static <E> ArrayList<E> select(Collection<? extends E> coll, Predicate<? super E> pred) {
        // Define the result return List
        ArrayList<E> result = new ArrayList<>();

        //Iterate over the collection coll
        for (E e : coll) {
            //Predicate Inteface
            //isEqual(Object targetRef) : Returns a predicate that tests if two arguments are equal according to Objects.equals(Object, Object).
            //and(Predicate other) : Returns a composed predicate that represents a short-circuiting logical AND of this predicate and another.
            //negate() : Returns a predicate that represents the logical negation of this predicate.
            //or(Predicate other) : Returns a composed predicate that represents a short-circuiting logical OR of this predicate and another.
            //test(T t) : Evaluates this predicate on the given argument.boolean test(T t)
            if (pred.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}

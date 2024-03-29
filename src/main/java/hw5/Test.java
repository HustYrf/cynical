package hw5;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;


/**
 * 原因：  (problem 5 的原因，水平有限，翻译不出来，自行理解然后翻译)
 * 因为在ArrayList<Complex> l5 = ListUtil.merge(l3, l4)，执行merge操作的时候是把Collection l3添加到l5中
 * 因此在l5的list中存储了两个Complex的实例，0的位置是l3的Complex实例，1的位置是l4的Complex实例
 * l5.get(0)的获取的是l3中存储的Complex实例，后续操作对Complex实例包含的两个变量real, imag进行了赋值操作
 * cpx.real = 0; cpx.imag = 0; 等价于l3.add(new Complex(0, 0));
 * 所以the 0th entry of l3 did change while the 0th entry of l4 did not
 *
 */
public class Test {
    public static void main(String[] args) {
        //test phone book
        Map<String, BigInteger> phoneBook = new HashMap<>();
        phoneBook.put("Alice", new BigInteger("2131231234"));
        phoneBook.put("Bob", new BigInteger("3101231234"));
        phoneBook.put("Charles", new BigInteger("2121231234"));

        System.out.println("Original phone book");
        for (Map.Entry<String, BigInteger> entry : phoneBook.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());

        System.out.println("Updated phone book");
        PhoneUtil.prependOne(phoneBook);
        for (Map.Entry<String, BigInteger> entry : phoneBook.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());


        Set<Integer> s1 = new HashSet<>();
        Collections.addAll(s1, 11, -22, 33, -44);
        ArrayList<Double> l1 = new ArrayList<>();
        Collections.addAll(l1, 1.1, 2.2, 3.3);

        System.out.println("Merge two Collection<E>s");
        Collection<Number> c1 = ListUtil.merge(s1, l1);
        for (Object n : c1)
            System.out.println(n);

        System.out.println("Select positive entries from s1");
        //select from a Collection<E>
        for (Integer i : ListUtil.select(s1, new Pred()))
            System.out.println(i);


        Set<Integer> s2 = new HashSet<>();
        Collections.addAll(s2, 1, 2, 3);
        ArrayList<Integer> l2 = new ArrayList<>();
        Collections.addAll(l2, 10);

        //create a MetaCollection<E> from Collection<E>s
        MetaCollection<Integer> mc1 = new MetaCollection<>(s2, l2, s2);
        l2.add(20);

        System.out.println("Meta collection output 1");
        System.out.println(mc1.size()); //output 8
        for (Integer i : mc1)
            System.out.println(i);


        MetaCollection<Number> mc2 = new MetaCollection<>();
        mc2.addCollection(new HashSet<>());
        mc2.addCollection(new PriorityQueue<>());
        mc2.addCollection(new ArrayList<>());

        System.out.println("Meta collection output 2");
        System.out.println(mc2.size()); //output 0
        for (Number i : mc2) //no output
            System.out.println(i);


        //see how changing one Collection<E> affects another Collection<E>


        //what i thought at the top of the file
        ArrayList<Complex> l3 = new ArrayList<>();
        l3.add(new Complex(1, 2));
        ArrayList<Complex> l4 = new ArrayList<>();
        l4.add(new Complex(2, 3));

        ArrayList<Complex> l5 = ListUtil.merge(l3, l4);
        Complex cpx = l5.get(0);
        cpx.real = 0;
        cpx.imag = 0;
        l5.set(1, new Complex(8, 9));

        System.out.println("Why do we have the following output?");
        System.out.println(l3.get(0)); //0.0+0.0i
        System.out.println(l4.get(0)); //2.0+3.0i
        System.out.println(l5.get(0)); //0.0+0.0i
        System.out.println(l5.get(1)); //8.0+9.0i
    }
}

class Pred implements Predicate<Number> {
    @Override
    public boolean test(Number n) {
        return n.doubleValue() >= 0;
    }
}

class Complex {
    public double real, imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return real + "+" + imag + "i";
    }
}

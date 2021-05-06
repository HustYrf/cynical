package AddTwoNumbers;


import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        BinTree<Integer> integerBinTree = new BinTree<Integer>(1, new BinTree(1, new BinTree(1, new BinTree(), new BinTree()), new BinTree(1, new BinTree(), new BinTree())), new BinTree(1, new BinTree(1, new BinTree(), new BinTree()), new BinTree()));
        BinTree<Integer> integerBinTree1= new BinTree<Integer>(4, new BinTree(1, new BinTree(1, new BinTree(), new BinTree()), new BinTree(1, new BinTree(), new BinTree())), new BinTree(1, new BinTree(1, new BinTree(), new BinTree()), new BinTree()));


//        BinTree<Integer> integerBinTree = new BinTree<Integer>(1,new BinTree(1,new BinTree(),new BinTree()),new BinTree());
//        BinTree<Integer> integerBinTree1 = new BinTree<Integer>(1,new BinTree(),new BinTree(1,new BinTree(),new BinTree()));
        System.out.println(integerBinTree.equals(integerBinTree1));
//        System.out.println(Integer.valueOf(1).equals(Integer.valueOf(1)));

//        Iterator iterator = integerBinTree.iterator();
//        Iterator iterator1 = integerBinTree1.iterator();
//
//        System.out.println(1);



        new PriorityQueue<Integer>();

    }
}

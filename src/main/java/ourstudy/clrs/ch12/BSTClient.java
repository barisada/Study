package ourstudy.clrs.ch12;

/**
 * Created by jw on 2017-08-23.
 */
public class BSTClient {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(40);
        tree.insert(50);
        tree.insert(35);
        tree.insert(31);
        tree.insert(23);
        tree.insert(64);
        tree.insert(78);
        tree.insert(12);
        tree.insert(45);
        tree.insert(41);
        tree.insert(42);
        tree.insert(39);
        tree.insert(32);
        tree.print();
        System.out.println("sorted = " + tree.sort());
    }
}

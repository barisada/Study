package books.ctci.tree.question;

import books.ctci.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 */
public class _4_8_FirstCommonAncestor {

    public static Tree firstCommonAncestor(Tree root, Tree p, Tree q){
        if(findTree(root, p) && findTree(root, q)){
            return firstCommonAncestorHelper(root, p, q);
        }
        return null;
    }

    public static Tree firstCommonAncestorHelper(Tree tree, Tree p, Tree q){
                boolean pExist = findTree(tree.getLeft(), p);
                boolean qExist = findTree(tree.getLeft(), q);

                if(pExist != qExist){
                    return tree;
                }

                Tree next = pExist ? tree.getLeft() : tree.getRight();

                return firstCommonAncestorHelper(next, p, q);

    }

    private static boolean findTree(Tree tree, Tree target) {
        if(tree == null) return false;
        if(tree == target) return true;
        return findTree(tree.getLeft(), target) || findTree(tree.getRight(), target);
    }


    public static void main(String[] args) {
        Tree tree = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);
        Tree tree8 = new Tree(8);
        Tree tree9 = new Tree(9);
        Tree tree10 = new Tree(-1);

        tree.setLeft(tree2);
        tree.setRight(tree3);
        tree2.setLeft(tree4);
        tree2.setRight(tree5);
        tree3.setLeft(tree6);
        tree3.setRight(tree7);
        tree4.setLeft(tree8);
        tree5.setLeft(tree9);

        System.out.println(firstCommonAncestor(tree, tree8, tree3));
    }

}

package books.ctci.tree.question;

import books.ctci.tree.Tree;

public class _4_5_ValidateBST {

    public static boolean checkBST(Tree root){
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBST(Tree root, int minValue, int maxValue) {
        if(root == null) return true;

        if(root.getVal() <= minValue || root.getVal() >= maxValue) return false;

        return checkBST(root.getLeft(), minValue, root.getVal()) && checkBST(root.getRight(), root.getVal(), maxValue);
    }

    public static void main(String[] args) {
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);
        Tree tree8 = new Tree(8);

        tree4.setLeft(tree2);
        tree4.setRight(tree6);
        tree2.setLeft(tree1);
        tree2.setRight(tree3);
        tree6.setLeft(tree5);
        tree6.setRight(tree8);
        tree8.setLeft(tree7);

        System.out.println("BST : " + checkBST(tree4));

        tree8.setLeft(null);
        tree8.setRight(tree7);
        System.out.println("BST : "  + checkBST(tree4));

    }

}

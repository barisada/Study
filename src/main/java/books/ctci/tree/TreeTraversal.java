package books.ctci.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {
    private List<Integer> inOrderList = new ArrayList<>();
    private List<Integer> preOrderList = new ArrayList<>();
    private List<Integer> postOrderList = new ArrayList<>();


    public void traversal(Tree node){
        if(node != null){
            preOrderList.add(node.getVal());
            traversal(node.getLeft());
            inOrderList.add(node.getVal());
            traversal(node.getRight());
            postOrderList.add(node.getVal());
        }
    }


    public static void main(String[] args) {
        TreeTraversal treeTraversal = new TreeTraversal();
        Tree sample = treeTraversal.createSampleTree();

        treeTraversal.traversal(sample);
        System.out.println("inorder : " + treeTraversal.inOrderList);
        System.out.println("preOrder : " + treeTraversal.preOrderList);
        System.out.println("postOrder : " + treeTraversal.postOrderList);
    }

    /**
     *                            1
     *              2                           3
     *        4         null          5             6
     *    null  null  null null    null null      7   null
     * @return
     */
    private Tree createSampleTree(){
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);

        tree1.setLeft(tree2);
        tree1.setRight(tree3);

        tree2.setLeft(tree4);

        tree3.setLeft(tree5);
        tree3.setRight(tree6);

        tree6.setLeft(tree7);

        return tree1;
    }

    private class Tree {
        private int val;
        private Tree left;
        private Tree right;

        public Tree(int val) {
            this.val = val;
        }

        public Tree(int val, Tree left, Tree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Tree getLeft() {
            return left;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public Tree getRight() {
            return right;
        }

        public void setRight(Tree right) {
            this.right = right;
        }
    }
}

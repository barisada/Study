package books.ctci.tree.question;

import books.ctci.tree.Tree;
import books.ctci.tree.TreeTraversal;

/**
 * 4.2
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */
public class _4_2_MinimalTree {

    public static Tree createMinimalBST(int[] array){
        if(array != null && array.length > 0) {
            return createMinimalBST(array, 0, array.length - 1);
        }
        return null;
    }

    private static Tree createMinimalBST(int[] array, int left, int right) {
        if(left > right) return null;

        int mid = (left + right) / 2;
        Tree tree = new Tree(array[mid]);
        tree.setLeft(createMinimalBST(array, left, mid - 1));
        tree.setRight(createMinimalBST(array, mid + 1, right));

        return tree;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        Tree minialTree = createMinimalBST(array);

        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.traversal(minialTree);
        System.out.println(treeTraversal.getPreOrderList());
    }

}

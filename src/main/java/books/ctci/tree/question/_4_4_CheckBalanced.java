package books.ctci.tree.question;

import books.ctci.tree.Tree;
import books.ctci.tree.TreeTraversal;

/**
 *
 */
public class _4_4_CheckBalanced {

    public static boolean checkBalanced(Tree root){
        int leftHeight = getTreeHeight(root.getLeft());
        int rightHeight = getTreeHeight(root.getRight());

        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    private static int getTreeHeight(Tree tree) {
        if(tree == null) return 0;

        return 1 + Math.max( getTreeHeight(tree.getLeft()), getTreeHeight(tree.getRight()));
    }


    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        Tree tree1 = _4_2_MinimalTree.createMinimalBST(array);
        System.out.println("tree1 : " + checkBalanced(tree1));

        Tree tree2 = new TreeTraversal().createSampleTree();
        System.out.println("tree2 : " + checkBalanced(tree2));

        Tree tree3 = new Tree(0);
        tree3.setLeft(new Tree(0));
        tree3.getLeft().setLeft(new Tree(0));
        tree3.getLeft().getLeft().setLeft(new Tree(0));
        System.out.println("tree3 : " + checkBalanced(tree3));
    }

}

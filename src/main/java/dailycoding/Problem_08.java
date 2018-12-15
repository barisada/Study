package dailycoding;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of unival subtrees.
 *
 *  a
 *  / \
 * a   a
 *     /\
 *    a  a
 *        \
 *         A
 * This tree has 3 unival subtrees: the two ‘a’ leaves and the one ‘A’ leaf. The ‘A’ leaf causes all its parents to not be counted as a unival tree, however.
 */
public class Problem_08 {
    public static void main(String[] args) {
        Problem_08 test = new Problem_08();
        TreeNode test1 = test.getTree1();
        TreeNode test2 = test.getTree2();
        System.out.println("test 1 (should be 5) : " + test.univalTree(test1));
        System.out.println("test 2 (should be 3) : " + test.univalTree(test2));
    }



    public int univalTree(TreeNode root){
        int[] result = new int[1];
        isUnival(root, result);
        return result[0];
}

    private boolean isUnival(TreeNode node, int[] count) {
        if(node == null) return true;
        boolean left = isUnival(node.left, count);
        boolean right = isUnival(node.right, count);
        if(left && right
                && (node.left == null || node.left.val == node.val)
                && (node.right == null || node.right.val == node.val)){
            count[0]++;
            return true;
        }
        return false;
    }

    /**
     *    0
     *   / \
     *  1   0
     *     / \
     *    1   0
     *   / \
     *  1   1
     * @return
     */
    private TreeNode getTree1() {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.right = new TreeNode(0);
        return root;

    }

    /**
     *   a
     *  / \
     * a   a
     *     /\
     *    a  a
     *        \
     *         A
     * @return
     */
    private TreeNode getTree2() {
        return new TreeNode(1, new TreeNode(1), new TreeNode(1, new TreeNode(1), new TreeNode(1, null, new TreeNode(2))));
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

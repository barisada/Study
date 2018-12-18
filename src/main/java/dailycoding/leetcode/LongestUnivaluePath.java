package dailycoding.leetcode;

import dailycoding.leetcode.helper.TreeNode;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 *
 * Input:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output:
 *
 * 2
 * Example 2:
 *
 * Input:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output:
 *
 * 2
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {
        LongestUnivaluePath test = new LongestUnivaluePath();
        TreeNode test1 = TreeNode.createTree(5,4,5,1,1,null,5);
        TreeNode test2 = TreeNode.createTree(1,4,5,4,4,null,5);
        TreeNode test3 = TreeNode.createTree(4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2);

        System.out.println("test 1 (should be 2) : " + test.longestUnivaluePath(test1));
        System.out.println("test 2 (should be 2) : " + test.longestUnivaluePath(test2));
        System.out.println("test 3 (should be 1) : " + test.longestUnivaluePath(test3));
    }

    public int longestUnivaluePath(TreeNode root) {
        int logest[] = new int[1];
        findLongest(root, logest);
        return logest[0];
    }

    private int findLongest(TreeNode node, int[] logest) {
        if(node == null) return 0;
        int leftMax = findLongest(node.left, logest);
        int rightMax = findLongest(node.right, logest);

        leftMax = (node.left != null && node.left.val == node.val) ? leftMax + 1 : 0;
        rightMax = (node.right != null && node.right.val == node.val) ? rightMax + 1 : 0;

        logest[0] = Math.max(logest[0], leftMax + rightMax);
        return Math.max(leftMax, rightMax);
    }

    private void preOrder(TreeNode node){
        if(node != null){
            System.out.print(node.val + ", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}

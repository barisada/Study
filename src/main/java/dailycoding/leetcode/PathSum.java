package dailycoding.leetcode;

import dailycoding.leetcode.nodes.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public static void main(String[] args) {
        PathSum test = new PathSum();
        TreeNode test1 = TreeNode.createTree(5,4,8,11,null,13,4,7,2,null,1);
        TreeNode test2 = TreeNode.createTree(1,null,2);
        System.out.println("should be true : " + test.hasPathSum(test1, 22));
        System.out.println("should be false : " + test.hasPathSum(test2, 1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(sum == root.val && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

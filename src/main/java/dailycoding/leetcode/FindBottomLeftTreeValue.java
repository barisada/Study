package dailycoding.leetcode;

import dailycoding.leetcode.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 *
 * leetcode #513
 */
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        FindBottomLeftTreeValue test = new FindBottomLeftTreeValue();
        TreeNode tree1 = TreeNode.createTree(2,1,3);
        System.out.println("should be 1 : " + test.findBottomLeftValue(tree1));

        TreeNode tree2 = TreeNode.createTree(1,2,3,4,null,5,6,null,7);
        System.out.println("should be 7 : " + test.findBottomLeftValue(tree2));
    }

    public int findBottomLeftValue(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        TreeNode deepest = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == 0) deepest = node;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return deepest.val;
    }
}

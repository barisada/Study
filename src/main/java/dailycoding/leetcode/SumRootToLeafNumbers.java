package dailycoding.leetcode;

import dailycoding.leetcode.helper.TreeNode;
import org.springframework.util.StopWatch;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 * leetcode #129
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        SumRootToLeafNumbers test = new SumRootToLeafNumbers();
        TreeNode tree1 = TreeNode.createTree(1,2,3);
        TreeNode tree2 = TreeNode.createTree(4,9,0,5,1);
        TreeNode tree3 = TreeNode.createTree(1,0,0,2,3,6,4,null,null,5,0,7,8,null,9);
        TreeNode tree4 = TreeNode.createTree(0);
        TreeNode tree5 = TreeNode.createTree(1,2,3,4,5,6,7,null,9,0,0,1,2,3,4,5,null,7,8,9,0,0,1,2,3,4,5,6,7,8,9,0,0,1,2,3,4,5,6,7,9,0,0,1,2,3,4,5,6,7,9,0,0,1,2,3,4,5,6,7,9,0,0,1,2,3,4,5,6,7,8,9,0,0,1,2,3,4,5,6,7,8,9,0,0,1,2,3,4,5,6,7,8,9,0,0,1,2,3,4,5,6,7,8,9,0,0,1,2,3,4,5,6,7,8,9,0,0,1,2,3,4,5,6,7,8,9,0,0,1,2,3,4,5,6,7,8,9,0,0,1,2,3,4,5,6,7,8,9,0,0);

        StopWatch sw = new StopWatch("sum root to leaf numbers");
        sw.start("long version");
        System.out.println("should be 25 : " + test.sumNumbers(tree1));
        System.out.println("should be 1026 : " + test.sumNumbers(tree2));
        System.out.println("should be 5351 : " + test.sumNumbers(tree3));
        System.out.println("should be 0 : " + test.sumNumbers(tree4));
        System.out.println("should be 168762083 : " + test.sumNumbers(tree5));
        for(int i = 0; i < 10000; i++){
            test.sumNumbers(tree5);
        }
        sw.stop();
        System.out.println("===============================================");
        sw.start("short version");
        System.out.println("should be 25 : " + test.sumNumberShort(tree1));
        System.out.println("should be 1026 : " + test.sumNumberShort(tree2));
        System.out.println("should be 5351 : " + test.sumNumberShort(tree3));
        System.out.println("should be 0 : " + test.sumNumberShort(tree4));
        System.out.println("should be 168762083 : " + test.sumNumberShort(tree5));
        for(int i = 0; i < 10000; i++){
            test.sumNumberShort(tree5);
        }
        sw.stop();

        System.out.println(sw.prettyPrint());
    }

    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        sum(root, sum, 0);
        return sum[0];
    }

    private void sum(TreeNode node, int[] sum, int cur) {
        if(node != null){
            cur += node.val;
            if(node.left == null && node.right == null){
                sum[0] += cur;
            } else {
                sum(node.left, sum, cur * 10);
                sum(node.right, sum, cur * 10);
            }
        }
    }

    public int sumNumberShort(TreeNode root){
        return sum(root, 0);
    }

    private int sum(TreeNode node, int sum){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return sum * 10 + node.val;
        return sum(node.left, sum * 10 + node.val) + sum(node.right, sum * 10 + node.val);
    }
}

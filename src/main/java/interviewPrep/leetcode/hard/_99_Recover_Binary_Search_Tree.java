package interviewPrep.leetcode.hard;

public class _99_Recover_Binary_Search_Tree {
    public void recoverTree(TreeNode root) {
        while(!swap(root, Long.MIN_VALUE, Long.MAX_VALUE, root, root));
    }

    boolean swap(TreeNode node, long min, long max, TreeNode minNode, TreeNode maxNode){
        if(node == null) return true;
        if(min > node.val){
            int temp = node.val;
            node.val = (int) min;
            minNode.val = temp;
            return false;
        }
        if( max < node.val){
            int temp = node.val;
            node.val = (int) max;
            maxNode.val = temp;
            return false;
        }
        return swap(node.left, min, node.val, minNode, node) && swap(node.right, node.val, max, node, maxNode);
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

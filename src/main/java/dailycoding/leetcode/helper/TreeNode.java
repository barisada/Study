package dailycoding.leetcode.helper;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer...vals) {
        TreeNode root = new TreeNode(0);
        return createTreeHelper(vals, root, 0);
    }

    private static TreeNode createTreeHelper(Integer[] vals, TreeNode node, int i) {
        if(i >= vals.length) return null;
        if(vals[i] == null) return null;
        node = new TreeNode(vals[i]);
        node.left = createTreeHelper(vals, new TreeNode(0), (i * 2 ) + 1);
        node.right = createTreeHelper(vals, new TreeNode(0), (i * 2) + 2);
        return node;
    }
}

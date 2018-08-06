package interviewPrep.interviewbit.tree;

import java.util.*;

public class Vertical_Order_traversal_of_BinaryTree {
    static int min;
    static int max;
    static public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        Map<TreeNode, Integer> idxMap = new HashMap<>();
        getIdx(A, 0, idxMap);
        int rootIdx = min * -1;
        int maxIdx = max + rootIdx;

        ArrayList<ArrayList<Integer>> verticals = new ArrayList<>();
        for (int i = 0; i <= maxIdx; i++) {
            verticals.add(new ArrayList<>());
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node != null){
                int idx = idxMap.get(node) + rootIdx;
                verticals.get(idx).add(node.val);

                q.add(node.left);
                q.add(node.right);
            }
        }

        return verticals;
    }

    static void getIdx(TreeNode node, int currIdx, Map<TreeNode, Integer> idxMap){
        if(node != null){
            min = Math.min(min, currIdx);
            max = Math.max(max, currIdx);
            idxMap.put(node, currIdx);

            getIdx(node.left, currIdx -1, idxMap);
            getIdx(node.right, currIdx + 1, idxMap);

        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(verticalOrderTraversal(root));
    }
}

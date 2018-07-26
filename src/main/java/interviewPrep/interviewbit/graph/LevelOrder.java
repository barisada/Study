package interviewPrep.interviewbit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jw on 2017-08-20.
 */
public class LevelOrder {
    static int heightOfTree = 0;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>>  lo = new ArrayList<>();

        if(a == null)
            return lo;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(a);

        while(true){
            if(q.size() == 0){
                return lo;
            }
            int nodeCount = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            while(nodeCount > 0){
                TreeNode r = q.poll();
                level.add(r.val);

                TreeNode left = r.left;
                TreeNode right = r.right;
                if(left != null && left.val != -1){
                    q.add(left);
                }
                if(right != null && right.val != -1){
                    q.add(right);
                }
                nodeCount--;
            }
            lo.add(level);
            heightOfTree++;
        }
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.left.left = new TreeNode(-1);
        r.left.right = new TreeNode(-1);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);

        LevelOrder lo = new LevelOrder();
        System.out.println(lo.levelOrder(r));
        System.out.println(heightOfTree);
    }
}

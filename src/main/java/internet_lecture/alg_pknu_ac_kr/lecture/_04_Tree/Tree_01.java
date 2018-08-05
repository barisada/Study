package internet_lecture.alg_pknu_ac_kr.lecture._04_Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree_01 {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = createTree();
        List<Integer> list = new ArrayList<>();

        inOrderTreeWalk(root, list);
        System.out.println(list);

        list.clear();
        postOrderTreeWalk(root, list);
        System.out.println(list);

        list.clear();
        preOrderTreeWalk(root, list);
        System.out.println(list);

        List<List<Integer>> levels = new ArrayList<>();
        levelOrderTreeWalk(root, levels);
        System.out.println(levels);


    }

    private static void inOrderTreeWalk(Node node, List<Integer> list) {
        if(node != null){
            inOrderTreeWalk(node.left, list);
            list.add(node.val);
            inOrderTreeWalk(node.right, list);
        }
    }

    private static void postOrderTreeWalk(Node node, List<Integer> list) {
        if(node != null){
            postOrderTreeWalk(node.left, list);
            postOrderTreeWalk(node.right, list);
            list.add(node.val);
        }
    }

    private static void preOrderTreeWalk(Node node, List<Integer> list) {
        if(node != null){
            list.add(node.val);
            preOrderTreeWalk(node.left, list);
            preOrderTreeWalk(node.right, list);
        }
    }

    private static void levelOrderTreeWalk(Node node, List<List<Integer>> levels) {
        if (node != null) {
            List<Node> queue = new ArrayList<>();
            queue.add(node);

            List<Integer> level = new ArrayList<>();
            level.add(node.val);

            while (queue.size() > 0) {
                levels.add(level);

                List<Node> oldQueue = queue;
                level = new ArrayList<>();
                queue = new ArrayList<>();

                for(Node n : oldQueue){
                    if(n.left != null){
                        level.add(n.left.val);
                        queue.add(n.left);
                    }
                    if(n.right != null){
                        level.add(n.right.val);
                        queue.add(n.right);
                    }
                }
            }
        }
    }

    private static Node createTree() {
        Node root = new Node(5, new Node(3, new Node(2), new Node(5)), new Node(7, null, new Node(8)));
        return root;
    }

}

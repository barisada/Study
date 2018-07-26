package reviewNote;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *              1
 *      2               3
 *   4      5       6       7
 *
 *   find left value to 6.
 *   if can't find return -1
 *
 */
public class TreeFindNeighbour {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int findNeighbour(Node root, int given){
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> currentLevel = new ArrayList<>();
        List<Node> currentTree = new ArrayList<>();
        if(root != null){
            currentLevel.add(root.val);
            currentTree.add(root);
        }

        int neighbour = -1;
        while(currentTree.size() > 0){
            lists.add(currentLevel);
            List<Node> parentTree = currentTree;

            currentLevel = new ArrayList<>();
            currentTree = new ArrayList<>();

            for(Node n : parentTree){
                if(n.left != null){
                    currentTree.add(n.left);
                    currentLevel.add(n.left.val);
                }
                if(n.right != null){
                    currentTree.add(n.right);
                    currentLevel.add(n.right.val);
                }
            }

            if(currentLevel.contains(given)){
                int pos = currentLevel.indexOf(given);
                neighbour = pos > 0 ? currentLevel.get(pos - 1) : neighbour;
                break;
            }
        }
        return neighbour;
    }

    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2, new Node(4), new Node(5)),
                new Node(3, new Node(6), new Node(7))
                );

        System.out.println(findNeighbour(node, 5));
    }


}

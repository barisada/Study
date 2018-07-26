package interviewPrep.hackerrank.datastructure.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by jw on 2017-08-24.
 */

public class HeightOfaBinaryTree {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static int height(Node root) {
        // Write your code here.
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int height = 0;
        while(true){
            if(q.size() == 0){
                break;
            }
            int count = q.size();
            while(count > 0){
                Node n = q.poll();
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
                count--;
            }
            height++;
        }

        return height - 1;
    }

    public static Node insert(Node root, int data) {
        if(root == null){
            return new Node(data);
        }
        else {
            Node cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0){
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}

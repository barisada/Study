package internet_lecture.alg_pknu_ac_kr.lecture._04_Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree_02_03_04_binary_search_tree {
    public static void main(String[] args) {
        Node root = new Node(15);
        BinarySearchTree bst = new BinarySearchTree(root);
        bst.add(new Node(6));
        bst.add(new Node(18));
        bst.add(new Node(3));
        bst.add(new Node(7));
        bst.add(new Node(17));
        bst.add(new Node(20));
        bst.add(new Node(2));
        bst.add(new Node(4));
        bst.add(new Node(13));
        bst.add(new Node(9));

        levelOrderPrint(bst.root);

        System.out.println("node 15 exist ? " + bst.search(new Node(13)));
        System.out.println("min node : " + bst.min());
        System.out.println("max node : " + bst.max());

        System.out.println("successor of 15 : " + bst.successor(new Node(15)));
        System.out.println("successor of 6 : " + bst.successor(new Node(6)));
        System.out.println("successor of 4 : " + bst.successor(new Node(4)));
        System.out.println("successor of 13 : " + bst.successor(new Node(13)));
        System.out.println("successor of 20 : " + bst.successor(new Node(20)));

        System.out.println("predecessor of 9 : " + bst.predecessor(new Node(9)));
        System.out.println("predecessor of 15 : " + bst.predecessor(new Node(15)));
        System.out.println("predecessor of 20 : " + bst.predecessor(new Node(20)));
        System.out.println("predecessor of 4 : " + bst.predecessor(new Node(4)));

        deleteTest();

    }

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

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static class BinarySearchTree{
        Node root;

        public BinarySearchTree(Node root) {
            this.root = root;
        }

        void add(Node node){
            Node curr = root.val < node.val ? root.right : root.left;
            Node prev = root;

            while(curr != null){
                prev = curr;
                if(curr.val < node.val) {
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
            if(prev.val < node.val){
                prev.right = node;
            } else {
                prev.left = node;
            }
        }

        void delete(Node node){

           Node curr = node.val == root.val ? root : root.val < node.val ? root.right : root.left;
           Node prev = node.val == root.val ? null : root;

           while(curr != null && curr.val != node.val){
               prev = curr;
               curr = curr.val > node.val ? curr.left : curr.right;
           }

           if(curr != null){
               if(curr.right == null && curr.left == null){
                   if(prev == null ){
                        root = null;
                   } else {
                       if(prev.val > curr.val){
                           prev.left = null;
                       } else {
                           prev.right = null;
                       }
                   }
               } else if(curr.right == null){
                   if(prev == null){
                       root = curr.left;
                   } else {
                       if(prev.val > curr.val){
                           prev.left = curr.left;
                       } else {
                           prev.right = curr.left;
                       }
                   }

               } else if(curr.left == null){
                   if(prev == null){
                       root = curr.right;
                   } else {
                       if(prev.val > curr.val){
                           prev.left = curr.right;
                       } else {
                           prev.right = curr.right;
                       }
                   }
               } else {
                   Node successor = successor(curr);
                   int data = successor.val;
                   delete(successor);
                   curr.val = data;
               }
           }
        }

        Node search(Node node){
            Node curr = root;
            while(curr != null && curr.val != node.val){
                curr = curr.val < node.val ? curr.right : curr.left;
            }
            return curr;
        }

        Node minOf(Node n){
            n = search(n);
            if(n != null) {
                Node curr = n;
                while (curr.left != null) {
                    curr = curr.left;
                }
                return curr;
            }
            return n;
        }

        Node min(){
            return minOf(root);
        }

        Node max(){
            return maxOf(root);
        }

        Node maxOf(Node n){
            n = search(n);
            if(n != null){
                Node curr= n;
                while(curr.right != null){
                    curr = curr.right;
                }

                return curr;
            }
            return n;
        }

        /**
         * Node x의 successor란 x보다 크만셔 가장 작은 노드.
         * Node x's successor is that greater than x, but has least value among them.
         * Note : suppose all node has different value.
         * @param x
         * @return
         */
        Node successor(Node x){
            x = search(x);
            if(x != null) {
                if(x.right != null) {
                    return minOf(x.right);
                } else {
                    Node successor = null;
                    Node curr = root;
                    while(curr != null){
                        if(curr.val > x.val){
                            successor = curr;
                            curr = curr.left;
                        } else if(curr.val < x.val){
                            curr = curr.right;
                        } else{
                            return successor;
                        }
                    }
                }
            }
            return x;
        }

        /**
         * Node x의 predecessor란 x보다 작으면서 가장 큰 노드
         * opposite to successor
         * @param x
         * @return
         */
        Node predecessor(Node x){
            x = search(x);
            if(x != null){
                if(x.left != null){
                    return maxOf(x.left);
                } else {
                    Node predecessor = null;
                    Node curr = root;
                    while(curr != null){
                        if(curr.val > x.val){
                            curr = curr.left;
                        } else if (curr.val < x.val){
                            predecessor = curr;
                            curr = curr.right;
                        } else {
                            return predecessor;
                        }
                    }
                }
            }
            return x;
        }
    }

    static void levelOrderPrint(Node node){
        List<List<Integer>> levels = new ArrayList<>();

        List<Node> q = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        if(node != null){
            q.add(node);
            level.add(node.val);
        }

        while(q.size() > 0){
            levels.add(level);

            List<Node> old = q;
            level = new ArrayList<>();
            q = new ArrayList<>();

            for(Node n : old){
                if(n.left != null){
                    level.add(n.left.val);
                    q.add(n.left);
                }
                if(n.right != null){
                    level.add(n.right.val);
                    q.add(n.right);
                }
            }
        }
        for(List<Integer> list : levels){
            System.out.println(list);
        }
        System.out.println("=========================");
    }

    private static void deleteTest() {
        BinarySearchTree bst = createTestTree();

        levelOrderPrint(bst.root);
        bst.delete(new Node(5));
        levelOrderPrint(bst.root);

        System.out.println(bst.search(new Node(10)));
    }

    private static BinarySearchTree createTestTree() {
        BinarySearchTree bst = new BinarySearchTree(new Node(15));
        bst.add(new Node(5));
        bst.add(new Node(16));
        bst.add(new Node(3));
        bst.add(new Node(12));
        bst.add(new Node(20));
        bst.add(new Node(10));
        bst.add(new Node(13));
        bst.add(new Node(18));
        bst.add(new Node(23));
        bst.add(new Node(6));
        bst.add(new Node(7));
        return bst;
    }

}

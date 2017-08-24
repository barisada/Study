package hackerrank.datastructure.tree;

/**
 * Created by jw on 2017-08-24.
 */
public class HuffmanDecoding {
    static class Node{
        public  int frequency; // the frequency of this tree
        public  char data;
        public  Node left, right;
        Node(char data, int freq){
            this.data = data;
            this.frequency = freq;
        }
    }
    void decode(String S ,Node root)
    {
        StringBuilder sb = new StringBuilder();
        Node node = root;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            node = c == '0' ? node.left : node.right;
            if(node.left == null && node.right == null){
                sb.append(node.data);
                node = root;
            }
        }
        System.out.println(sb.toString());

    }
    public static void main(String[] args) {
        char c = '\0';
        Node n1 = new Node(c, 5);
        Node n2 = new Node(c, 2);
        Node n3 = new Node('A', 3);
        Node n4= new Node('B', 1);
        Node n5 = new Node('C', 1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        HuffmanDecoding hd = new HuffmanDecoding();
        hd.decode("1001011", n1);

    }
}

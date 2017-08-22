package ourstudy.clrs.ch12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jw on 2017-08-23.
 */
public class BinarySearchTree {
    private BinarySearchTree parent;
    private BinarySearchTree left;
    private BinarySearchTree right;
    private int val;
    private int height;

    public BinarySearchTree(){
    }

    public BinarySearchTree(int val){
        this.val = val;
    }

    public void insert(int i){
        BinarySearchTree tree = new BinarySearchTree(i);
        walkAndInsertTree(this, tree);
    }

    private void walkAndInsertTree(BinarySearchTree p, BinarySearchTree tree) {
        if(p.val >= tree.val){
            if(p.left == null){
                p.left = tree;
                tree.parent = p;
            } else {
                walkAndInsertTree(p.left, tree);
            }
        } else {
            if(p.right == null){
                p.right = tree;
                tree.parent = p;
            } else {
                walkAndInsertTree(p.right, tree);
            }
        }
    }

    public void print(){
        Queue<BinarySearchTree> q = new LinkedList<>();
        q.add(this);
        while(true){
            if(q.size() == 0){
                break;
            }
            int count = q.size();
            List<Integer> list = new ArrayList<>();
            while(count > 0){
                BinarySearchTree t = q.poll();
                BinarySearchTree l = t.left;
                BinarySearchTree r = t.right;
                list.add(t.val);

                if(l != null){
                    q.add(l);
                }
                if(r != null){
                    q.add(r);
                }
                count--;
            }
            System.out.println(list);
        }
    }
}

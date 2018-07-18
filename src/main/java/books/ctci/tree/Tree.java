package books.ctci.tree;

public class Tree {
    private int val;
    private Tree left;
    private Tree right;
    private boolean visited;

    public Tree(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    private int depth(Tree tree) {
        if(tree == null) return 0;
        return 1 + Math.max( depth(tree.getLeft()), depth(tree.getRight()) );
    }
}

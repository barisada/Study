package books.ctci.tree.question;

import books.ctci.tree.Tree;
import books.ctci.tree.TreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class _4_3_ListOfDepths {

    public static List<List<Integer>> createLevelList(Tree tree){
        List<List<Integer>> lists = new ArrayList<>();
        createLevelList(tree, lists, 0);
        return lists;
    }

    private static void createLevelList(Tree tree, List<List<Integer>> lists, int level) {
        if(tree != null){
            List<Integer> list;
            if(lists.size() == level) {
                list = new ArrayList<>();
                lists.add(list);
            } else {
                list = lists.get(level);
            }

            list.add(tree.getVal());
            createLevelList(tree.getLeft(), lists, level + 1);
            createLevelList(tree.getRight(), lists, level + 1);
        }
    }

    private static List<List<Integer>> createLevelListByBFS(Tree tree){
        List<List<Integer>> lists = new ArrayList<>();

        List<Tree> currentTree = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        if(tree != null){
            current.add(tree.getVal());
            currentTree.add(tree);
        }

        while(current.size() > 0){
            lists.add(current);
            List<Tree> parentsTree = currentTree;

            current = new ArrayList<>();
            currentTree = new ArrayList<>();

            for(Tree t : parentsTree){
                if(t.getLeft() != null){
                    current.add(t.getLeft().getVal());
                    currentTree.add(t.getLeft());
                }

                if(t.getRight() != null){
                    current.add(t.getRight().getVal());
                    currentTree.add(t.getRight());
                }
            }
        }

        return lists;
    }


    public static void main(String[] args) {
        TreeTraversal treeTraversal = new TreeTraversal();
        Tree tree = treeTraversal.createSampleTree();

        List<List<Integer>> lists = createLevelList(tree);
        for(List<Integer> list : lists){
            System.out.println(list);
        }

        System.out.println("=========================");

        int[] array = {1,2,3,4,5,6,7,8,9};
        Tree tree2 = _4_2_MinimalTree.createMinimalBST(array);
        List<List<Integer>> lists2 = createLevelListByBFS(tree2);
        for(List<Integer> list : lists2){
            System.out.println(list);
        }
    }


}

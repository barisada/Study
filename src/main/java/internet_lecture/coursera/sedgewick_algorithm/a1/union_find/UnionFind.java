package internet_lecture.coursera.sedgewick_algorithm.a1.union_find;

/**
 * Created by jw on 2017-04-10.
 */
public interface UnionFind {

    public boolean connected(int p, int q);
    public void union(int p, int q);
    public int count();
    public int find(int p);
}

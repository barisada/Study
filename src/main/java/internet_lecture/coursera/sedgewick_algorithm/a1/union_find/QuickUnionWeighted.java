package internet_lecture.coursera.sedgewick_algorithm.a1.union_find;

import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 4. 14..
 */
public class QuickUnionWeighted implements UnionFind{
	private int count;
	private int[] id;
	private int[] sz;


	public QuickUnionWeighted(int size){
		this.count = size;
		this.id = new int[size];
		this.sz = new int[size];

		IntStream.range(0, size).forEach(i ->{
			id[i] = i;
			sz[i] = 1;
		});
	}
	public boolean connected(int p, int q) {
		return this.root(p) == this.root(q);
	}

	public int root(int i){
		while(this.id[i] != i){
			i = this.id[i];
		}
		return i;
	}

	public void union(int p, int q) {
		if(this.connected(p, q)){
			return;
		}

		int rootP = root(p);
		int rootQ = root(q);
		if(this.sz[rootP] < this.sz[rootQ]){
			this.id[rootP] = this.id[rootQ];
			this.sz[rootQ] += this.sz[rootP];
		} else {
			this.id[rootQ] = this.id[rootP];
			this.sz[rootP] += this.sz[rootQ];
		}
		count--;
	}

	public int count() {
		return count;
	}

	public int find(int i) {
		return this.root(i);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		StringJoiner sj = new StringJoiner(",");
		for(int i : id){
			sj.add(String.valueOf(i));
		}
		sb.append(sj);
		sb.append("]");
		return sb.toString();
	}
}

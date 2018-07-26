package interviewPrep.hackerrank.datastructure.disjoint_set;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 4. 16..
 */
public class MergingCommunities {
	private int[] id;
	private int[] comm;
	private int[] sz;

	public MergingCommunities(int size){
		this.id = new int[size];
		this.comm = new int[size];
		this.sz = new int[size];
		IntStream.range(1, size).forEach( i -> {
			id[i] = i;
			comm[i] = 1;
			sz[i] = 1;
		});
	}

	public int root(int i){
		while(id[i] != i){
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q){
		return root(p) == root(q);
	}

	public void union(int p, int q){
		if(!connected(p, q)){
			int rootP = root(p);
			int rootQ = root(q);
			if(sz[rootP] > sz[rootQ]){
				id[rootQ] = id[rootP];
				sz[rootP] += sz[rootQ];
				comm[rootP] += comm[rootQ];
			} else{
				id[rootP] = id[rootQ];
				sz[rootQ] += sz[rootP];
				comm[rootQ] += comm[rootP];
			}
		}
	}

	public int getCommunity(int i){
		return this.comm[root(i)];
	}

	public String toString(String str){
		int arr[];
		if(str.equalsIgnoreCase("id")){
			arr = id;
		} else{
			arr= comm;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		StringJoiner sj = new StringJoiner(",");
		for(int i : arr){
			sj.add(String.valueOf(i));
		}
		sb.append(sj);
		sb.append("]");
		return sb.toString();
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		int humans = Integer.valueOf(firstLine.split((" "))[0]);
		int queries = Integer.valueOf(firstLine.split((" "))[1]);

		List<String> queryList = new ArrayList<>();
		for(int i = 0; i < queries; i++){
			queryList.add(sc.nextLine());
		}
		sc.close();
		System.out.println(queryList);
		MergingCommunities mc = new MergingCommunities(humans + 1);
		queryList.stream().forEach(q -> {
			String[] line = q.split(" ");
			if(line[0].equalsIgnoreCase("Q")){
				System.out.println(mc.getCommunity(Integer.valueOf(line[1])));
				//System.out.println(mc.toString("id"));
			} else {
				mc.union(Integer.valueOf(line[1]), Integer.valueOf(line[2]));
			}
		});

	}
}

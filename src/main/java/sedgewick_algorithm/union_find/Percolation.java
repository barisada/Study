package sedgewick_algorithm.union_find;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.awt.*;
import java.util.StringJoiner;

/**
 * Created by jwlee1 on 2017. 4. 23..
 */
public class Percolation {

	private int size;
	private int[][] grid;
	private boolean isPercolated;
	private boolean[] full;
	private WeightedQuickUnionUF uf;

	// create n-by-n grid, with all sites blocked
	public Percolation(int n){
		if(n <= 0 ){
			throw new IllegalArgumentException();
		}
		this.size = n;
		this.grid = new int[n + 1][n + 1];
		this.full = new boolean[n*n + 1];
		this.uf = new WeightedQuickUnionUF( (n*n) + 1);
	}

	// open site (row, col) if it is not open already
	public void open(int row, int col){
		validation(row, col);
		if (this.grid[row][col] == 0) {
			int curRow = row - 1;
			int curCol = col;
			int p = (curRow * size) + col;
			this.grid[row][col] = p;

			int upRow = curRow - 1;
			int downRow = curRow + 1;
			int leftCol = col - 1;
			int rightCol = col + 1;

			if (row - 1 >= 1 && isOpen(row - 1, col)) {
				//up
				int q = (upRow * size) + curCol;
				uf.union(p, q);
			}
			if (row + 1 <= size && isOpen(row + 1, col)){
				//down
				int q = (downRow * size) + curCol;
				uf.union(p, q);
			}
			if(leftCol >= 1 && isOpen(row, leftCol)){
				//left
				int q = (curRow * size) + leftCol;
				uf.union(p, q);
			}
			if(rightCol <= size && isOpen(row, rightCol)){
				//right
				int q = (curRow * size) + rightCol;
				uf.union(p, q);
			}

			checkFull(p, uf.find(p));
			checkPecolation();
		}
	}

	private void checkFull(int index, int root) {
		for(int i = 1; i <=size; i++){
			if(uf.connected(i, root)){
				full[index] = true;
				break;
			}
		}
		if(full[index]){
			for(int j = 1; j < full.length; j++){
				if(root == uf.find(j)){
					full[j] = true;
				}
			}
		}
	}

	private void checkPecolation() {
		for(int i = 1; i <= size; i++) {
			if(isFull(size, i)) {
				isPercolated = true;
				break;
			}
		}
	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col){
		validation(row, col);
		return this.grid[row][col] > 0;
	}

	// is site (row, col) full?
	public boolean isFull(int row, int col){
		validation(row, col);
		return full[grid[row][col]];
		/*if(isOpen(row, col)) {
			if(row == 1 ){
				return true;
			}
			int p = grid[row][col];
			for(int i = 1; i <= size; i++){
				if(uf.connected(p, i)){
					return true;
				}
			}
			return false;
		} else {
			return false;
		}*/
	}

	// number of open sites
	public int numberOfOpenSites(){
		int count = 0;
		for(int i = 1; i <= size; i++){
			for(int j = 1; j <= size; j++){
				if(this.grid[i][j] > 0){
					count++;
				}
			}
		}
		return count;
	}

	// does the system percolate?
	public boolean percolates(){
		return isPercolated;
		/*
		boolean isFull = false;
		for(int i = 1; i <= size; i++){
			isFull = this.isFull(size, i);
			if(isFull){
				return isFull;
			}
		}
		return isFull;*/
	}

	private void validation(int row, int col) {
		if(!(row >= 1 && col >= 1 && row <= size && col <= size)) throw new IndexOutOfBoundsException();
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i <= size; i++){
			sb.append("[");
			StringJoiner sj = new StringJoiner(",");
			for(int j = 0; j <=size; j++) {
				sj.add(String.valueOf(grid[i][j]));
			}
			sb.append(sj);
			sb.append("]\r\n");
		}
		sb.append(uf.toString() + "\r\n");
		return sb.toString();
	}

	// test client (optional)
	public static void main(String[] args){
		//In in = new In("/Users/jwlee1/drjava_work/percolation/input10-no.txt");
		In in = new In("D:\\JW\\study\\coursera\\algorithm_part1\\percolation\\percolation-testing\\percolation\\input50.txt");
		int n = in.readInt();         // n-by-n percolation system
		Percolation p = new Percolation(n);
		while (!in.isEmpty()) {
			int i = in.readInt();
			int j = in.readInt();
			p.open(i, j);
			/*draw(p, n);
			StdDraw.show();*/
		}

		/*int n=8;
		Percolation p = new Percolation(8);*/

		draw(p, n);
		StdDraw.show();

		System.out.println(p.toString());
		System.out.println(p.percolates());
	}

	public static void draw(Percolation perc, int n) {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setXscale(-0.05*n, 1.05*n);
		StdDraw.setYscale(-0.05*n, 1.05*n);   // leave a border to write text
		StdDraw.filledSquare(n/2.0, n/2.0, n/2.0);

		// draw n-by-n grid
		int opened = 0;
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if (perc.isFull(row, col)) {
					StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
					opened++;
				}
				else if (perc.isOpen(row, col)) {
					StdDraw.setPenColor(StdDraw.WHITE);
					opened++;
				}
				else
					StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledSquare(col - 0.5, n - row + 0.5, 0.45);
			}
		}

		// write status text
		StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.25*n, -0.025*n, opened + " open sites");
		if (perc.percolates()) StdDraw.text(0.75*n, -0.025*n, "percolates");
		else                   StdDraw.text(0.75*n, -0.025*n, "does not percolate");

	}
}

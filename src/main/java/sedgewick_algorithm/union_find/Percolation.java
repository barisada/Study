package sedgewick_algorithm.union_find;

/**
 * Created by jwlee1 on 2017. 4. 23..
 */
public class Percolation {

	int size;
	int[][] grid;

	// create n-by-n grid, with all sites blocked
	public Percolation(int n){
		this.size = n;
		this.grid = new int[n][n];
	}

	// open site (row, col) if it is not open already
	public void open(int row, int col){
		if(this.grid[row][col] != 0){
			this.grid[row][col] = 1;
		}
	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col){
		return this.grid[row][col] == 1;
	}

	// is site (row, col) full?
	public boolean isFull(int row, int col){

	}

	// number of open sites
	public int numberOfOpenSites(){
		int count = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(this.grid[i][j] == 1){
					count++;
				}
			}
		}
		return count;
	}

	// does the system percolate?
	public boolean percolates(){
		boolean isFull = false;
		for(int i = 0; i < size; i++){
			isFull = this.isFull(size, i);
			if(isFull){
				return isFull;
			}
		}
		return isFull;
	}

	// test client (optional)
	public static void main(String[] args){

	}
}

package sedgewick_algorithm.union_find;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by jw on 2017-04-24.
 */
public class PercolationStats {
    int trials;
    double[] threshold;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials){
        if(n <= 0 || trials <= 0){
            throw new IllegalArgumentException();
        }
        this.trials = trials;
        threshold = new double[trials];
        for(int i = 0; i < trials; i ++){
            Percolation perc = new Percolation(n);
            while(!perc.percolates()){
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                perc.open(row, col);
            }
            System.out.println(perc.numberOfOpenSites() + "/" + (n*n) + " = " + ((double)perc.numberOfOpenSites()) / (double) (n*n));
            threshold[i] = ((double)perc.numberOfOpenSites()) / (double) (n*n);
        }
    }

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(threshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(threshold);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo(){
        return mean() - ((1.96 * stddev()) / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return mean() + ((1.96 * stddev()) / Math.sqrt(trials));
    }

    // test client (described below)
    public static void main(String[] args){
        /*int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);*/

        int n = 200;
        int trials = 10;
        PercolationStats pstats = new PercolationStats(n, trials);
        System.out.println("mean                    = " + pstats.mean());
        System.out.println("stddev                  = " + pstats.stddev());
        System.out.println("95% confidence interval = [" + pstats.confidenceLo() + ", " + pstats.confidenceHi() + "]");
    }

}

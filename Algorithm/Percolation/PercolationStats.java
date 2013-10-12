
public class PercolationStats {
   public PercolationStats(int N, int T)    // perform T independent computational experiments on an N-by-N grid
   {
       for(int iT = 0; iT < T; iT++)
       {
           Percolation percolation = new Percolation(N);
           int repeat = 0;
           do
           {
               repeat ++;
               int i,j;
               do
               {
                   i = StdRandom.uniform(N);
                   j = StdRandom.uniform(N);
                   
                  // StdOut.println(i);
                   
                   //StdOut.println(j);
               }
               while(percolation.isOpen(i,j) == true);
               
               percolation.open(i,j);
               
           } while(percolation.percolates() == false);
           
           
           StdOut.println(repeat);
       }
   }
//   public double mean()                     // sample mean of percolation threshold
//   public double stddev()                   // sample standard deviation of percolation threshold
//   public double confidenceLo()             // returns lower bound of the 95% confidence interval
//   public double confidenceHi()             // returns upper bound of the 95% confidence interval
   public static void main(String[] args)   // test client, described below
   {
       PercolationStats  stats = new PercolationStats(10,10);//(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
   }
}


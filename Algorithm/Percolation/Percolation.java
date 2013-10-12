
public class Percolation {
   private int sizeOfGrid;//N
   private boolean[] grid; //grid[i] = i is close if grid[i] = 0 open if grid[i] = 1
   public int indexOfArray(int i, int j) { return i*sizeOfGrid + j; }
   WeightedQuickUnionUF quickunion;
   public Percolation(int N)              // create N-by-N grid, with all sites blocked
   {
      if(N <= 0)
      {
          sizeOfGrid = 0; 
          throw new java.lang.IndexOutOfBoundsException("N is less or same as zero");
      }
      sizeOfGrid = N;
      grid = new boolean[sizeOfGrid*sizeOfGrid]; 
      for(int i = 0; i < sizeOfGrid; i++)
      {
           for(int j = 0; j < sizeOfGrid; j++)
               grid[indexOfArray(i,j)] = false;
      }
      quickunion = new WeightedQuickUnionUF(sizeOfGrid*sizeOfGrid);
   }
   public void open(int i, int j)         // open site (row i, column j) if it is not already
   {
       if( i < 0 || i > sizeOfGrid-1 || j < 0 || j > sizeOfGrid-1)
           throw new java.lang.IndexOutOfBoundsException("N is less or same as zero");
       
       grid[indexOfArray(i,j)] = true;
       
       if ( i > 0 )
           if(grid[indexOfArray(i-1,j)])
              quickunion.union(indexOfArray(i-1,j),indexOfArray(i,j));
       if( j > 0 )
           if(grid[indexOfArray(i,j-1)])
              quickunion.union(indexOfArray(i,j-1),indexOfArray(i,j));
       if( i < sizeOfGrid-1 )
           if(grid[indexOfArray(i+1,j)])
              quickunion.union(indexOfArray(i+1,j),indexOfArray(i,j));
        if( j < sizeOfGrid-1 )
           if(grid[indexOfArray(i,j+1)])
              quickunion.union(indexOfArray(i,j+1),indexOfArray(i,j));
       
   }
   public boolean isOpen(int i, int j)    // is site (row i, column j) open?
   {
       if( i < 0 || i > sizeOfGrid-1 || j < 0 || j > sizeOfGrid-1)
           throw new java.lang.IndexOutOfBoundsException("N is less or same as zero");
       return grid[indexOfArray(i,j)];
   }
   public boolean isFull(int i, int j)    // is site (row i, column j) full?
   {
       if( i < 0 || i > sizeOfGrid-1 || j < 0 || j > sizeOfGrid-1)
           throw new java.lang.IndexOutOfBoundsException("N is less or same as zero");
      int row = 0; //row index;
      for (int col = 0; col < sizeOfGrid; col++ )
          if(quickunion.connected(indexOfArray(i,j),indexOfArray(row,col)))
                 return true;
             
      return false;
   }
   public boolean percolates()     // does the system percolate?
   {
      int i = sizeOfGrid - 1;
      for (int j = 0; j < sizeOfGrid; j++ )
          if(isFull(i,j))
              return true; 
      
      return false;
   }              
}
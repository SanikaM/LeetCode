class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int max = 0;
        
        for(int i =0;i<grid.length;i++) {
            
            for(int j =0;j<grid[0].length;j++) {
                
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0)
            return 0;
        
            grid[i][j] = 0;
     
        
        return 1+ dfs(grid, i-1,j) +
            dfs(grid, i,j-1) +
            dfs(grid, i+1,j) +
            dfs(grid, i,j+1);
    }
}
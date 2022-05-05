class Solution {
    public int shortestBridge(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        boolean flag = false;
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    flag = true;
                    break;
                }
                
            }
            if(flag == true)
                break;
            
        }
        
        return bfs(grid, q);
    }
    
    private void dfs(int[][]  grid, int i, int j, Queue<int[]> q) {
        
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j] == -1 || grid[i][j] ==0)
            return;
        
        grid[i][j] = -1;
        q.offer(new int[]{i,j});
        
        dfs(grid, i-1, j, q);
        dfs(grid, i+1, j, q);
        dfs(grid, i, j-1, q);
        dfs(grid, i, j+1, q);
        
        
        return;
    }
    
    private int bfs(int[][] grid, Queue<int[]> q) {

        int levels = 0;
        int[][] traversal = {{-1,0},{0,1},{1,0},{0,-1}};
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            while(size-- >0) {
                
                int[] temp = q.poll();
                
                for(int[] dir : traversal) {
                    
                    int i = temp[0] + dir[0];
                    int j = temp[1] + dir[1];
                    
                    if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j] == -1)
                        continue;
                    
                    if(grid[i][j] == 1)
                        return levels;
                    else {
                        
                        grid[i][j] = -1;
                        q.offer(new int[]{i,j});
                    }
                    
                }
            }
            levels++;
            
            
        }
        return -1;
        
    }
    
}
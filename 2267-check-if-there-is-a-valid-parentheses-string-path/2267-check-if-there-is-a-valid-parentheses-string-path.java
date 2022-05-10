class Solution {
    public Map<String, Boolean> map;
    
    public boolean hasValidPath(char[][] grid) {

        map = new HashMap<>();
                
        return dfs(0,0,grid,0);
    }
    
    private boolean dfs(int i, int j, char[][] grid, int openCount) {
        
          if(i<0 || i >= grid.length || j<0 || j>=grid[0].length) 
            return false;
        if(i == grid.length-1 && j == grid[0].length-1) {
            
            if(openCount == 1 && grid[i][j] == ')')
                return true;
            else
                return false;
        }
        if(openCount < 0)
            return false;
        String str = Integer.toString(i) +'*'+Integer.toString(j)+'*'+Integer.toString(openCount);
        if(map.containsKey(str)) {
           // System.out.println("I am in");
            return map.get(str);
        }
        if(grid[i][j] == '(') 
            map.put(str, dfs(i+1,j,grid,openCount+1) || dfs(i,j+1,grid,openCount+1));
        else
            map.put(str, dfs(i+1,j,grid,openCount-1) || dfs(i,j+1,grid,openCount-1));
        
        return map.get(str);
    }
}
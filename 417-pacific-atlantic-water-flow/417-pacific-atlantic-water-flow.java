class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        int row = heights.length; 
        if(row == 0)
            return result;
        
        int col = heights[0].length;
        
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        
        // top to bottom
        for(int i=0;i<col;i++) {
            dfs(heights, 0, i, heights[0][i], pacific);
            dfs(heights, row-1, i, heights[row-1][i], atlantic);
        }
        
        // left to right
        for(int i=0;i<row;i++) {
            dfs(heights, i, 0, heights[i][0], pacific);
            dfs(heights, i, col-1, heights[i][col-1], atlantic);
        }
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    result.add(curr);
                }
            }
        }
        
        return result;
        
    }
    
    private void dfs(int[][] heights, int i, int j, int preheight, boolean[][] ocean) {
        
        if(i<0 || i>= heights.length || j<0 || j>= heights[0].length || preheight > heights[i][j] || ocean[i][j])
            return;
        
        ocean[i][j] = true;
        
        dfs(heights, i+1, j, heights[i][j], ocean);
        dfs(heights, i, j+1, heights[i][j], ocean);
        dfs(heights, i-1, j, heights[i][j], ocean);
        dfs(heights, i, j-1, heights[i][j], ocean);
    }
}
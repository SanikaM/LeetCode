class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int ans =0;
        if(matrix.length == 0)
            return ans;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        return ans;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        
        if(cache[i][j] != 0) return cache[i][j];
        
        int[][] dirs = {{0,1},{1,0},{0,-1}, {-1,0}};
        
        for(int[] dir : dirs) {
            
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x >=0 && x < matrix.length && y>=0 && y < matrix[0].length && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
        }
        
        return ++cache[i][j];
    }
}
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int[] cityRoads = new int[n];
        
        int maxRanks =0;
        
        boolean[][] exist = new boolean[n][n];
        
        for(int[] city : roads) {
            
            cityRoads[city[0]]++;
            cityRoads[city[1]]++;
            
            exist[city[0]][city[1]] = true;
            exist[city[1]][city[0]] = true;
        }
        
        for(int city1 =0; city1 < n; city1++) {
            for(int city2 =city1+1; city2 < n; city2++) {
                
                int rank =0;
                
                rank = cityRoads[city1] + cityRoads[city2];
                
                if(exist[city1][city2])
                    rank--;
                
                maxRanks = Math.max(maxRanks, rank);
            }
        }
        
        return maxRanks;
    }
}
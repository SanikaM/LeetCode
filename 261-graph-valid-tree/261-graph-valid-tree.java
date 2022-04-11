class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        int[] ids = new int[n];
        
        for(int i =0;i<n;i++) 
            ids[i] = i;
        
        for(int[] edge : edges) {
            if(!union(edge[0], edge[1], ids))
                return false;
        }
        for(int i=0;i<n;i++) 
        {
            find(ids[i], ids);
        }
        
         return edges.length == n - 1;
    }
    
    private boolean union(int edge1, int edge2, int[] ids) {
        
        int p1 = find(edge1, ids);
        int p2 = find(edge2, ids);
        
        if(p1 == p2)
            return false;
        ids[p1] = p2;
        
        return true;
    }
    
    private int find(int edge, int[] ids) {
        
        if(ids[edge] != edge) 
            ids[edge] = find(ids[edge], ids);
        
        return ids[edge];
    }
}
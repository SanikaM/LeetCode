class Solution {
    public int countComponents(int n, int[][] edges) {
        
        Set<Integer> set = new HashSet<>();
        
        int[] ids = new int[n];
        for(int i=0;i<n;i++) 
            ids[i] = i;
        
        for(int[] edge : edges) 
            union(edge[0], edge[1], ids);
        
        for(int i=0;i<n; i++) 
            set.add(find(ids[i],ids));
        
        return set.size();
        
        
    }
    
    private void union(int edge1,int edge2,int[] ids) {
        int p1 = find(edge1, ids);
        int p2 = find(edge2, ids);
        
        ids[p1] = p2;
    }
    
    private int find(int edge, int[] ids) {
        if(ids[edge] !=edge) ids[edge] = find(ids[edge], ids);
        
        return ids[edge]; 
    }
}
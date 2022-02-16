class Solution {
    
    public boolean dfs(int u,List<Integer>[] adj,List<Integer> s,int[] visited){
        
        visited[u] = 1;
        for(int i: adj[u]) {
            if(visited[i] == 1)
                return true;
            if(visited[i] ==0 && dfs (i,adj,s,visited))
                return true;
            
        }
        visited[u] =2;
        s.add(u);
        return false;
        
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adj = new LinkedList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i] = new LinkedList<Integer>();
        
        List<Integer> s = new ArrayList<>();
        int[] visited = new int[numCourses];
        
        for(int[] pre: prerequisites)
            adj[pre[1]].add(pre[0]);
        
        for(int i=0;i<numCourses;i++) {
            if(visited[i] == 0 && dfs(i,adj,s,visited))
                return new int[0];
        }
        
        Collections.reverse(s);
        int[] result = new int[s.size()];
        int c =0;
        for(int val : s) {
            result[c] = val;
            c++;
        }
        
        return result;
    }
}
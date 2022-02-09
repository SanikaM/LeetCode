class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        int visited[] = new int[numCourses];
        
        //create empty adj list
        for(int i =0;i< numCourses; i++){
            adj.add(new ArrayList<>())    ;
        }
        
        // create adj list
        for( int i =0;i< prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add( prerequisites[i][0]);
        }
       
        //detect cycle
        for( int i=0;i< numCourses;i++){
           if(isCycle(adj,visited,i))
               return false;
        }
        return true;
    }
    
    public boolean isCycle(List<List<Integer>> adj,int [] visited, int node){
        
        // state 0 - not visited yet
        // state 1 -  being visited ie, exploring all its neighbors
        // stste 2 - completely visited
        
        //there is a cycle
        if( visited[node] == 1)
            return true;
        
        if( visited[node] ==2)
            return false;
        
        //now visiting the curr node
        visited[node] =1;
        
        //visit node's adj list
        for( int i : adj.get(node)){
                    if( isCycle(adj,visited,i))
                         return true;
        }
        
        visited[node]=2;
        return false;
            
    }
    
}
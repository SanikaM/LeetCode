class Solution {
    public boolean isBipartite(int[][] graph) {
        
        // 0 - no color
        // 1 - blue
        // -1 - red
        
        int len = graph.length;
        int[] color = new int[len];
        
        for(int i=0;i<len;i++) {
            
            if(color[i] !=0)
                continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1;
            
            while(!queue.isEmpty()) {
                
                int curr = queue.poll();
                for(int neighbor : graph[curr]) {
                    
                    if(color[neighbor] == 0) {
                        color[neighbor] = - color[curr];
                        queue.offer(neighbor);
                    }
                    else if(color[neighbor] != - color[curr])
                        return false;
                    
                }
            }
            
        }
        
        return true;
    }
}
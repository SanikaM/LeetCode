class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        int start = n*n;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if((n-i)%2 ==0)
                    map.put(start, board[i][j]);
                else
                    map.put(start, board[i][n-j-1]);
            start--;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(1);
        visited.add(1);
        int step =0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i=0;i<size;i++) {
                
                int current = queue.poll();
                if(current == n*n)
                    return step;
                
                for(int j=1;j<=6;j++) {
                    
                    int newPoint = current+ j;
                    
                    if(newPoint > n*n)
                        break;
                    
                    if(map.get(newPoint) != -1)
                        newPoint = map.get(newPoint);
                    if(!visited.contains(newPoint)) {
                        queue.add(newPoint);
                        visited.add(newPoint);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
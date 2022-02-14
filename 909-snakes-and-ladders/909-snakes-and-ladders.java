class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int start = n*n;
        
        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if ((n-i) % 2 == 0) {
                   hm.put(start, board[i][j]);
                } else {
                   hm.put(start, board[i][n - j - 1]);
                }
                start--;
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(1);
        visited.add(1);
        int step =0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0;i<size;i++){
            int current = queue.poll();
            if(current == n*n)
                return step;
            
            for(int j=1;j<=6;j++) {
                
                int newPoint = current + j;
                
                if(newPoint > n*n)
                    continue;
                
                if(hm.get(newPoint) != -1)
                    newPoint = hm.get(newPoint);
                
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
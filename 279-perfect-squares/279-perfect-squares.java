class Solution {
    public int numSquares(int n) {
        
        int levels = 0;
        
        ArrayList<Integer> sqrs = new ArrayList<>();
        
        for(int i=1; i * i <= n ; ++i) 
            sqrs.add(i*i);
        
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        
        while(queue.size() > 0) {
            
            levels += 1;
            Set<Integer> q = new HashSet<>();
            
            for(Integer rem : queue) {
                for(Integer sqr : sqrs) {
                    
                    if(rem.equals(sqr))
                        return levels;
                    else if(rem < sqr)
                        break;
                    else
                        q.add(rem - sqr);
                }
            }
            
            queue = q;
        }
        
        return levels;
    }
}
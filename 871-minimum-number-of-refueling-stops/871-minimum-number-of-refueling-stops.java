class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        
        int n = stations.length;
        
        int count =0, i =0;
        int distance = startFuel;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        
        while(distance < target) {
            
            while(i<n && distance >= stations[i][0]) {
                pq.offer(stations[i]);
                i++;
            }
            
            if(pq.isEmpty())
                return -1;
            
            
            distance += pq.remove()[1];
            count++;
        }
        
        return count;
        
    }
}
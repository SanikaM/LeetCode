class Solution {
    public int connectSticks(int[] sticks) {
        
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total =0;
        for(int s : sticks)
            pq.add(s);
        
        while(pq.size() > 1)
        {
            int s1 = pq.remove();
            int s2 = pq.remove();
            
            int cost = s1 + s2;
            total += cost;
            
            pq.add(s1 + s2);
        }
        
        return total;
    }
}
class Solution {
    public int minSetSize(int[] arr) {
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int a : arr) 
            map.put(a, map.getOrDefault(a,0)+1);
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        
        pq.addAll(map.keySet());
        
        int half = arr.length /2;
        
        int count =0, result =0;
        
        while(count < half) {
            int temp = pq.remove();
            count = count+map.get(temp);
            result++;
            
        }
        
        return result;
    }
}
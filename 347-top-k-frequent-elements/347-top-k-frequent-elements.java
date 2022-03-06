class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        Queue<Integer> que = new PriorityQueue<Integer>((n1,n2) -> map.get(n2) - map.get(n1));
        
        for(int n : map.keySet()) {
            que.add(n);
        }
        
        for(int i=0;i<k;i++) {
            result[i] = que.poll();
        }
        
        return result;
    }
}
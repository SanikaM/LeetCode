class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       
        Map<String, Integer> map = new HashMap<>();
        for(String w : words) 
            map.put(w, map.getOrDefault(w, 0)+1);
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> map.get(b).equals(map.get(a)) ? a.compareTo(b) : map.get(b) - map.get(a));
        
        for(String w : map.keySet())
            pq.add(w);
        
        List<String> result = new ArrayList<>();
        for(int i=0;i<k;i++) 
            result.add(pq.poll());
        
        return result;
    }
}
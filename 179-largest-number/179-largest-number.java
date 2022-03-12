class Solution {
    public String largestNumber(int[] nums) {
        
        boolean flag = false;
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->(b+a).compareTo(a+b));
        
        for(int n : nums){
            if(n!=0)
                flag = true;
            pq.add(""+n);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
            sb.append(pq.poll());
        
        return flag?sb.toString():"0";
    }
}
class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->(b+a).compareTo(a+b));
        boolean flag = false;
        for(int n:nums){
            String res =""+n;
            if(n!=0)
                flag = true;
            pq.add(res);
        }
        String res="";
        while(!pq.isEmpty()){
            res+=pq.poll();
        } 
        return flag?res:"0";
    }
}
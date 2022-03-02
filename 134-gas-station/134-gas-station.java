class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if(sum(gas) < sum(cost))
            return -1;
        
        int start = 0;
        int total =0;
        for(int i=0;i<gas.length;i++) {
            
            total += gas[i] - cost[i];
            if(total < 0) {
                total=0;
                start = i+1;
            }
        }
        return start;
    }
    
    private int sum(int[] ele) {
        
        int sum =0;
        if(ele.length == 0)
            return sum;
        
        for(int e : ele)
            sum += e;
        
        return sum;
    }
}
class Solution {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
         int prevTwo =0, prevOne =0, max =0;
        
        for(int i=0;i<nums.length;i++) {
            
            max = Math.max(nums[i] + prevTwo, prevOne);
            prevTwo = prevOne;
            prevOne = max;
        }
        return max;
    }
}
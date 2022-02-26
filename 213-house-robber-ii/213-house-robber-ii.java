class Solution {
    public int rob(int[] nums) {
      
        if(nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        
        if(nums.length ==2)
            return Math.max(nums[0], nums[1]);
        
        return Math.max(helper(nums, 1, nums.length), helper(nums,0, nums.length-1));
        
    }
    
    public int helper(int[] nums, int start, int end) {
        
        int prevTwo =0, prevOne =0, max =0;
        
        for(int i=start;i<end;i++) {
            
            max = Math.max(nums[i] + prevTwo, prevOne);
            prevTwo = prevOne;
            prevOne = max;
        }
        return max;
    } 
}
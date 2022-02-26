class Solution {
    public int maxProduct(int[] nums) {
        
        int result = nums[0];
        int curr_max = nums[0];
        int curr_min = nums[0];
        
        for(int i=1;i< nums.length;i++) {
            
            int curr_max_prev = curr_max;
            curr_max = Math.max(nums[i] , Math.max(curr_min * nums[i], curr_max_prev *nums[i]));
            curr_min = Math.min(nums[i] , Math.min(curr_min * nums[i], curr_max_prev *nums[i]));
            
            
            result = Math.max(curr_max, result);
        }
        return result;
    }
}
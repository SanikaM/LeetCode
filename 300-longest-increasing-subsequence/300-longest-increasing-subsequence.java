class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp,1);
        
         for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                
                if(nums[i]>nums[j])
                    dp[i]= Math.max(dp[i], 1+ dp[j]);
            }
        }
        
        int max = 0;
        for (int d: dp) {
            max = Math.max(max, d);
        }
        
        return max;
    }
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int count=0,i=0;
        for(i=0;i<nums.length&&count<k;i++)
        {
            if(nums[i]==0)
            {
                count++;
            }
        }
        int maxLen=0,left=-1;
        for(;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                maxLen=Math.max(maxLen,i-1-left);
                while(left<i&&nums[++left]!=0)
                {
                    continue;
                }
            }
        }
        return Math.max(maxLen,nums.length-1-left);

        
    }
}
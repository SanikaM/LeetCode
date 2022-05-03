class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int left =0;
        int right = -1;
        
        int max = nums[0];
        for(int i =1;i<nums.length;i++) {
            
            if(nums[i] < max) 
                right = i;
            max = Math.max(max, nums[i]);
            
        }
        
        int min = nums[nums.length-1];
        
        for(int j =nums.length-2;j>=0;j--) {
            
            if(nums[j] > min) 
                left = j;
            min = Math.min(min, nums[j]);
            
        }
        
        return right-left+1;
    }
}
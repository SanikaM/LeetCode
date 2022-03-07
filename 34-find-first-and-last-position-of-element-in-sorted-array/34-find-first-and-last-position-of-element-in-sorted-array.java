class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        result[0] = findStartIndex(nums, target);
        result[1] = findEndIndex(nums, target);
        
        return result;
    }
    
    private int findStartIndex(int[] nums, int target) {
        
        int index = -1;
        int start =0;
        int end = nums.length-1;
        
        while(start<=end) {
            
            int midpoint = start + (end-start) /2;
            if(nums[midpoint] >= target) 
                end = midpoint -1;
            else
                start = midpoint +1;
            
            if(nums[midpoint] == target) 
                index = midpoint;
            
        }
        return index;
        
    }
    
     private int findEndIndex(int[] nums, int target) {
        
        int index = -1;
        int start =0;
        int end = nums.length-1;
         
        while(start<=end) {
            
             int midpoint = start + (end-start) /2;
            
            if(nums[midpoint] <= target) 
                 start = midpoint +1;
            else
                end = midpoint -1;
            
            if(nums[midpoint] == target) 
                index = midpoint;
            
        }
        
        return index;
    }
}
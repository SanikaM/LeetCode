class Solution {
    public int maxArea(int[] height) {
        
        
        int max = 0;
        
        if(height == null || height.length == 0)
            return max;
        int start =0;
        int end = height.length -1;
        while(start < end ) {
            int min = Math.min( height[start] , height[end]);
            max = Math.max(max, min * (end - start));
            
            
            if(height[start] > height[end])
                end--;
            else 
                start++;
            
            
        }
        return max;
    }
}
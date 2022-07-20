class Solution {
    public int trap(int[] height) {
        
        if(height.length == 0) 
            return 0;
        
        int maxL = height[0];
        int maxR = height[height.length-1];
        
        int l =0, r = height.length-1;
        int res =0;
        
        while(l<r) {
            
            if(maxL < maxR) {
                l +=1;
                maxL = Math.max(maxL, height[l]);
                res += maxL - height[l];
            }
            else {
                r-=1;
                maxR = Math.max(maxR, height[r]);
                res += maxR - height[r];
            }
        }
        
        return res;
    }
}
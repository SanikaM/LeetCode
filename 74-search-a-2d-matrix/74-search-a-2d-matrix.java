class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0)
            return false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = rows * cols -1;
        
        while(left <= right) {
            
            int mid = left + (right-left)/2;
            int mid_ele = matrix[mid/cols][mid%cols];
            
            if(mid_ele == target)  
                return true;
            else if(target < mid_ele)
                right = mid-1;
            else if(target > mid_ele)
                left = mid+1;
        }
        
        return false;
    }
}
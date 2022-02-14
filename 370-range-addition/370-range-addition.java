class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        
        int[] cachedResult = new int[length];
        
        for(int[] u : updates){
            
            cachedResult[u[0]] += u[2];
            if(u[1] + 1 < length)
            cachedResult[u[1]+1] -= u[2];
        }
        
        for(int i =1; i<length; i++){
            
            cachedResult[i] += cachedResult[i-1];
        }
        
        return cachedResult;
    }
}
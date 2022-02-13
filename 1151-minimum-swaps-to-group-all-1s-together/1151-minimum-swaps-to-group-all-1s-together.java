class Solution {
    public int minSwaps(int[] data) {
        
        int windowSize =0;
        
        for(int val : data)
            windowSize += val;
        
        int currentOnes = 0;
        int maxOnes = 0;
        
        for(int i=0; i<data.length;i++) {
            
            currentOnes += data[i];
            
            
            if(i>=windowSize)
                currentOnes -= data[i-windowSize];
            
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        
        return windowSize - maxOnes;
    }
}
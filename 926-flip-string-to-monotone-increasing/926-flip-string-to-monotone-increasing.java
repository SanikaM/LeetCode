class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int zeroToOnes =0;
        int oneCounts =0;
        int i=0;
        while(i<s.length() && s.charAt(i)=='0')
            i++;
        
        for(; i<s.length(); i++){
            
            if(s.charAt(i) == '0')
                zeroToOnes++;
            else
                oneCounts++;
            if(zeroToOnes > oneCounts)
                zeroToOnes = oneCounts;
        }
        
        return zeroToOnes;
        
    }
}
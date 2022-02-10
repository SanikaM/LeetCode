class Solution {
    public int countSubstrings(String s) {
        
        int count =0;
        
        for(int i=0;i<s.length();i++)
        {
            count = count + countPalindromes(s,i,i);
            
            count = count + countPalindromes(s,i,i+1);
        }
    return count;
    }
    
    public int countPalindromes(String ss, int lo, int hi){
        
        int count =0;
        
        while(lo>=0 && hi<ss.length()){
            if(ss.charAt(lo) != ss.charAt(hi))
                break;
            
            lo--;
            hi++;
            
            count++;
        }
        
        return count;
    }
    
}
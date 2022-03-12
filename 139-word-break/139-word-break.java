class Solution {
    
    /*
    I had declared the map inside the method first. which again gave TLE.
Remember this !!! -- Declare map outside, you dont wanna create the map everytime the recursive call takes place.
    */
    
    public Map<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
     
        if(wordDict.contains(s))
            return true;
        
        
        
        if(map.containsKey(s))
            return map.get(s);
        
        for(int i =1; i<= s.length(); i++) {
            
            String left = s.substring(0,i);
            if(wordDict.contains(left) && wordBreak(s.substring(i), wordDict))
            {
                map.put(s, true);
                return true;
            }
            
                                          
        }
         map.put(s,false);   
        return false;
       
    }
    
    
}
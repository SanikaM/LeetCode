class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> result = new ArrayList<>();
        
        if(wordDict.contains(s))
            result.add(s);
        
        if(map.containsKey(s))
            return map.get(s);
        
        for(int i=1; i<s.length();i++) {
            
            String left = s.substring(0,i);
            if(wordDict.contains(left)) {
                
                List<String> subList = wordBreak(s.substring(i), wordDict);
                for(String str : subList) {
                    
                    result.add(left +" "+ str);
                }
            }
        }
        map.put(s,result);
        return result;
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int start =0;
        int end = p.length()-1;
        HashMap<Character, Integer> p_map = new HashMap<>();
        HashMap<Character, Integer> s_map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(char c : p.toCharArray())
            p_map.put(c, p_map.getOrDefault(c,0)+1);
        
            
        char ch;
        for(int i=0;i< s.length(); i++) {
            
            
            s_map.put(s.charAt(i), s_map.getOrDefault(s.charAt(i),0)+1);      
           
            if(i >= p.length()) {
                

                ch = s.charAt(i-p.length());
                
                if(s_map.get(ch) == 1)
                    s_map.remove(ch);
                else
                    s_map.put(ch, s_map.get(ch) - 1);
                
               
                     
            }
            
            if(p_map.equals(s_map))
                   result.add(i- p.length() +1);
             
        }
        
        return result;
        
    }
}
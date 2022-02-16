class Solution {
    public int firstUniqChar(String s) {
       int count =0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i =0;i<s.length();i++)
        {
            
            
             if(!freqMap.containsKey(s.charAt(i)))
            {
                freqMap.put(s.charAt(i),0);
            }
            else
            {
                int temp = freqMap.get(s.charAt(i));
                temp++;
                freqMap.put(s.charAt(i), temp);
            }
            
           
        }
         for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 0) 
                return i;
        }
        return -1;
    }
}
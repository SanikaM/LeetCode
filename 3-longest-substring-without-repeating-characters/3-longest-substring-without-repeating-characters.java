class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int begin = 0;
        int end =0;
        int max = 0;
        HashSet<Character> hset = new HashSet<>();
        
        while(end < s.length())
        {
            if(!hset.contains(s.charAt(end))){
                hset.add(s.charAt(end));
                end++;
                max = Math.max(hset.size(), max);
            }
            else
            {
                hset.remove(s.charAt(begin));
                begin++;
            }
        }
        return max;
    }
}
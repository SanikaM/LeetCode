class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs) {
            char[] sortStr = str.toCharArray();
            Arrays.sort(sortStr);
            String temp = new String(sortStr);
            if(!map.containsKey(temp))
            {
                map.put(temp, new ArrayList<String>());
                map.get(temp).add(str);
            }
            else
                map.get(temp).add(str);
            
        }
        result.addAll(map.values());
      return result;
    }
}
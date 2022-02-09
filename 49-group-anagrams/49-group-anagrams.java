class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs)
        {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
                
        }
        groupedAnagrams.addAll(map.values());
        return groupedAnagrams;
    }
}
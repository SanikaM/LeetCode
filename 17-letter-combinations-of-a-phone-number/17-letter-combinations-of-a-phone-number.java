class Solution {
    
    Map<Character, String> map = Map.of('2',"abc",'3',"def", '4', "ghi", '5', "jkl", '6',"mno",
                                       '7', "pqrs", '8', "tuv", '9', "wxyz");
    public List<String> letterCombinations(String digits) {
        
         List<String> ans = new ArrayList<>();
        
        if(digits.length() ==0)
            return ans;

        int max = digits.length();
        backtrack(ans, 0, new StringBuilder(), max, digits);
        return ans;
    }
    
    private void backtrack(List<String> ans,int index, StringBuilder curr, int max, String digits) {
        
        if(curr.length() == max) {
            ans.add(curr.toString());
            return;
        }
        
        char currNum = digits.charAt(index);
        String letters = map.get(currNum);
        for(char letter : letters.toCharArray() ) {
            curr.append(letter);
            backtrack(ans, index+1, curr, max, digits);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
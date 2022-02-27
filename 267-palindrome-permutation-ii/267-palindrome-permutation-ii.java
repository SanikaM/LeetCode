class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] map = new int[256];
        
        int odd = 0;
        
        for(char c : s.toCharArray()) {
            
            map[c]++;
            if(map[c] % 2 ==1)
                odd++;
            else
                odd--;
            
        }
        
        if(s.length() == 0 || odd > 1)
            return res;
        String temp = "";
        for(int i=0;i<256;i++) {
            
            if(map[i] %2 == 1) {
                
                temp += (char)i;
                map[i]--;
            }
        }
        
        helper(res, map, s.length(), temp );
        return res;
    }
    
    private void helper(List<String> res, int[] map, int n, String temp) {
        
        if(temp.length() == n)
        {
            res.add(temp);
            return;
           
        }
        
        for(int i=0;i<256;i++) {
           if(map[i] >0) { 
                map[i] -=2;
                helper(res, map, n, (char)i + temp + (char)i );
                map[i] +=2;
           }
        }
    }
}


/*
1. Calculate chr freq
2. Find the single odd char and keep in middle of temp string
3. call helper function
4. If the length of the generated temp string == given string, add it to result and return
5. recursive call to all the map characters, where you create teh string by adding odd character in center and the two chars at both sides. 
6. Add the map count again because we want to calculet the permutations. 
*/
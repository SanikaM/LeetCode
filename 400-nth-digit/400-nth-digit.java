class Solution {
    public int findNthDigit(int n) {
     
        int digit = 1;
        int range = 9;
        
        while(n - range > 0) {
            
            n -= range;
            digit +=1;
            
            range = 9 * ((int)(Math.pow(10, digit -1)) * digit);
            
            if(range < 0)
                break;
        }
        
        int base = ((int)Math.pow(10, digit -1));
        
        int num = base + (n-1) / digit;
        
        char ans = String.valueOf(num).charAt((n-1)% digit);
        
        return ans - '0';
        
    }
}
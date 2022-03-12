class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i =0; i<=amount;i++) {
            
            for(int c =0;c<coins.length;c++) {
                
                if(coins[c] <= i)
                    dp[i] = Math.min(dp[i], 1+ dp[i-coins[c]]);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] prices = new int[n];
        
        for(int i=0;i<n;i++)
            prices[i] = Integer.MAX_VALUE;
        
        prices[src] =0;
        
        for(int i=0;i<=k;i++) {
            
            int[] tmp = prices.clone();
            
            for(int[] arr : flights) {
                
                int s = arr[0], d = arr[1], p = arr[2];
                if(prices[s] == Integer.MAX_VALUE)
                    continue;
                if(prices[s] + p < tmp[d])
                    tmp[d] = prices[s] + p;
            }
            
            prices = tmp.clone();
        }
        
        if(prices[dst] == Integer.MAX_VALUE)
            return -1;
        else
            return prices[dst];
    }
}
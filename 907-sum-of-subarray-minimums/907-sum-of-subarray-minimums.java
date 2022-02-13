class Solution {
    
    public long m = (int)Math.pow(10,9)+7;
    public int sumSubarrayMins(int[] arr) {
        
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        
        ArrayDeque<Pair> stack1 = new ArrayDeque<>();
        ArrayDeque<Pair> stack2 = new ArrayDeque<>();
        
        for(int i=0;i< arr.length;i++)
        {
            int count =1;
            int curr = arr[i];
            while(stack1.size() != 0 && stack1.peek().element > curr){
                count += stack1.peek().numMin;
                stack1.pop();
            }
            stack1.push(new Pair(curr,count));
            left[i] = count;
        }
        for(int i= arr.length-1;i>=0;i--){
            
            int curr= arr[i];
            int count =1;
            
            while(stack2.size() != 0 && stack2.peek().element >= curr){
                count += stack2.peek().numMin;
                stack2.pop();
            }
            stack2.push(new Pair(curr,count));
            right[i] = count;
            
            
        }
        long ans =0;
        for(int i=0;i<arr.length;i++)
            ans= (ans+left[i]*right[i]*(long)arr[i])%m;
        
        return (int)ans;
        
    }
    
    class Pair{
        
        int element;
        int numMin;
        
        Pair(int ele, int num)
        {
            element = ele;
            numMin = num;
        }
    }
}
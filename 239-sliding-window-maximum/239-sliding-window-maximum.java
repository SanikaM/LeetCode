class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int start = 0;
        int end = k-1;
        int result = 0;
        
        Deque<Integer> deq = new LinkedList<Integer>();
        
        int[] r = new int[nums.length-k+1]; 
        int c = 0;
        for(int i =0;i<nums.length;i++) {
            
            
            while(!deq.isEmpty() && nums[i] > deq.getLast())
            {     
                deq.pollLast();
            }
            deq.addLast(nums[i]);
            
            if(i-start+1 < k)
                continue;
            else {
               
                r[c++] = deq.peekFirst();
                
                if(nums[start] == deq.getFirst())
                    deq.pollFirst();
                
                start++;
            }
        }
        
        return r;
    }
}


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<asteroids.length) {
            
            if(asteroids[i]>0)
                stack.push(asteroids[i]);
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroids[i]) > stack.peek())
                    stack.pop();
                
                if(stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroids[i]);
                else if(Math.abs(asteroids[i]) == stack.peek())
                    stack.pop();
            }
            i++;
        }
        
        int[] remaining = new int[stack.size()];
        for(int j = stack.size()-1 ; j>=0; j--) {
            remaining[j] = stack.pop();
        }
        
        return remaining;
    }
}
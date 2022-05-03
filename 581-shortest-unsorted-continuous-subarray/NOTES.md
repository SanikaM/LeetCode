class Solution {
public int findUnsortedSubarray(int[] nums) {
Stack<Integer> stack = new Stack<Integer>();
int popIndex = Integer.MAX_VALUE;
List<Integer> lst = new ArrayList<Integer>();
int c =0;
Map<Integer, Integer> map = new HashMap<>();
for(int i =0;i<nums.length;i++) {
map.put(nums[i], i);
}
stack.add(nums[0]);
for(int i=1;i<nums.length;i++) {
if(!stack.isEmpty() && stack.peek() <= nums[i])
{
stack.add(nums[i]);
}
if(!stack.isEmpty() && stack.peek() > nums[i])
{
int popVal = stack.peek();
popIndex = Math.min(popIndex, map.get(popVal));
int tempIndex = popIndex;
System.out.println("pop index ="+popIndex);
while(c < i-tempIndex) {
stack.pop();
tempIndex++;
c++;
}
stack.add(nums[i]);
c=0;
// popIndex = Integer.MAX_VALUE;
}
}
System.out.print("nums ="+nums.length);
System.out.print("stack ="+stack);
return nums.length - stack.size();
}
}
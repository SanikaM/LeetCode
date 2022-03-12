First try - Did not consider the case where first digit can be same but the greater number is to be considered.
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->
Integer.parseInt(Integer.toString(b).substring(0,1)) -
Integer.parseInt(Integer.toString(a).substring(0,1)));
​
for(int n : nums)
pq.add(n);
​
StringBuilder sb = new StringBuilder();
while(!pq.isEmpty())
sb.append(Integer.toString(pq.poll()));
​
return sb.toString();
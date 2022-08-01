/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        List<Interval> result = new ArrayList<>();
        
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.start-b.start);
        
        for(List<Interval> intervals : schedule) {
            for(Interval interval : intervals) {
                pq.add(interval);
            }
        }
        
        Interval pre = pq.poll();
        
        while(!pq.isEmpty()) {
            
         Interval curr = pq.poll();
        
            if(pre.end < curr.start )
                result.add(new Interval(pre.end, curr.start));
            else 
            {
                curr.start = Math.min(curr.start, pre.start);
                curr.end = Math.max(curr.end, pre.end);
            }
            pre = curr;
        }
        return result;
    }
}
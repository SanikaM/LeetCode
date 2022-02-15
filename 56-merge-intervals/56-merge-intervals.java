class Solution {
    public int[][] merge(int[][] intervals) {
        
    if(intervals.length == 0)
        return intervals;
    Arrays.sort(intervals, (arr1,arr2) -> arr1[0]-arr2[0]);  
    List<int[]> resultList = new ArrayList<>();
    int[] curr_interval = intervals[0];
    resultList.add(curr_interval);
        
    for(int[] interval : intervals) {
        
        int curr_beg = curr_interval[0];
        int curr_end = curr_interval[1];
        int next_beg = interval[0];
        int next_end = interval[1];
        
        if(curr_end >= next_beg) {
            curr_interval[1] = Math.max(curr_end, next_end);
            
        }
        else {
            curr_interval = interval;
            resultList.add(curr_interval);
        }
    }
        
    return resultList.toArray(new int[resultList.size()][]);
    }
}
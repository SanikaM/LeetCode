class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<pid.size();i++){
           
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        
        List<Integer> result = new ArrayList<>();
        dfs(pid,ppid, kill, map, result);
        return result;
    }
    
    private void dfs(List<Integer> pid, List<Integer> ppid, int kill, Map<Integer, List<Integer>> map, List<Integer> result) {
        
        result.add(kill);
        
        if(!map.containsKey(kill)) return;
        
        for(Integer child : map.get(kill)){
            dfs(pid, ppid, child, map, result);
        }
    }
}
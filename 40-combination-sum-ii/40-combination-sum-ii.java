class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        
        return new ArrayList(result);
    }
    
    private void helper(int[] candidates, int start, int target, List<Integer> curr, Set<List<Integer>> result) {
        
        
        if(target < 0)
            return;
        
        if(target == 0){
            result.add(new ArrayList(curr));
            return;
        }
        int prev = -1;
        for(int i=start;i<candidates.length;i++) {            
            
            if(candidates[i] == prev)
                continue;
            curr.add(candidates[i]);
            helper(candidates, i+1, target - candidates[i], curr, result);
            curr.remove(curr.size()-1);
                
            prev = candidates[i];
            
        }
    }
}
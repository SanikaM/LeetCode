class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        
        return result;
        
        
    }
    
    private void helper(int[] candidates, int start, int target, List<Integer> curr, List<List<Integer>> result) {
        
        if(target < 0 )
            return;
        
        if(target == 0)
            result.add(new ArrayList(curr));
        
        for(int i=start;i<candidates.length;i++) {
            
            curr.add(candidates[i]);
            helper(candidates, i, target - candidates[i], curr, result);
            curr.remove(curr.size() -1);
        }
        
        
    }
}
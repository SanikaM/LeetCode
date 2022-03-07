class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean[] freq = new boolean[nums.length];
        List<Integer> ds = new ArrayList<>();
        
        permuteRec(nums, ans, freq, ds);
        
        return ans;
        
    }
    
    private void permuteRec(int[] nums, List<List<Integer>> ans, boolean[] freq, List<Integer> ds) {
        
        if(ds.size() == nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0;i<nums.length;i++) {
            
            if(!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                permuteRec(nums, ans, freq, ds);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
}
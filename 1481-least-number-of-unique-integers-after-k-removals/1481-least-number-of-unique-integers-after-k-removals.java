class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        List<Integer> freq = new ArrayList<>();
        freq.addAll(map.values());
        Collections.sort(freq);
        System.out.println(freq);
        int counter = 0;
        int result =0;
        for(Integer i : freq ){
           if(i>=k && k>0)
           {
               i=i-k;
               k=0;
           }
            else if(i<k && k>0)
            {
                k=k-i;
                i=0;
                
            }
            counter++;
            if(i > 0)
                result++;
                
        }
        
       return result;
    }
}
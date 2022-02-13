class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
 
        Arrays.sort(boxTypes, (a,b)-> b[1]-a[1]);
        int maxUnits =0;
        
        for(int[] boxT : boxTypes){
            int boxCount = Math.min(truckSize, boxT[0]);
            maxUnits += boxCount * boxT[1];
            truckSize -= boxCount;
            
            if(truckSize ==0)
                break;
        }
        return maxUnits;
    }
}
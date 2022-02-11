class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
      Arrays.sort(points, (a,b) -> squaredDistance(a) - squaredDistance(b));
        
        return Arrays.copyOf(points, k);
    }
    
    public int squaredDistance(int[] point)
    {
        return point[0] * point[0] + point[1] * point[1];
    }
}
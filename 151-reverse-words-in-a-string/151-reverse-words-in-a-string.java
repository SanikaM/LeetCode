class Solution {
    public String reverseWords(String s) {
        
        s= s.trim();
        String[] arr = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=arr.length-1;i>=0;i--) {
            
            arr[i] = arr[i].trim();
            //System.out.println("#"+arr[i]+"#");
            if(arr[i] != null)
            sb.append(arr[i]);
            System.out.println("#"+sb+"#");
            if(i>0)
                sb.append(" ");
        }
        
        System.out.println(sb);
        
        return sb.toString();
    }
}
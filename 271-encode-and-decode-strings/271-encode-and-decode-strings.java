public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        StringBuffer buf = new StringBuffer();
        for(String str : strs)
        {
            buf.append(str.replace("#","##")).append(" # ");
        }
        
        return buf.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        List<String> result = new ArrayList<>();
        String arr[] = s.split(" # ",-1);
        for(int i=0;i<arr.length-1;++i)
        {
            result.add(arr[i].replace("##","#"));
        }
        
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
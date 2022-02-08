class Trie {

    // Also check deleting a word frrom trie, was asked in instabase
    private Node root;
    
    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a'] = new Node(c);
            }
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        
        Node curr = getNode(word);
        if(curr !=null && curr.isWord == true)
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = getNode(prefix);
        if(curr != null)
            return true;
        return false;
    }
    
    public Node getNode(String word){
        
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) return null;
            curr = curr.children[c-'a'];
        }
        return curr;
    }
    
    class Node {
        public char c;
        public Boolean isWord;
        public Node[] children;
        
        public Node(char c)
        {
            this.c = c;
            this.isWord = false;
            this.children = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
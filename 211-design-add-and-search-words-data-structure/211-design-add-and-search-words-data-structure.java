class WordDictionary {

    char c;
    Boolean isWord;
    WordDictionary[] children;
    WordDictionary root;

     public WordDictionary(char c){
        this.c = c;
        this.isWord = false;
        children = new WordDictionary[26];
    }
    public WordDictionary(){
        this.isWord = false;
        children = new WordDictionary[26];
    }
    
    public void addWord(String word) {
        
        WordDictionary curr = this;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) 
            {
               curr.children[c-'a'] = new WordDictionary(c); 
            }
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        
        WordDictionary curr = this;
          for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(c=='.'){
                for(WordDictionary node : curr.children){
                    if(node != null && node.search(word.substring(i+1))) return true;
                    
                }
                return false;
            }
            else{
                
                if(curr.children[c-'a']==null) { 
                return false;
                }
                else
                    curr = curr.children[c-'a'];
                }
             
        }
         return curr != null && curr.isWord;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
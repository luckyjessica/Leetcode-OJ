package medium;


public class _Trie {
	class TrieNode {
	    boolean isLeaf;
	    TrieNode[] children;
	    
	   // Initialize your data structure here.
	   public TrieNode() {
	       isLeaf = false;
	       children = new TrieNode[26];
	   }
	}
   private TrieNode root;

   public _Trie() {
       root = new TrieNode();
   }

   // Inserts a word into the trie.
   public void insert(String word) {
       TrieNode curr = root;
       for(int m = 0; m < word.length() ; m++){
           char i = word.charAt(m);
           if(curr.children[i-'a']==null){
               curr.children[i-'a'] = new TrieNode();
           }
           curr = curr.children[i-'a'];
       }
       curr.isLeaf = true;
   }

   // Returns if the word is in the trie.
   public boolean search(String word) {
       TrieNode curr = root;
       for(int m = 0; m < word.length() ; m++){
           char i = word.charAt(m);
           if(curr.children[i-'a']==null) return false;
           //不要忘了往下移！
           curr = curr.children[i-'a'];
       }
       return curr.isLeaf;
   }

   // Returns if there is any word in the trie
   // that starts with the given prefix.
   public boolean startsWith(String prefix) {
       TrieNode curr = root;
       for(int m = 0; m < prefix.length() ; m++){
           char i = prefix.charAt(m);
           if(curr.children[i-'a']==null) return false;
           curr = curr.children[i-'a'];
       }
       return true;
   }
   
   
}


//Your Trie object will be instantiated and called as such:
//Trie trie = new Trie();
//trie.insert("somestring");
//trie.search("key");
package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class TrieNode{
    private Map<Character,TrieNode> children;
    boolean isLeaf;
    TrieNode(){
        children = new HashMap<Character,TrieNode>();
        isLeaf = false;
    }
    TrieNode addChar(Character letter){
        if (!children.containsKey(letter)) {
            children.put(letter, new TrieNode());
        }
        return children.get(letter);
    }
    TrieNode getOne(Character letter){
         return children.get(letter);
    }
    List<TrieNode> getAll(){
    	//去当前所有的value，除null外
        return new ArrayList<TrieNode>(children.values());
    }
}

public class _AddandSearchWord {
    TrieNode root;
    public _AddandSearchWord(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i<word.length(); i++){
            curr = curr.addChar(word.charAt(i));
        }
        curr.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(root,word,0);
    }
    public boolean helper(TrieNode root, String word, int index){
        if(index==word.length()) return root.isLeaf;
        if(word.charAt(index)=='.'){
            for(TrieNode i : root.getAll()){
                if(helper(i,word,index+1)) return true;
            }
        }else{
            char a = word.charAt(index);
            if(root.getOne(a)!=null) return helper(root.getOne(a),word,index+1);
        }
        return false;
    }
    
    
    public static void main(String[] args){
    	//Your WordDictionary object will be instantiated and called as such:
    	_AddandSearchWord wordDictionary = new _AddandSearchWord();
    	wordDictionary.addWord("a");
    	wordDictionary.addWord("ab");
    	System.out.println(wordDictionary.search("a"));
    	System.out.println(wordDictionary.search("a."));
    	System.out.println(wordDictionary.search("ab"));
    	System.out.println(wordDictionary.search(".a"));
    	System.out.println(wordDictionary.search(".b"));
    	System.out.println(wordDictionary.search("ab."));
    	System.out.println(wordDictionary.search("."));
    	System.out.println(wordDictionary.search(".."));
 
    }
}

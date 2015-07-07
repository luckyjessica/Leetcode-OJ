package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Your WordDictionary object will be instantiated and called as such:
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("word");
//wordDictionary.search("pattern");


class TrieNode {
	// Initialize your data structure here.
	private Map<Character, TrieNode> children;
    private boolean isWord;
 
    public TrieNode() {
        this.children = new HashMap<>();
    }
    
    TrieNode addLetter(Character letter) {
        if (!children.containsKey(letter)) {
            children.put(letter, new TrieNode());
        }
        return children.get(letter);
    }
    
    TrieNode getChild(Character letter) {
        return children.get(letter);
    }
    
    void setIsWord() {
        isWord = true;
    }
    
    boolean isWord() {
        return isWord;
    }
    
    List<TrieNode> getAllChildren() {
        return new ArrayList<TrieNode>(children.values());
    }
} 

public class _AddandSearchWord {
	private TrieNode root;
	// constructor
    public _AddandSearchWord(){
    	this.root = new TrieNode();
    }          
    
    // Adds a word into the data structure.
    public void addWord(String word) {
    	TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            currentNode = currentNode.addLetter(word.charAt(i));
        }
        currentNode.setIsWord();
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return search(word, 0, root);
    }
    
    private boolean search(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord();
        }
        if ('.' == word.charAt(index)) {
            for (TrieNode child : node.getAllChildren()) {
                if (search(word, index + 1, child)) {
                    return true;
                }
            }
        } else {
            TrieNode child = node.getChild(word.charAt(index));
            if (child != null) {
                return search(word, index + 1, child);
            }
        }
        return false;
    }
}

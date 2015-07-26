package medium;
/**Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
**/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
    	if(word.length()==0 || board.length==0) return false;
    	for(int i = 0 ; i < word.length() ; i++){
    		for(int m = 0 ; m<board[0].length ; m++){
    			int n = 0;
    			if(word.charAt(i==board[m][n]))
    		}
    	}
    }
}

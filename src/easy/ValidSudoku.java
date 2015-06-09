package easy;

/**
 * The Sudoku board could be partially filled
 * where empty cells are filled with the character '.'.
 * @author JieXu
 *
 */
public class ValidSudoku {
	//只有暴力解法
	
	public static boolean isValidSudoku(char[][] board) {

		boolean[] map = new boolean[9];
		//记得 CHAR 转 INT 啊！！！！
		for(int i = 0 ; i<9 ; i++){	
			map = new boolean[9];
			for(int j = 0 ; j<9 ; j++){
				if(board[i][j]!='.'){
					if(map[(int)board[i][j]-49]) return false;
					else map[(int)board[i][j]-49]=true;
				}
			}
		}	
		for(int i = 0 ; i<9 ; i++){	
			map = new boolean[9];
			for(int j = 0 ; j<9 ; j++){
				if(board[j][i]!='.'){
					if(map[(int)board[j][i]-49]) return false;
					else map[(int)board[j][i]-49]=true;
				}
			}
		}		
		for(int i = 0 ; i< 3 ; i++){	
			for(int j = 0 ; j< 3 ; j++){
				map = new boolean[9];
				for(int m = i*3; m < i*3 + 3 ; m++){
					for( int n = j *3 ; n < j*3 + 3 ; n++){
						if(board[m][n]!='.'){
							if(map[(int)board[m][n] - 49]) return false;
							else map[(int)board[m][n] - 49]=true;
						}	
					}					
				}
			}
		}
		return true;
	}
}

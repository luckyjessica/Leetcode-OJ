package medium;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author JieXu
 *
 */
public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens){
		if(tokens.length==0) return 0;
		Stack<String> notation = new Stack<String>();
		for(int i = 0 ; i<tokens.length ;i++){
            if(tokens[i].equals("+")){  
                notation.push(String.valueOf(Integer.parseInt(notation.pop()) + Integer.parseInt(notation.pop())));  
            }
            else if(tokens[i].equals("-")){  
                int a = Integer.parseInt(notation.pop());  
                int b = Integer.parseInt(notation.pop());  
                notation.push(String.valueOf(b-a));  
            }
            else if(tokens[i].equals("*")){  
            	notation.push(String.valueOf(Integer.parseInt(notation.pop()) * Integer.parseInt(notation.pop())));  
            }
            else if(tokens[i].equals("/")){  
                int a = Integer.parseInt(notation.pop());  
                int b = Integer.parseInt(notation.pop());  
                notation.push(String.valueOf(b/a));  
            }else{  
                notation.push(tokens[i]);  
            }  
        }  
          
        return Integer.parseInt(notation.pop());  
	}
	public static void main(String[] arg){
		String[] tokens = {"3", "-4","-"};
		System.out.println(evalRPN(tokens));
	}
}

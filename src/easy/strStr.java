package easy;

import java.util.LinkedList;

public class strStr {
	public static int isContain(String haystack, String needle) {
		if(needle.length()>haystack.length()) return -1;
		if(needle.equals(haystack)) return 0;
		LinkedList<Character> queue = new LinkedList<Character>();
		for(int i = 0 ; i<needle.length() ; i++){
			queue.add(needle.charAt(i));
		}	
		LinkedList<Character> tmpqueue;
		tmpqueue = new LinkedList<Character>(queue);
		int index = 0;
		int shift = 0;
		while(!tmpqueue.isEmpty() && (index+shift)< haystack.length()){
			char tmp = tmpqueue.peek();
			if(haystack.charAt(index+shift) == tmp){
				shift++;
				tmpqueue.poll();
			}else{
				tmpqueue = new LinkedList<Character>(queue);
				index++;
				shift=0;
			}
		}
		if(tmpqueue.isEmpty()) return index;
		return -1;
	}
	public static void main(String arg[]){
		String s1 = "babba";
		String s2 = "bbb";
		System.out.println(isContain(s1,s2));
	}
}
 
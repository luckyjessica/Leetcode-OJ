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
	 public static int strStr(String haystack, String needle) {
			if(needle.length()>haystack.length()) return -1;
			if(needle.equals(haystack)) return 0;
			for(int i=0,j=0; i+j<haystack.length()&&j<needle.length();){
			    if(haystack.charAt(i+j)!=needle.charAt(j)){
			        j=0;
			        i++;
			    }else{
			        if(j==needle.length()-1) return i;
			        j++;
			    }
			}
			return -1;
			
	    }
	public static void main(String arg[]){
		String s1 = "aaa";
		String s2 = "aa";
		System.out.println(strStr(s1,s2));
	}
}
 
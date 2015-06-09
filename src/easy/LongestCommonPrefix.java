package easy;

public class LongestCommonPrefix {
	public static String method1(String[] strs) {
		if(strs.length==0) return "";
		if(strs.length==1) return strs[0];
		StringBuilder common = new StringBuilder();
		common.append(strs[0]);
		for(int i = 1 ; i < strs.length ; i++){
			while(!strs[i].startsWith(common.toString())){
				common.deleteCharAt(common.length()-1);
			}
		}
		return common.toString();
	}
	public static String method2(String[] strs){
		String res = "";
	    int i = 0;
	    try{
	        while(true){
	            char now = strs[0].charAt(i);
	            for(int j = 0; j<strs.length;j++){
	                if(strs[j].charAt(i) != now) return res;

	            }
	            res+=now;
	            i++;
	        }
	    }catch(Exception e){
	        return res;
	    }
	}
	
	public static void main(String arg[]){
		String[] strs = {"baab","bacb","b","bbc"};
		System.out.println(method1(strs));
	}
}

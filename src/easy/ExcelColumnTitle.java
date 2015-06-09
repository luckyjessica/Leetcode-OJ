package easy;

public class ExcelColumnTitle {
	public static String numbertotitle(int n){
		 if (n<1) return "error";
	        String res = "";
	        while(n != 0) {
	            res = (char)('A' + (n - 1) % 26) +res;
	            n = (n - 1) / 26;
	        }
	        return res;
	}
	public static void main(String arg[]){
		System.out.println(numbertotitle(28));
	}
}

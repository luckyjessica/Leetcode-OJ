package easy;

public class CompareVersion {
	public static int compare(String version1, String version2){
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int length = (v1.length >= v2.length ? v2.length : v1.length);
		
		for (int i = 0; i < length; i++) {
	        if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[i])) return 1;
	        else if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i])) return -1;
	    }
	    if (v1.length > v2.length && Integer.valueOf(v1[length]) > 0) return 1;
	    else if (v1.length < v2.length && Integer.valueOf(v2[length]) > 0) return -1;
	    else return 0;
	}
	public static void main(String arg[]){
		System.out.println(compare("1","0"));
	}
}

package easy;

public class CountAndSay {
	//Given an integer n, generate the nth sequence
	// take care of the boundary situation, when n = 1 or 2.
	
	public static int Count(int n){
		if(n<=0) return 0;
		if(n==1) return 1;
		String curr = "1";
		int cc=0;
		for(int i=2;i<=n;i++){
			StringBuilder s = new StringBuilder();
			int count = 1;
			// when n=2, the for loop will not executed
			for(int j=1;j< curr.length();j++){
				if(curr.charAt(j)==curr.charAt(j-1)) count++;
				else{
					s.append(count);
					s.append(curr.charAt(j-1));
					count = 1;
				}
				cc++;
			}
			s.append(count);
			s.append(curr.charAt(curr.length()-1));
			curr = s.toString();
		}
		return cc;
	}
	
	public static void main(String arg[]){
		System.out.println(Count(11));
	}
}


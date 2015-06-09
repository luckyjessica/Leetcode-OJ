package easy;

public class ReverseInteger {
	public static int reverse(int x) {
		try{
		StringBuilder after = new StringBuilder();
		int a = x < 0 ? -x : x;
		while(a > 0){
			after.append(a % 10);
			a /= 10;
		}
			int answer = Integer.parseInt(after.toString());
			if(x < 0) answer = - answer;
			return answer;
		}catch(Exception e){
			return 0;
		}
	}
	public static void main(String arg[]){
		System.out.println(reverse(1000000003));
	}
}

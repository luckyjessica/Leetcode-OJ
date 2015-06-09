package easy;

public class CountPrimes {
	//Sieve of Eratosthenes
	// Space O(n)
	// Time ?
	public static int Count(int n){
		if(n<=2) return 0;
		int curr = 3;
		int count = 1;
		boolean flag[] = new boolean[n];
		//only consider odd number as a potential prime
		for(int i=3;i<n;i+=2){
			flag[i]=true;
		}
		while(curr*curr <=n){
			//restart the loop from newprime*newprime as anything
			//before it has already been set to false
			for(int i=curr*curr,j=0; (i+j*curr)<n; j++){
				flag[i+j*curr]=false;
			}
			for(int i = curr+1 ; i<n; i++){
				if(flag[i]==true){
					curr = i;
					break;
				}
			}
		}
		for(int i=1;i<n;i++){
			if(flag[i])count++;
		}
		return count;
	}

	public static void main(String arg[]){
		System.out.println(Count(10));
	}
}

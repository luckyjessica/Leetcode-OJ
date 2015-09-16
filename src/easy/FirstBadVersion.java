package easy;
/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * @author JieXu
 *
 */
//binary search time o(logn) 
public class FirstBadVersion {
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public int firstBadVersion(int n) {
      int low = 1;
      int high = n;
      while(low<high){
      //This expression int temp = (begining + end) / 2
      //should be rewritten as int temp = beginning + (end - beginning)/2
      //because when n is very large, (begining + end) may overflow, unexpected result may happen.
          int mid = low + (high-low)/2;
          if(isBadVersion(mid)){
              high = mid;
          }else low = mid+1;
      }
      return low;
  }

	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}
}

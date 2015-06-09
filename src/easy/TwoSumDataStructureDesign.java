package easy;

import java.util.HashMap;
import java.util.HashSet;

class TwoSumDataStructureDesign {
	/**
	 * This method looks good
	 * but how about the repeat value? 重复数字? like find(10)?
	HashSet<Integer> s = new HashSet<Integer>();
	public void add(int n){
		s.add(n);
	}
	public boolean find(int n){
		for(int i : s){
		   if(s.contains(n-i))return true;
			}
		}
		return false;
	}	
	**/
	HashMap<Integer,Integer> s = new HashMap<Integer,Integer>();
	public void add(int n){
		if(s.containsKey(n)) s.put(n, s.get(n)+1);
		else s.put(n,1);
	}
	public boolean find(int n){
		for(int i : s.keySet()){
			if((n-i)!=i && s.containsKey(n-i)) return true;
			else if((n-i)==i) return s.get(i)>1;
		}
		return false;
	}
	
	public static void main(String arg[]){
	TwoSumDataStructureDesign a = new TwoSumDataStructureDesign();
	a.add(3);
	a.add(1);	
	a.add(5);
	a.add(5);
	System.out.println(a.find(10));
	}
}


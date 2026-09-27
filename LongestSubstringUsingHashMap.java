import java.util.*;
class Solution{	
	public static int longestSubtring(String s){
	    
	    int longest = Integer.MIN_VALUE;

	    int l = 0;
	    Map<Character,Integer> map = new HashMap<>();
	   L
	    for(int r = 0; r < s.length(); r++){
		// advance r so long as it is unique
		char c = s.charAt(r);
		
		if(map.containsKey(c)){
			l = Math.max(l,map.get(c)+1);
		}

		map.put(c,r);
		// calculate the longest
		longest = Math.max(longest,r-l+1);
	    }

	    return longest == Integer.MIN_VALUE ? 0 : longest;
	}

	public static void main(String[] args){
	  String s = "xyzxyzt";
	  System.out.println(longestSubtring(s));

	}



}

class Solution{

  public static int longestSubstringWithoutRepeatingCharacters(String s){
	int l = 0;
	int[]window = new int[128];
	int longest = Integer.MIN_VALUE;

	for(int r = 0; r < s.length(); r++){
	
	   // Add char at r
	   int c = s.charAt(r);
	   window[c]++;

	   // while invalid l++
	   while(window[c]>1){
	       int d = s.charAt(l);
	       window[d]--;
	       l++;
	   }

	   // Calculate longest
	   longest = Math.max(longest,r-l+1);

	}
	return longest == Integer.MIN_VALUE ? 0: longest;
  }

  public static void main(String[] args){
	String s = "xxxxxxxxxxyz";
	System.out.println(longestSubstringWithoutRepeatingCharacters(s));
  }




}

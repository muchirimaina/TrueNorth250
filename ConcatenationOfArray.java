import java.util.*;
class Solution{
	public static String concatenationOfArray(int[] nums){
	    int n = nums.length;
	    int[] ans = new int[n*2];

	    for(int i = 0; i < nums.length; i++){
		
		ans[i] = nums[i];
		ans[i+n] = nums[i];
	
	    }

	    return Arrays.toString(ans);


	}

	public static void main(String[] args){
	  int[] nums = {1,2,3,5};
	  System.out.println(concatenationOfArray(nums));
	}
}

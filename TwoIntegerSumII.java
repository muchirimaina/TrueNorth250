import java.util.*;

class Solution{

	public static int[] twoSumII(int[] nums, int target){


	    int l = 0;
	    int r = nums.length-1;

	    while(l < r){
		int sum = nums[l]+nums[r];

		if(sum > target){
		   r--;
		}else if(sum < target){
		   l++;
		}else{
		   return new int[]{l+1,r+1};
		}


	    }

	    return new int[]{};
	}

	public static void main(String[] args){
	  int[] nums = {4,5,9,11,13};
	  int target = 16;

	  System.out.println(Arrays.toString(twoSumII(nums,target)));
	

	}














}

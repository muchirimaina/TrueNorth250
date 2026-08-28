import java.util.*;
class Solution{

	public static void rotateArray(int[] nums, int k){
	   int n = nums.length;

	   reverse(nums,0,n-1);
	   reverse(nums,0,k-1);
	   reverse(nums,k,n-1);
	}
	
	public static void reverse(int[] nums, int start, int end){
		int l = start;
		int r = end;

		while(l < r){
		   int temp = nums[l];
		   nums[l] = nums[r];
		   nums[r] = temp;

		   l++;
		   r--;
		}

	} 

	public static void main(String[] args){
	   int[] nums = {1,2,3,4,5,6,7};

	   rotateArray(nums,3);

	   System.out.println(Arrays.toString(nums));
	}
}

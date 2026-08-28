import java.util.*;

class Solution{
	public static int firstMissingPositive(int[]nums){
		
		// number x, index= x-1
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0){
			  while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){

				int correctIndex = nums[i]-1;

				int temp = nums[correctIndex];
				nums[correctIndex] = nums[i];
				nums[i] = temp; 

			}
			}	
		
		}


		for(int j = 0; j < nums.length; j++){
			if(nums[j] != j+1) return j+1;

		}

		return nums.length+1;

		                             

	}


	public static void main(String[] args){
		int[] nums = {-1,2,1,4,5};

		System.out.println(firstMissingPositive(nums));
	}




}

class Solution{

	public static int removeDups(int[] nums){

	   int index = 1;
	   
	   for(int i = 1; i < nums.length;i++){
		if(nums[i] !=  nums[i-1]){
		   nums[index++] = nums[i];
		 }
	   }

	   return index;

	}

	public static void main(String[] args){

	  int[] nums = {1,1,1,2,2,3,3,4};

	  System.out.println(removeDups(nums));


	}

}

import java.util.Arrays;
class Solution{

	public static int removeVal(int[] nums, int val){
	    
	   int k = 0;
	   for(int p = 0;p < nums.length; p++){
		if(nums[p] != val){
		   nums[k++] = nums[p];
		}
	   }
	   
	    return k;
	}

	public static void main(String[] args){
	  int[] nums = {2,2,2,2,3,1};
	  int val = 2;
	  removeVal(nums,val);
	  System.out.println(Arrays.toString(nums));
	}

}

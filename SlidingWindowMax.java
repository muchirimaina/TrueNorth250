import java.util.*;

class Solution{

	public static String slidingWindowMax(int[] nums, int k){
		
		Deque<Integer> q = new ArrayDeque<>();

		// Understand why it's n-k+1 why this? expecially +1?
		//For an array of n elements, the number of fixed-size windows of size k is n - k + 1.
		//The +1 exists because the first window starts at index 0

		int[] result = new int[nums.length-k+1];

		int l = 0;
		int index = 0;
		for(int r = 0; r < nums.length; r++){
		   while(!q.isEmpty() && nums[r] > nums[q.peekLast()]){
			q.removeLast();
		   }

		   // expand r
		   q.add(r);

		   while(r-l+1 > k){
		      // remove expired indices
		      if(q.peekFirst() == l){
			 q.removeFirst();
		      }
		      l++;
		   } 

		   if(r-l+1 == k){
		     result[index] = nums[q.peekFirst()];
		     index++;
		   }

		}

		return Arrays.toString(result);

	}

	public static void main(String[] args){
      		int[] nums = {1,2,1,0,4,2,6};
		int k = 3;

		System.out.println(slidingWindowMax(nums,k));		
	}




}

import java.util.*;
class Solution{
	// 3 Sum
	// Choose one num and the rest two use two pointers

	public static List<List<Integer>> returnValidPairs(int[] nums,int target){
		Arrays.sort(nums);
	 	return kSum(nums,target,3,0);
	}

	public static List<List<Integer>> kSum(int[] nums, int target, int k, int start){
		int n = nums.length;

		List<List<Integer>> results = new ArrayList<>();

		if(k == 2){
		   // two pointers
		   int l = start;
		   int r = n-1;

		   while(l < r){
			long sum = (long) nums[l]+nums[r];

			if(sum > target){
			   r--;
			}else if(sum < target){
			   l++;			
			}else{
				List<Integer> pairs = new ArrayList<>();
				pairs.add(nums[l]);
				pairs.add(nums[r]);

				results.add(pairs);

				l++;
				r--;

				while(l < r && nums[l] == nums[l-1]){
					l++;
				}

				while(l < r && nums[r] == nums[r+1]){
					r--;
				}

			}
		   }
		   return results;
		}


		for(int i = start; i < n-k+1; i++){
		   if(i >= start+1  && nums[i] == nums[i-1]) continue;
		   if(n-start < k){
		      return results;
		   }
		   long  minSum = 0;
		   for(int j = 0; j < k; j++){
		      minSum += nums[j+start];
		   }
		   if(minSum > target){
		      	return results;
		   }
		   long maxSum = 0;
		   for(int h = 0; h < k; h++){
			maxSum += nums[n-1-h];
		   }
                   if(maxSum < target){
		       return results;
		   } 
		   List<List<Integer>> subLists = kSum(nums,target-nums[i],k-1,i+1);
		
		   for(List<Integer> subList: subLists){
			subList.add(0,nums[i]);
			results.add(subList);
		   }
		}

		return results;
	
	}

	public static void main(String[] args){
		int[] nums = {-1,0,1,2,-1,-4};
		int target = 0;

		List<List<Integer>> finals = returnValidPairs(nums,target);

		System.out.println("Results :"+ finals);
	}

}

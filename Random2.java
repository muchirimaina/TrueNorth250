import java.util.*;
class Solution{
  public static List<Integer> majorityElementII(int[]nums){
	int candiOne = 0;
	int candiTwo = 0;
	int countOne = 0;
	int countTwo = 0;
        

	for(int i = 0; i < nums.length; i++){
	    if(nums[i] == candiOne){
		countOne++;;
	    }else if(nums[i] == candiTwo){
		candiTwo++;
	    }else if(countOne == 0){
		candiOne = nums[i];
	    }else if(countTwo == 0){
		candiTwo = nums[i];
	    }else{
		countOne--;
		countTwo--;
	    }
	}
	countOne = 0;
	countTwo = 0;

	for(int num: nums){
	    if(candiOne == num){
		countOne++;	
	     }
	     if(candiTwo == num){
		countTwo++;
	     }
	}
	int thresh = nums.length/3;
	List<Integer> result  = new ArrayList<>();;

	if(countOne > thresh){
	   result.add(candiOne);
	}
	if(countTwo > thresh){
	   result.add(candiTwo);
	}
	return result;
  }


   public static void main(String[] args){
      int[] nums = {5,2,3,2,2,2,2,5,5,5};

      System.out.println(majorityElementII(nums));

   }
}

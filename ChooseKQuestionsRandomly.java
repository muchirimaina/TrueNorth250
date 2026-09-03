// Given an integer n, an integer array nums, and an integer k, create a pool containing
// all integers from 1 to n and all elements of nums. Return k randomly selected elements
// from the pool without replacement, where every element has an equal probability of being selected.

// Constraints:

// 1 <= n
// 1 <= k <= n + nums.length
// Every value in nums is greater than n.
// nums contains no duplicates.

// Example:

// n = 5
// nums = [20, 30, 40]
// k = 3

// Pool = [1, 2, 3, 4, 5, 20, 30, 40]

// Possible output:
// [20, 4, 2]






import java.util.*;
class Solution{

    // There is bug when the range is small i.e 2, I can see 3 which shouldn't be part of the returned

    // Research on the num.length what does it mean, what does int[] exap = new int[n i.e 3]; the 3 means?
    static int totalLen;
    public static String returnKNumsAtRandom(int range, int[] nums, int k){
        
        int n = nums.length;
        totalLen = range+n;
        int[] totalNums = new int[totalLen];

        int[] result = new int[k];
        
        int v = 0;
        int indexNums = 0;
        for(int i = 0; i < totalLen; i++){
            if(i < range){
                totalNums[v++] = i+1;
            }else{
                totalNums[v++] = nums[indexNums++];
            }
        }
	Random rand = new Random();
        // Find random unique k nums from the totalNums using Fisher Yates
	for(int f = 0; f < k ; f++){
	   int j = f + rand.nextInt(totalLen-f);
	   int temp = totalNums[j];
	   totalNums[j] = totalNums[f];
	   totalNums[f] = temp;
		
	}
	
	for(int p = 0; p < k; p++){
	   result[p] = totalNums[p];
	}
        return Arrays.toString(result);
    }

    public static int questionRem(){
        return 250-totalLen;
    }

    public static void main(String[] args){
        int range = 50;
        int[] nums = {234};
        int k = 3;
        System.out.println("");
        System.out.println("**********************************************************");
        System.out.print("You randomly selected Q(s):");
        System.out.println(returnKNumsAtRandom(range,nums,k));
        System.out.println("Godspeed... Kudos in your 250 Q's roadmap! Almost there :)");
        System.out.println(questionRem()+" questions remaining.");
        System.out.println("**********************************************************");
        System.out.println("");

    }
    
}

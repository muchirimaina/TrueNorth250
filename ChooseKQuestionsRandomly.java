// Given three inputs, an int n that means a range number from 1 to n. The other an array of nums. You should return
// k numbers which will be picked randomly from the range and the array with equal probability. 

// Expected TC is O(n) and SC is O(n).

// Example: int n = 30, int[] nums = {65,200,250}, int k;
// Ans [2,65] Example for k = 2



// What am thinking -> create an ArrayList, add the nums from 1 to n, then add those in nums
// Then use Math Random to fill an array and return it
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
        int range = 35;
        int[] nums = {40,234};
        int k = 2;
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

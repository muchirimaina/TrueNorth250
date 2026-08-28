import java.util.*;

class Solution{
    public static int longestConsecutiveSeq(int[] nums){
	if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();


        for(int num:nums ){
            set.add(num);
        }

        int longest = 1;
        for(int num: set){
            if(!set.contains(num-1)){
                int count = 1;
                int current = num;

                while(set.contains(current+1)){
                    count++;
                    current++;
                }

                longest = Math.max(longest,count);


            }
        }
        return longest;
    }

    public static void main(String[] args){
        int[] arr = {0,3,2,5,4,6,1,1}; //7

        System.out.println(longestConsecutiveSeq(arr));
    }
}

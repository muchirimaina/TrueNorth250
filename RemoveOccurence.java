import java.util.*;
class Solution{
    public static String removeOcc(int[] nums, int val){

        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
        }

        return Arrays.toString(nums);

    }

    public static void main(String[] args){
        int[] nums = {1,2,6,7,2,2,8,9};
        int val = 2;

        System.out.println(removeOcc(nums,val));
    }
}
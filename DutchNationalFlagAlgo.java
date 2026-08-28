import java.util.*;
class Solution{

    public static String countSort(int[] nums){
        int[] count = new int[3];

        for(int num: nums){
            count[num]++;
        }

        int k = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                nums[k++] = i;
                count[i]--;
            }
        }

        return Arrays.toString(nums);
    }
    public static String dutchFlagAlgo(int[] nums){

        int l = 0;
        int i = 0;
        int r = nums.length-1;
        
	// You need to process colors[i] even when i == r, because that element is still part of the unknown region.
        while(i <= r){

            if(nums[i] == 0){
                swap(nums,i,l);
                l++;
                i++;
            }else if(nums[i] == 2){
                swap(nums,i,r);
                r--;
            }else{
                i++;
            }
        }

        return Arrays.toString(nums);

    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,2,2,0,0,1,1};

        System.out.println(dutchFlagAlgo(nums));
    }
}

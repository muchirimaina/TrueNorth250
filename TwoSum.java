import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution{
    public static String twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return Arrays.toString(new int[]{map.get(complement),i});
            }

            map.put(nums[i],i);
        }

        return Arrays.toString(new int[]{});
    }

    
    public static void main(String[] args){
        int[] nums = {3,4,5,6};
        int target = 7;
        System.out.println(twoSum(nums,target));
    }
}
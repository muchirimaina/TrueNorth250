import java.util.ArrayList;
import java.util.List;
class Solution{
    public static List<Integer> majorityElementII(int[] nums){
        List<Integer> result = new ArrayList<>();

        int asp1 = 0;
        int asp2 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int num: nums){
            if(num == asp1){
                count1++;
            }else if( num == asp2){
                count2++;
            }else if(count1 == 0){
                asp1 = num;
                count1++;
            }else if(count2 == 0){
                asp2 = num;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num: nums){
            if(num == asp1) count1++;
            if(num == asp2) count2++;
        }

        int thresh = nums.length/3;

        if(count1 > thresh){
            result.add(asp1);
        }
        if(count2 > thresh){
            result.add(asp2);
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {5,2,3,2,2,2,2,5,5,5};

        System.out.println(majorityElementII(nums));
    }
}
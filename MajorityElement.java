class Solution{
    public static int majorityElement(int[] nums){
        int candidate = nums[0];
        int count = 0;

        for(int num:nums){
            if(num == candidate){
                count++;
            }else if(num != candidate){
                count--;
                if(count == 0){
                    candidate = num;
                    count = 1;
                }
            }
        }

        count = 0;
        for(int num: nums){
            if(num == candidate){
                count++;
            }
        }


        return count > nums.length/2 ? candidate: -1;

    }

    public static void main(String[] args){
        int[] nums = {3,5,7,6,3};

        System.out.println(majorityElement(nums));
    }
}
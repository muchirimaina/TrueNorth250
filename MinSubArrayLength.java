class Solution{
    public static int minSizeSubArray(int[] nums, int target){

        int l = 0;
        int subArrayMinSize = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int r = 0; r < nums.length; r++){
            sum += nums[r];

            while(sum >= target){
                subArrayMinSize = Math.min(subArrayMinSize,r-l+1);
                sum -= nums[l++];
            }
        }
        return subArrayMinSize == Integer.MAX_VALUE ? 0 : subArrayMinSize;
    }

    public static void main(String[] args){
        int[] nums = {1,2,1};
        int target = 5;
        System.out.println(minSizeSubArray(nums,target));
    }
}
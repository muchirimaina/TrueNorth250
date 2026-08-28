class Solution{
    public static int removeDuplicatesInPlace(int[] nums){
        int k = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public static void main(String[] args){
        int[] nums = {1,1,1,1,1,2,2,3,3,3,5,5,7};
        System.out.println(removeDuplicatesInPlace(nums));
    }
}
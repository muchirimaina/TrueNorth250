class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        int[] prefixSum = new int[n+1];

        for(int i = 0; i < nums.length; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        int length = Integer.MAX_VALUE;

        for(int i = 0; i < prefixSum.length-1;i++){

            int l = i+1;
            int r = nums.length;
            

            while(l <= r){

                int mid = l + (r-l)/2;

                int currSum = prefixSum[mid]-prefixSum[i];

                if(currSum >= target){
                    r = mid - 1;

                    length = Math.min(length, mid-i);

                }else{
                    l = mid + 1;
                }

            }

        }

        return length == Integer.MAX_VALUE ? 0: length;

        
    }
}
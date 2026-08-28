class Consecutive{
    public static int consecutiveOnes(int[] nums){

        int l = 0;
        int r = 0;

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        while(r < n){
            while(r < n && nums[r] == 1){
                max = Math.max(max,r-l+1);
                r++;
            }
            l = r;
            while(l < n && nums[l] == 0){
                l++;
            }
            r = l;
        }

        // OR

        // for(r = 0; r < n; r++){

        //     if(nums[r] == 1){
        //         max = Math.max(max,r-l+1);
        //     }else{
        //         l = r;
        //         while(l < n && nums[l] == 0){
        //             l++;
        //         }
        //         r = l;
        //     }

        // }

        return max == Integer.MIN_VALUE ? 0: max;

    }

    public static void main(String[] args){
        int[] nums = {1,1,1,1,0,0,0,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,0,0,0};

        System.out.println(consecutiveOnes(nums));
    }
}
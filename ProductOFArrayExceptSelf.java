import java.util.*;
// class Solution{
//     public static String productOfArrayExceptSelf(int[] nums){
//         int n = nums.length;

//         int[] prefixP = new int[n];
//         prefixP[0] = 1;
//         int[] suffixP = new int[n];
//         suffixP[n-1] = 1;
//         int[] result = new int[n];

//         // prefixProduct
//         for(int i = 1; i < n; i++){
//             prefixP[i] = prefixP[i-1]*nums[i-1];
//         }
//         // suffixProduct
//         // for(int i = n-2; i >=0; i--){
//         //     suffixP[i] = suffixP[i+1]*nums[i+1];
//         // }
//         // Result prefix * suffix
//         int suffix = 1;
//         for(int i = n-1; i >= 0; i--){
//             prefixP[i] = prefixP[i]*suffix;
//             suffix = nums[i]*suffix;
//         }

//         return Arrays.toString(prefixP);
//     }

//     public static void main(String[] args){
//         int[] nums = {10,7,1,2};

//         System.out.println(productOfArrayExceptSelf(nums));
//     }
// }

class Solution{
    public static String productOfArrayExceptSelf(int[] nums){

        int n = nums.length;

        int[] result = new int[n];
        result[0] = 1;
        int suffix = 1;

        for(int i = 1; i < n; i++){
            result[i] = result[i-1]*nums[i-1];
        }

        for(int i = n-1; i >= 0; i--){
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return Arrays.toString(result);

    }

     public static void main(String[] args){
        int[] nums = {10,7,1,2};

        System.out.println(productOfArrayExceptSelf(nums));
    }
}
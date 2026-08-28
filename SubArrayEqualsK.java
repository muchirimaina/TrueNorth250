import java.util.HashMap;
import java.util.Map;


class Solution{
    // why not an array? i.e int[] prefixSum = new int[n] and just a variable?
    // --you're not interested in the entire sequence of prefix sums. You only need the current one, while the HashMap remembers the useful history.

    public static int countOfSubArrayEqualsK(int[] nums, int k){
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int prefixSum = 0;

        for(int i = 0; i < n; i++){
            prefixSum += nums[i];

            if(map.containsKey(prefixSum-k)){
                // map.get is enought only use map.getValue when looping a map
                count += map.get(prefixSum-k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }

        return count;

    }

     public static void main(String[] args){
        int[] arrNum = {2,-1,1,2};
        int k = 2;

        System.out.println(countOfSubArrayEqualsK(arrNum,k));
    }

}

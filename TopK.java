import java.util.*;

class TopK{
    public static String topK(int[] nums, int k){

        int[] result = new int[k];

        Map<Integer,Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];

        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            buckets[entry.getValue()].add(entry.getKey());
        }

        int index = 0;

        for(int i = buckets.length-1; i > 0; i--){
            if(!buckets[i].isEmpty()){
                for(int n: buckets[i]){
                    result[index++] = n;
                    if(index == k){
                        return Arrays.toString(result);
                    }   
                }
            }
            
        }

        return Arrays.toString(new int[]{});


    }

    public static void main(String[] args){
        int[] nums = {1,2,2,3,3,3};
        int k = 2;

        System.out.println(topK(nums,k));
    }
}
public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;

        for (int num : nums) {

            // map.put(num, left + right + 1);
            // map.put(num - left, length);
            // map.put(num + right, length);

            if (!map.containsKey(num)) {
                //update the current boundary
                map.put(num, map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0) + 1);
                //update left boundary
                map.put(num - map.getOrDefault(num - 1, 0), map.get(num));
                //update right boundary
                map.put(num + map.getOrDefault(num + 1, 0), map.get(num));

                longest = Math.max(longest, map.get(num));
            }
        }
        return longest;
    }
}
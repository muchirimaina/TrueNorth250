import java.util.*;


class Solution{
    public static List<List<String>> groupAnagrams(String[] strs){

        Map<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            
            int[]letters = new int[26];

            for(char c: str.toCharArray()){
                letters[c-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int n: letters){
                sb.append('#');
                sb.append(n);
            }

            String key = sb.toString();

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }

    
    public static void main(String[] args){
        String[] strs = {"act","pots","tops","cat","stop","hat"};

        System.out.println(groupAnagrams(strs));
    }
}
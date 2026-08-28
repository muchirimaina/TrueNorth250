class Solution{
    public static boolean isAnagram(String t, String v){

        if(t.length() != v.length()) return false;

        int[] letters = new int[26];

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            char b = v.charAt(i);

            letters[c-'a']++;
            letters[b-'a']--;
        }

        for(int n : letters){
            if(n > 0){
                return false;
            }
        }

        return true;


    }

    public static void main(String[] args){
        String t = "racecar";
        String v = "carrace";

        System.out.println(isAnagram(t,v));

    }
}
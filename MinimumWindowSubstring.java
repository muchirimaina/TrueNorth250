class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0) return "";
        int[] charInT = new int[128];

        for(char c: t.toCharArray()){
            charIntT[c]++;
        }

        int have = 0;
        int need = t.length();

        int[] window = new int[128];

        String ans = "";
        int minSizeSubstring = Integer.MAX_VALUE;


        int l = 0;
        for(int r = 0; r < s.length(); r++){
            // Add r
            char c = s.charAt(r);
            if(charInT[c]){
                window[c]++;
            }
            if(charInT[c] == window[c]) have++;

            // When have == need 
            while(have == need){
                String windowString = s.substring(l,r+1);
                int sizeWindow = (r-l)+1;
                if(sizeWindow < minSizeSubstring){
                    minSizeSubstrin = sizeWindow;
                    ans = windowString;
                }


                char d = s.charAt(l);
                if(charInT[d] == window[d]) have--;
                if(charInT[d]){
                    window[d]--;
                }
                
            }

            return minSizeSubstring == Integer.MAX_VALUE ? "" : ans;
        } 


        
    }
}

import java.util.List;
import java.util.ArrayList;

class Solution{
    public static String encode(String[] strs){

        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length());
            sb.append('#');
            sb.append(str); 
        }
        return sb.toString();
    }

    public static List<String> decode(String s){

        int l = 0;
        int r = 0;
        int n = s.length();

        List<String> result = new ArrayList<>();

        while(r < n){

            while(s.charAt(r) != '#'){
                r++;
            }
            int wordLen = Integer.parseInt(s.substring(l,r));
            r++;

            String word = s.substring(r,r+wordLen);
            result.add(word);
            r = r+wordLen;
            l = r;
        }

        return result;
    }

    public static void main(String[] args){
        String[] strs = {"Hello","World","Google"};

        System.out.println("........Encode.........");
        System.out.println(encode(strs));
        System.out.println("........Decode.........");
        System.out.println(decode(encode(strs)));
    }
}
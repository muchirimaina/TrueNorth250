import java.util.*;

class Solution{
  public static String encodeString(String[] strs){
      
      StringBuilder sb = new StringBuilder();

      for(String str:strs){
	  // 5#string
	  sb.append(str.length());
	  sb.append('#');
	  sb.append(str);
      } 

      return sb.toString();
  }

  public static List<String> decodeString(String s){

      List<String> result = new ArrayList<>();
	
      int l = 0;
      int r = 0;
      while(r < s.length()){
	char c = s.charAt(r); //-- why does this not work?
	while(c != '#'){
	  r++;
	  c = s.charAt(r);
	}
	// The r will be at '#' at this point that why we use r instead of r+1
	int len = Integer.parseInt(s.substring(l,r));
	r++;
	String word = s.substring(r,r+len);
	result.add(word);
	l = r+len;
	r = r+len;
      }

      return result;

  }

 
 public static void main(String[]args){

   String[] strs = {"Hello","Bring","Me","Chicken"};
   String s = encodeString(strs);
   System.out.println(decodeString(s));

 }
	

}

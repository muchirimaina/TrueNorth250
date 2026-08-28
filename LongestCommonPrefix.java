import java.util.*;

class Solution{
	public static String longestCommonPrefix(String[] strs){
	
		String firstStr = strs[0];

		for(int i = 0; i < firstStr.length(); i++){
			for(String str: strs){
				if(str.charAt(i) != firstStr.charAt(i)){
					return firstStr.substring(0,i);
				}
			}
		
		}

		return firstStr;
	}


	public static void main(String[] args){
		String[] strs = {"flowers","dlour","glourish"};

		System.out.println(longestCommonPrefix(strs));
	}


}

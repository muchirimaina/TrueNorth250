import java.util.*;

class Solution{

	public static int reversePolish(String[] tokens){
	   	Stack<Integer> stack = new Stack<>();

		for(String token: tokens){
		    if(token.equals("+")){
			int a = stack.pop();
			int b = stack.pop();

			int c = a + b;
			stack.push(c);
		    }else if(token.equals("*")){
			int b = stack.pop();
			int h = stack.pop();

			int g = b * h;
			stack.push(g);
		    }else if(token.equals("-")){
			int p = stack.pop();
			int t = stack.pop();

			int r = t-p;
			stack.push(r);
		   }else{
			stack.push(Integer.parseInt(token));
		  }   
		}

		return stack.pop();
	}

	public static void main(String[] args){
	  String[] tokens = {"1","2","+","3","*","4","-"};
	  System.out.println(reversePolish(tokens));
	}










}

import java.util.*;

class Solution{
   public static int baseballGame(String[] ops){
	Stack<Integer> stack = new Stack<>();
	int result = 0;
	for(String op:ops){
	    if(op.equals("+")){
		int a = stack.pop();
		int b = stack.peek();
		int c = a+b;
		stack.push(a);
		result += stack.push(c);
	    }else if(op.equals("C")){
		result -= stack.pop();
	    }else if(op.equals("D")){
		int z = stack.peek();
		result += stack.push(z*2);
	    }else{
		int h = Integer.parseInt(op);
		result +=stack.push(h);
	    }
	}

	return result;
   }

   public static void main(String[] args){
	String[] ops = {"1","2","+","C","5","D"};
	String[] ops2 = {"5","D","+","C"};

	System.out.println(baseballGame(ops2));

   }







}

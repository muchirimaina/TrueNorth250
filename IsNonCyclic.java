class IsNonCyclic{
    public static boolean isNonCyclic(int num){

        int slow = num;
        int fast = num;

        do{
            slow = isNext(slow);
            fast = isNext(fast);
            fast = isNext(fast);

        }while (slow != fast);

        return slow == 1;

    }

    public static int isNext(int num){

        int sum = 0;

        // Why greater than zero and not while num != 1 or num >1? would make more sense : Answer: Because it's a integer division the number finally gets to Zero i.e 6/10 will be 0 since Integers in 
        // Java don't give digits. So while(num > 0) is the correct approach.

        while(num > 0){

            int digit = num%10;
            sum += digit*digit;
            num = num/10;

        }

        num = sum;
        return num; 
    }

    public static void main(String[] args){
        int num = 100;
        System.out.println(isNonCyclic(num));
   }
}



































class Solution{

	public static boolean isNonCyclic(int n){
		
		// fast and slow pointers - research tommorow why they meet, and is it a must for them to meet while the fast is equal to slow
		// Slow moves 1 step, fast moves 2 steps. If a cycle exists, fast gains one position on slow every iteration, so they must eventually occupy the same position.
		int slow = isNext(n);
		int fast = isNext(n);


		do{
			slow = isNext(slow);
			fast = isNext(fast);
			fast = isNext(fast);

		}while(slow != fast);

		return slow == 1;

	}
	

	public static int isNext(int n){
		int sum = 0;
		while(n > 0){
			int digit = n % 10;
			sum += digit*digit;
			n /= 10;
			
		}

		n = sum;

		return n;

	}
	
	 public static void main(String[] args){
        int num = 100;
        System.out.println("This is the latest code: "+isNonCyclic(num));
    }

}

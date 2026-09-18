class Solution{
	public static int bestTimeToBuyAccumulative(int[] prices){
	  int maxP = 0;

	  for(int i = 1; i < prices.length; i++){
		if(prices[i] > prices[i-1]){
		  maxP += prices[i]-prices[i-1]; 
		}
	  }
	  return maxP;
	}

	public static void main(String[] args){
	  int[] prices = {1,2,3,4,5};
	  System.out.println(bestTimeToBuyAccumulative(prices));
	}
}

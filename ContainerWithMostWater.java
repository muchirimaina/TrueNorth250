class Solution{

	public static int containerMostWater(int[] heights){

		int l = 0;
		int r = heights.length-1;
		int maxW = 0;
		while(l < r){
			
		    maxW = Math.max(maxW,Math.min(heights[l],heights[r])*(r-l));
		    
		   if(heights[l] > heights[r]){
			r--;
		   }else{
			l++;
		   }
		

		}

		return maxW;;


	}

	public static void main(String[] args){
	   int[] heights = {2,7,2,5,7,1,2,6};
	   System.out.println(containerMostWater(heights));
	}



}

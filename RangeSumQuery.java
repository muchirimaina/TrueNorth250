// building the prefix Sum
// Reading from the 2D prefixSum
// Check tommorow
class Solution{
	int[][] prefixSum;	

	public static void buildPrefixSum(int[][] grid){
		int R = grid.length;
		int C = grid[0].length;
		prefixSum = new int[R+1][C+1]


		for(int r = 1; r < prefixSum.length; r++){
		   for(int c = 1; c < prefixSum[0].length;c++){
			prefixSum[r][c] = grid[r-1][c-1]+ prefixSum[r-1][c] + prefixSum[r][c-1] - prefixSum[r-1][c-1];
		   }

		}


	}

	public static int readSum(int row1, int col1, int row2, int col2){

		return prefixSum[row2+1][col2+1] - prefixSum[row2+1][col1] - prefixSum[row1][col2+1] + prefixSum[row1][col1];

	}

	


}

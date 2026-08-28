class Solution{
    static int[][] prefixSum;
    public static void buildSumMatrix(int[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        prefixSum = new int[R+1][C+1];

        for(int r = 1; r < prefixSum.length;r++){
            for(int c = 1; c < prefixSum[0].length; c++){
                // sum = current + left + top - common
                prefixSum[r][c] = matrix[r-1][c-1] + prefixSum[r][c-1] + prefixSum[r-1][c] - prefixSum[r-1][c-1];
            }
        }
    }

    public static int readSumForGivenCoordinates(int row1,int col1, int row2,int col2){
        // total prefixSum - leftPrefix - rightPref + topLeft
        return prefixSum[row2+1][col2+1] - prefixSum[row2+1][col1] - prefixSum[row1][col2+1] + prefixSum[row1][col1];
    }

    public static void main(String[] args){
        int[][] matrix = {{6,0,2},{3,2,1},{9,11,5}};
        int row1 = 0;
        int col1 = 0;
        int row2 = 1;
        int col2 = 1;
        buildSumMatrix(matrix);
        System.out.println(readSumForGivenCoordinates(row1,col1,row2,col2));
    }
}
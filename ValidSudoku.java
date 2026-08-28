import java.util.*;

class Solution{

    public static boolean isValidSudoku(int[][] grid){
        int R = grid.length;
        int C = grid[0].length;

        Set<String> set = new HashSet<>();


        


        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){

                if(grid[r][c] == '.') continue;

                int val = grid[r][c];

                int b = r/3*3 + c/3;

                String rowItem = "r"+ r + val;
                String colItem = "c"+ c + val;
                String boxItem = "b"+ b + val;

                


                // checks if you can't add
                if(!set.add(rowItem) || !set.add(colItem) || !set.add(boxItem)){
                    return false;
                }

                
            }
        }

        return true;
    }
}



































public static boolean isValidSudoku(int[][] grid){
	Set<String> set = new HashSet<>();
	for(int r = 0; r < 9; r++){
	  for(int c = 0; c < 9; c++{	

		char val = grid[r][c];
		if(val == '.') continue;
		String rowString = "r"+r+val;
		String colString = "c"+c+val;
		String boxString = "b"+(r/3*3+c/3)+val;

		if(!set.add(rowString) || !set.add(colString) || !set.add(boxString)) return false;
		

	  }
	}

	return true;
}

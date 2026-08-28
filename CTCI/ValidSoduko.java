class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') continue;

                char val = board[r][c];

                String rowKey = "r" + r + val;
                String colKey = "c" + c + val;
                String boxKey = "b" + (r / 3) + (c / 3) + val;

                if (!seen.add(rowKey) ||
                    !seen.add(colKey) ||
                    !seen.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}
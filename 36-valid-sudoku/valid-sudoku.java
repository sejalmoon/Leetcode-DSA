class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        int n = board.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                if(!seen.add("row"+i+ch)) return false;
                if(!seen.add("col"+j+ch)) return false;
                int box = (i/3)*3 + (j/3);
                if(!seen.add("box"+box+ch)) return false;
            }
        }
        return true;
    }
}
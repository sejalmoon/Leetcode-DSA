class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int top = 0;
        int bottom = n-1;
        while(top<bottom){
            for(int i=0; i<n; i++){
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
            }
            top++;
            bottom--;
        }

        for(int row = 0; row<n; row++){
            for(int col = row+1; col<n; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor = image[sr][sc];
        int[][] ans = image;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        dfs(sr,sc,color,ans,delrow,delcol,inicolor,image);
        return ans;
    }

    private void dfs(int row, int col, int color, int[][] ans, int[] delrow, int[] delcol, int inicolor, int[][] image){
        ans[row][col] = color;
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<ans.length && ncol>=0 && ncol<ans[0].length && image[nrow][ncol]==inicolor && ans[nrow][ncol]!=color){
                dfs(nrow,ncol,color,ans,delrow,delcol,inicolor,image);
            }
        }
    }
}
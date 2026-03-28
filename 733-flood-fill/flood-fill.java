class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oriColor = image[sr][sc];
        int[][] ans = image;
        dfs(ans, sr, sc, oriColor, color, image);
        return ans;
    }

    private void dfs(int[][] ans, int sr, int sc, int oriColor, int color, int[][] image){
        int m = ans.length;
        int n = ans[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};

        ans[sr][sc] = color;
        for(int i = 0; i<4; i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && image[nrow][ncol]==oriColor && ans[nrow][ncol] != color){
                dfs(ans, nrow, ncol, oriColor, color, image);
            }
        }
    }
}
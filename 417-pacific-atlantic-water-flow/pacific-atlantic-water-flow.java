class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for(int i = 0; i<m; i++){
            dfs(0, i, heights, pacific);
        }
        for(int i = 0; i<m; i++){
            dfs(n-1, i, heights, atlantic);
        }
        for(int i = 0; i<n; i++){
            dfs(i, 0, heights, pacific);
        }
        for(int i = 0; i<n; i++){
            dfs(i, m-1, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] visited){
        if(visited[row][col]) return;
        visited[row][col] = true;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};
        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow<0 || nrow>=heights.length || ncol<0 || ncol>=heights[0].length) continue;
            if(heights[nrow][ncol] < heights[row][col]) continue;
            dfs(nrow, ncol, heights, visited);
        }
    }
}
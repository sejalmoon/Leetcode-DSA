class Solution {

    class Node{
        int i;
        int j;
        int steps;
        public Node(int i, int j, int steps){
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        int[][] ans = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Node a = q.poll();
            int row = a.i;
            int col = a.j;
            int steps = a.steps;

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, -1, 0, 1};
            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !vis[nrow][ncol]){
                    q.add(new Node(nrow, ncol, steps+1));
                    ans[nrow][ncol] = steps + 1;
                    vis[nrow][ncol] = true;
                }
            }
        }
        return ans;
    }
}
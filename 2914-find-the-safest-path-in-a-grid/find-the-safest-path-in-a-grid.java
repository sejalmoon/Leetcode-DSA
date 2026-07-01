class Pair{
    public int row;
    public int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] mat = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        int[] delr = {0, -1, 0, 1};
        int[] delc = {-1, 0, 1, 0};

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid.get(i).get(j) == 1){
                    q.add(new Pair(i, j));
                    mat[i][j] = 0;
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair p = q.poll();
                for(int i = 0; i<4; i++){
                    int row = p.row + delr[i];
                    int col = p.col + delc[i];
                    int val = mat[p.row][p.col];

                    if(isValid(mat, row, col) && mat[row][col] == -1){
                        mat[row][col] = val + 1;
                        q.add(new Pair(row, col));
                    }
                }
            }
        }

        int start = 0;
        int end = 0;
        int res = -1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                end = Math.max(end, mat[i][j]);
            }
        }

        while(start <= end){
            int mid = start + (end-start)/2;
            if(isValidSafeness(mat, mid)){
                res = mid;
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        return res;

    }

    private boolean isValidSafeness(int[][] mat, int minSafeness){
        int n = mat.length;

        if(mat[0][0] < minSafeness || mat[n-1][n-1] < minSafeness) return false;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        int[] delr = {0, -1, 0, 1};
        int[] delc = {-1, 0, 1, 0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.row == n-1 && p.col == n-1) return true;

            for(int i = 0; i<4; i++){
                int nrow = p.row + delr[i];
                int ncol = p.col + delc[i];

                if(isValid(mat, nrow, ncol) && !vis[nrow][ncol] && mat[nrow][ncol] >= minSafeness){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        return false;

    }

    private boolean isValid(int[][] mat, int i, int j){
        int n = mat.length;
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}
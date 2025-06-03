class Solution {
    public int findMaxIndex(int[][] mat, int n, int m, int mid){
        int maxi = -1;
        int index = -1;
        for(int i=0;i<n;i++){
            if(mat[i][mid]>maxi){
                maxi=mat[i][mid];
                index = i;
            }
        }
        return index;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low=0;
        int high=m;
        while(low<=high){
            int mid = (low+high)/2;
            int maxi = findMaxIndex(mat, n , m, mid);
            int left = mid-1 >=0 ? mat[maxi][mid-1] : -1;
            int right = mid+1 < m ? mat[maxi][mid+1] : -1;
            if(mat[maxi][mid] > left && mat[maxi][mid]>right){
                return new int[]{maxi,mid};
            }
            else if(left > mat[maxi][mid]){
                high= mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
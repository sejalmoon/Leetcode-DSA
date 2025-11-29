class Solution {
    public int maxDistance(int[] position, int m) {
        int ans = 0;
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = (int)Math.ceil(position[n-1]/(m-1));

        while(low <= high){
            int mid = low + (high-low)/2;

            if(canPlace(mid, position, m)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canPlace(int x, int[] position, int m){
        int prev = position[0];
        int placed = 1;
        for(int i = 1; i<position.length && placed<m; i++){
            int curr = position[i];
            if(curr - prev >= x){
                placed++;
                prev = curr;
            }
        }
        return m == placed;
    }
}
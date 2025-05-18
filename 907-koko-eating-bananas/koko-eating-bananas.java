class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=0;
        int n=piles.length;
        int high=0;
        for(int i=0;i<n;i++){
            high=Math.max(high,piles[i]);
        }
        
        while(low<=high){
            int time=0;
            int mid=(low+high)/2;
            for(int i=0;i<n;i++){
                time += Math.ceil((double)piles[i] /(double) mid);
            }
            if (time <= h) {
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return low;
    }
}
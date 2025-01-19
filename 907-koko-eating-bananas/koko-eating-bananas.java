class Solution {

    public int findmax(int[] piles){
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxi= Math.max(maxi,piles[i]);
        }
        return maxi;
    }

    public int timeTaken(int[] piles, int h){
        int time=0;
        for(int i=0;i<piles.length;i++){
            time+=Math.ceil((double)piles[i]/(double)h);
        }
        return time;
    }


    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=findmax(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int time=timeTaken(piles,mid);
            if(time<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
class Solution {
    public boolean possible(int[] bloomday, int mid, int m, int k){
        int n = bloomday.length;
        int count=0;
        int bouno=0;
        for(int i=0;i<n;i++){
            if(bloomday[i]<=mid){
                count++;
            }
            else{
                bouno+=(count/k);
                count=0;
            }
        }
        bouno+=(count/k);
        return bouno>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        long val = (long) m*k;
        int n=bloomDay.length;
        if(val>n){
            return -1;
        }
        for(int i=0;i<n;i++){
            low = Math.min(low, bloomDay[i]);
            high=Math.max(high, bloomDay[i]);
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
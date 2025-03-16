class Solution {
    public long repairCars(int[] ranks, int cars) {
        int minRank = ranks[0];
        int maxRank = ranks[0];

        for(int i: ranks){
            minRank = Math.min(i,minRank);
            maxRank = Math.max(i,maxRank);
        }

        int[] freq = new int[maxRank + 1];
        for(int i: ranks){
            freq[i]++;
        }

        long low=1;
        long high= 1L * minRank*cars*cars;
        while(low<high){
            long mid = low + (high-low)/2;
            long totalcars=0;

            for (int i = 1; i <= maxRank; i++) {
                totalcars +=
                    freq[i] * (long) Math.sqrt(mid / (long) i);
            }

            if(totalcars>=cars){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
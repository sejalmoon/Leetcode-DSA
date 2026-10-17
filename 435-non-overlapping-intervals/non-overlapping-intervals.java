class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int endTime = intervals[0][1];

        for(int i = 1; i<n; i++){
            if(intervals[i][0] < endTime) ans++;
            else endTime = intervals[i][1];
        }
        return ans;
    }
}
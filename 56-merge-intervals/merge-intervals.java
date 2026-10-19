class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
         if (n <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));
        List<int[]> result = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            if (!result.isEmpty() && intervals[i][1] <= result.get(result.size() - 1)[1]) {
                continue;
            }
 
            int start = intervals[i][0];
            int end = intervals[i][1];
 
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
 
            result.add(new int[] {start, end});
        }
 
        return result.toArray(new int[result.size()][]);
    }
}
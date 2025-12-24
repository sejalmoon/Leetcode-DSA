class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        int space = 0;
        int count = 0;
        for(int a:apple){
            sum+=a;
        }
        Arrays.sort(capacity);
        int m = capacity.length;
        for(int i = m-1; i>=0; i--){
            space+=capacity[i];
            count++;
            if(space>=sum) break;
        }
        return count;
    }
}
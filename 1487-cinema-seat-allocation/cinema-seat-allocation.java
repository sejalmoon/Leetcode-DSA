class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int l = 0, r = 0, prev = 0;
        int s = reservedSeats.length;

        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);

        boolean[] isReserved = new boolean[11];
        int ans = 0;

        while(r < s){
            ans += 2*(reservedSeats[r][0] - prev -1);
            prev = reservedSeats[r][0];

            while(r < s && reservedSeats[l][0] == reservedSeats[r][0]){
                isReserved[reservedSeats[r][1]] = true;
                r++;
            }

            boolean twoToFive = check(isReserved, 2, 5);
            boolean fourToSeven = check(isReserved, 4, 7);
            boolean sixToNine = check(isReserved, 6, 9);

            if(twoToFive && sixToNine){
                ans += 2;
            }
            else if(twoToFive || fourToSeven || sixToNine){
                ans++;
            }
            l = r;
            Arrays.fill(isReserved, false);
        }

        ans += 2*(n - prev);
        return ans;
    }

    public boolean check(boolean[] b, int l, int r){
        for(int i = l; i <= r; i++){
            if(b[i]){
                return false;
            }
        }
        return true;
    }
}
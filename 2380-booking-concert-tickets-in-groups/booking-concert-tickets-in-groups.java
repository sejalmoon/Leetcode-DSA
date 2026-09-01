class BookMyShow {

    private int m;
    private int[] bookedByRow;
    private int[] maxGather; 
    private long[] maxScatter;

    public BookMyShow(int n, int m) {
        this.m = m;
        bookedByRow = new int[n];
        maxGather = new int[n];
        Arrays.fill(maxGather, m);
        
        maxScatter = new long[n];
        maxScatter[0] = m;
        for (int i = 1; i < n; i ++) {
            maxScatter[i] = maxScatter[i-1] + m;
        }
    }
    
    public int[] gather(int k, int maxRow) {
        if (maxGather[maxRow] < k) { 
            return new int[]{};
        }
        
        for (int i = 0; i <= maxRow; i++) {
            if (k <= m - bookedByRow[i]) {
                int[] firstSeat = {i, bookedByRow[i]};
                bookedByRow[i] += k;
                return firstSeat;
            }
        }
        
        updateMaxGather(maxRow); 
        return new int[]{};
    }

    private void updateMaxGather(int maxRow) {
        maxGather[0] = m - bookedByRow[0];
        for (int i = 1; i <= maxRow; i++) {
            maxGather[i] = Math.max(maxGather[i-1], m - bookedByRow[i]);
        }

    }
    
    public boolean scatter(int k, int maxRow) {
        if (maxScatter[maxRow] < k) { 
            return false;
        }
        
        if (! updateMaxScatter(k, maxRow)) {
            return false;
        }
        
        for (int i = 0; i <= maxRow && k > 0; i++) {
            int toRemove = (int)Math.min(m - bookedByRow[i], (long)k);
            bookedByRow[i] += toRemove;
            k -= toRemove;
        }
        
        return true;
    }

    private boolean updateMaxScatter(int k, int maxRow) {
        long maxScatterTmp = 0;
        for (int i = 0; i <= maxRow; i++) {
            maxScatterTmp += m - bookedByRow[i];
            maxScatter[i] = maxScatterTmp;
            if (maxScatterTmp >= k) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */
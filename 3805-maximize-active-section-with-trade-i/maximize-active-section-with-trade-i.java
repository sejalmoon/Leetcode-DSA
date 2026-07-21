class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int cnt1 = 0;
        for(char ch : s.toCharArray()){
            if(ch == '1') cnt1++;
        }

        List<Integer> zero = new ArrayList<>();
        int i = 0;
        while(i < n){
            int start = i;
            while(i < n && s.charAt(i) == s.charAt(start)){
                i++;
            }
            if(s.charAt(start) == '0'){
                zero.add(i-start);
            }
        }

        int m = zero.size();
        if(m < 2){
            return cnt1;
        }
        int best = 0;
        for(int j = 0; j<m-1; j++){
            best = Math.max(best, zero.get(j) + zero.get(j+1));
        }
        return cnt1 + best;
    }
}
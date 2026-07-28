class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String revs = new StringBuilder(s).reverse().toString();

        for(int i = 0; i<n; i++){
            if(s.substring(0, n-i).equals(revs.substring(i))){
                return new StringBuilder(revs.substring(0, i)).append(s).toString();
            }
        }

        return "";
    }
}
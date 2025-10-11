class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m){
            return false;
        }
        Map<Character,Character> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            char first=s.charAt(i);
            char second=t.charAt(i);
            if(!mp.containsKey(first)){
                if(!mp.containsValue(second)){
                    mp.put(first,second);
                }
                else{
                    return false;
                }
            }
            else{
                if(mp.get(first)!=second){
                    return false;
                }
            }
        }
        return true;
    }
}
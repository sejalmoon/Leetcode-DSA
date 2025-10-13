class Solution {
    public int myAtoi(String s) {
        if(s==null){
            return 0;
        }
        s = s.trim();
        if(s.length()==0){
            return 0;
        }
        int sign=1;
        long ans=0;
        if(s.charAt(0)=='-'){
            sign=-1;
        }
        int i=0;
        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            i=1;
        }
        int maxi = Integer.MAX_VALUE;
        int mini = Integer.MIN_VALUE;
        while(i<s.length()){
            if(s.charAt(i)==' ' || !Character.isDigit(s.charAt(i))){
                break;
            }
            ans = ans*10 + s.charAt(i)-'0';
            if(sign==-1 && ans*sign<mini){
                return mini;
            }
            if(sign==1 && ans*sign>maxi){
                return maxi;
            }
            i++;
        }
        return (int)(sign*ans);

    }
}
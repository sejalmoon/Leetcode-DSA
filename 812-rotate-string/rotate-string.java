class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        StringBuilder ans=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(ans.toString().equals(goal)){
                return true;
            }
            char ch=ans.charAt(0);
            ans.deleteCharAt(0);
            ans.append(ch);
        }

        return false;
    }
}
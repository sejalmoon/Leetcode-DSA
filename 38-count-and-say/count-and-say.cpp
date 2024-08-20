class Solution {
public:
    string countAndSay(int n) {
       if(n==1){
        return "1";
       } 
       string ans=countAndSay(n-1);
       string r="";
       int count=1;
       int p=ans.length();
       for(int i=0;i<p;i++){
        if(ans[i]==ans[i+1]){
            count++;
        }
        else{
            r+=to_string(count)+ans[i];
            count=1;
        }
       } 
       return r;
    }
};
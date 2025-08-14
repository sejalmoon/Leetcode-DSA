class Solution {

    private void solve(int idx, String s, List<String> list, List<List<String>> result){
        if(idx >= s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            String subStr = s.substring(idx, i+1);
            if(isPalindrome(subStr)){
                list.add(subStr);
                solve(i + 1, s, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(0, s, new ArrayList<>(), result);
        return result;
    }

    private boolean isPalindrome(String str){
        int n = str.length();
        int left=0, right=n-1;
        boolean flag = true;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                flag = false;
                break;
            }
            left++;
            right--;
        }
        return flag;
    }
}
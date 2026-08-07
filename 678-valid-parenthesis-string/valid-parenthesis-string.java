class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                open.push(i);
            }
            else if(ch == '*'){
                asterisk.push(i);
            }
            else{
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!asterisk.isEmpty()){
                    asterisk.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!open.isEmpty() && !asterisk.isEmpty()){
            if(open.pop() > asterisk.pop()){
                return false;
            }
        }
        return open.isEmpty();

    }
}
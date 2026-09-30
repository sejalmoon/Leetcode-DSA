class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> know = new HashMap<>();
        for(List<String> kn : knowledge){
            know.put(kn.get(0), kn.get(1));
        }

        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                addKey = true;
            }
            else if(ch == ')'){
                if(know.containsKey(key.toString())){
                    res.append(know.get(key.toString()));
                }else{
                    res.append('?');
                }
                addKey = false;
                key.setLength(0);
            }
            else if(addKey){
                key.append(ch);
            }
            else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}
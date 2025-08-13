class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        
        Map<Character,String> digitToLetter = new HashMap<>();
        digitToLetter.put('2',"abc");
        digitToLetter.put('3',"def");
        digitToLetter.put('4',"ghi");
        digitToLetter.put('5',"jkl");
        digitToLetter.put('6',"mno");
        digitToLetter.put('7',"pqrs");
        digitToLetter.put('8',"tuv");
        digitToLetter.put('9',"wxyz");
        backtrack(digits, ans, 0, "", digitToLetter);
        return ans;
    }

    private void backtrack(String digits, List<String> ans, int index, String combination, Map<Character,String> digitToLetter){
        if(index==digits.length()){
            ans.add(combination);
        }
        else{
            String letters = digitToLetter.get(digits.charAt(index));
            for(char letter:letters.toCharArray()){
                backtrack(digits, ans, index+1, combination+letter, digitToLetter);
            }
        }
    }
}
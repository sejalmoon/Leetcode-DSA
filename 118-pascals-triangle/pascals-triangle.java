class Solution {
    public List<List<Integer>> generate(int numRows) {

        if(numRows == 0) return new ArrayList<>();

        if(numRows == 1) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Arrays.asList(1));
            return ans;
        } 

        List<List<Integer>> temp = generate(numRows-1);

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            ans.add(1);
        }

        for(int i = 1; i<numRows-1; i++){
            ans.set(i, temp.get(numRows-2).get(i-1) + temp.get(numRows-2).get(i));
        }

        temp.add(ans);
        return temp;

    }
}
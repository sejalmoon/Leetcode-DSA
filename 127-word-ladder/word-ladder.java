class Solution {
    class Pair{

        private String word;
        private int steps;

        public Pair(String word, int steps){
            this.word = word;
            this.steps = steps;
        } 

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<>();
        int len = wordList.size();
        for(int i = 0; i<len; i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.poll();
            if(word.equals(endWord)) return steps;

            for(int i = 0; i<word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String newWord = new String(charArray);

                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new Pair(newWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
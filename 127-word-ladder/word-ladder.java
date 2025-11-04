class Pair {
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<>();
        for(int i = 0; i<wordList.size(); i++){
            st.add(wordList.get(i));
        }

        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if(word.equals(endWord)){
                return steps;
            }

            for(int i = 0; i<word.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] newChar = word.toCharArray();
                    newChar[i] = ch;
                    String newWord = new String(newChar);

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
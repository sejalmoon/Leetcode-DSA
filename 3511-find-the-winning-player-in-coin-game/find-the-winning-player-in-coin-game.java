class Solution {
    public String winningPlayer(int x, int y) {
        int count = 0;
        while(x>0 && y>3){
            x=x-1;
            y=y-4;
            count++;
        }
        return (count%2 == 0) ? "Bob" : "Alice";
    }
}
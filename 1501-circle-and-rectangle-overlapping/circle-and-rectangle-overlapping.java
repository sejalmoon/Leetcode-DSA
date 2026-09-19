class Solution {
    public boolean checkOverlap(int radius, int xcenter, int ycenter, int x1, int y1, int x2, int y2) {
        double dist = 0;
        if(xcenter < x1 || xcenter > x2){
            dist += Math.min(Math.pow(x1 - xcenter, 2), Math.pow(x2 - xcenter, 2));
        }

        if(ycenter < y1 || ycenter > y2){
            dist += Math.min(Math.pow(y1 - ycenter, 2), Math.pow(y2 - ycenter, 2));
        }

        return dist <= radius*radius;
    }

}
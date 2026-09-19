class Solution {
    public boolean checkOverlap(int radius, int xcenter, int ycenter, int x1, int y1, int x2, int y2) {
        if(xcenter >= x1 && xcenter <= x2 && ycenter >= y1 && ycenter <= y2) return true;

        if(xcenter >= x1 && xcenter <= x2 && ycenter >= y2 && ycenter <= y2 + radius) return true;

        if(xcenter >= x1 && xcenter <= x2 && ycenter <= y1 && ycenter >= y1 - radius) return true;

        if(xcenter <= x1 && xcenter >= x1 - radius && ycenter >= y1 && ycenter <= y2) return true;

        if(xcenter >= x2 && xcenter <= x2 + radius && ycenter >= y1 && ycenter <= y2) return true;

        if(dist(xcenter, ycenter, x1, y1) <= radius*radius) return true;

        if(dist(xcenter, ycenter, x2, y1) <= radius*radius) return true;

        if(dist(xcenter, ycenter, x2, y2) <= radius*radius) return true;

        if(dist(xcenter, ycenter, x1, y2) <= radius*radius) return true;

        return false;
    }

    private long dist(int x1, int y1, int x2, int y2){
        return (long)(Math.pow(x1 - x2, 2)) + (long)(Math.pow(y1 - y2, 2));
    }
}
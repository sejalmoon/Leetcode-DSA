import java.util.*;
class Solution {
    public static int shipWithinDays(int[] weights, int days) {
        
        int max=Integer.MIN_VALUE, s=0;
        for(int x : weights)
        {
            max=Math.max(x,max);
            s+=x;
        }
        int l=max,h=s,mid=0;
        int dayReq=0;
        while(l<=h)
        {
            mid=(l+h)/2;
            dayReq=daysReq(weights,mid);
            if(dayReq<=days)
            h=mid-1;
            else
            l=mid+1;
        }
        return l;
    }
    public static int daysReq(int w[], int cap)
    {
        int load=0,d=1;
        for(int i=0;i<w.length;i++)
        {
        if(load+w[i]>cap)
        {
            d+=1;
            load=w[i];
        }
        else
        load+=w[i];
        }
        return d;
    }
}
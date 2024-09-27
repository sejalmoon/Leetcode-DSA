class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //merge
        int n=nums1.length;
        int m=nums2.length;
        double[] ans=new double[n+m];
        int k=0;
        int i,j;
        for(i=0,j=0;i<n&&j<m;){
            if(nums1[i]<nums2[j]){
                ans[k]=nums1[i];
                i++;
                k++;
            }
            else{
                ans[k]=nums2[j];
                j++;
                k++;
            }
        }
        if(i<n){
            while(i<n){
                ans[k]=nums1[i];
                k++;
                i++;
            }
        }
        if(j<m){
            while(j<m){
                ans[k]=nums2[j];
                k++;
                j++;
            }
        }
        if((n+m)%2==0){
            return (ans[(n+m)/2]+ans[((n+m)/2)-1])/2;
        }
        else{
            return ans[(n+m)/2];
        }
    }
}
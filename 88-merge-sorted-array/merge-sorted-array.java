class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mind = m-1;
        int nind = n-1;
        int right = m+n-1;

        while(nind >= 0){
            if(mind >= 0 && nums1[mind] > nums2[nind]){
                nums1[right] = nums1[mind];
                mind--;
            }else{
                nums1[right] = nums2[nind];
                nind--;
            }
            right--;
        }
    }
}
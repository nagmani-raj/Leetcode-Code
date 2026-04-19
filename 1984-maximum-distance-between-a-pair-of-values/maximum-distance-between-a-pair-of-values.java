class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0;

        int maxlen = 0;

        while(j<m && i<n){
            if(nums1[i] <= nums2[j]){
                maxlen = Math.max(maxlen , j-i);
                j++;
            }else{
                i++;
            }
        }

        return maxlen;
    }
}
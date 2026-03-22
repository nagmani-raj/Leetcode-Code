class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        if(n < 1) return 0;

        nums[i] = nums[j];

        while(i<n && j<n){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
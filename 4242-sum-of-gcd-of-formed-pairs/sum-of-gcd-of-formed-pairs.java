class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;

        int[] pg = new int[n];

        int mx = nums[0];

        for(int i=0; i<n; i++){
            mx = Math.max(mx,nums[i]);
            pg[i] = gcd(nums[i] , mx);
        }

        Arrays.sort(pg);

        int left = 0;
        int right = n-1;
        long sum = 0;

        while(left<right){
           sum += gcd(pg[left],pg[right]);
            left++;
            right--;
        }
        return sum;
    }

    int gcd(int a, int b){
        while(b!=0){
            int temp = a%b;
            a = b;
            b = temp;
        }

        return a;
    }
}
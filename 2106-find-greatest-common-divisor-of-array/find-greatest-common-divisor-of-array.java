class Solution {
    public int gcd(int a, int b){
        if(b==0) return a;

        return gcd(b , a%b);
    }
    public int findGCD(int[] nums) {
        int min = 1001;
        int max = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }

        int gcd = gcd(max , min);

        return gcd;
    }
}
class Solution {
    public int mirrorDistance(int n) {
        int rev = 0 ;
        int or = n ;

        for(; n != 0; n = n/10){
            int digit = n%10;
            rev = rev*10 + digit;
        }

        int ans = Math.abs(or - rev);

        return ans;
    }
}
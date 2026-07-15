class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b , a%b);
    }

    public int gcdOfOddEvenSums(int n) {
        int odd = 0;
        int even = 0;
        for(int i=0; i<n; i++){
            odd = odd + 2*i + 1;
            even = even + 2*i ;
        }

        int gcd = gcd(even , odd);

        return gcd;
    }
}
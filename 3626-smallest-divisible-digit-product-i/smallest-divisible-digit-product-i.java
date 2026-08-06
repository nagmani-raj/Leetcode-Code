class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            if (isDivisible(n, t)) {
                return n;
            }
            n++;
        }
    }

    public boolean isDivisible(int num, int t) {
        int product = 1;

        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }

        return product % t == 0;
    }
}
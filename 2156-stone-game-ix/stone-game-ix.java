public class Solution {
    public boolean stoneGameIX(int[] stones) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i : stones) {
            if (i % 3 == 0) {
                zero++;
            } else if (i % 3 == 1) {
                one++;
            } else if (i % 3 == 2) {
                two++;
            }
        }
        if (one == 0 && two == 0) {
            return false;
        }
        int max = Math.max(one, two);
        int min = Math.min(one, two);
        if (zero % 2 == 0) {
            return min != 0;
        }
        if (zero % 2 == 1) {
            return max - 2 > min;
        }
        return false;
    }
}
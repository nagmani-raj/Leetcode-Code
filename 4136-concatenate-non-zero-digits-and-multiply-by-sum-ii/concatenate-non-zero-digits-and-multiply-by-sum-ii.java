import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                positions.add(i);
            }
        }

        int m = digits.size();

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefWeighted = new long[m + 1];
        long[] prefSum = new long[m + 1];

        for (int i = 0; i < m; i++) {
            prefWeighted[i + 1] = (prefWeighted[i] * 10 + digits.get(i)) % MOD;
            prefSum[i + 1] = prefSum[i] + digits.get(i);
        }

        int[] pos = new int[m];
        for (int i = 0; i < m; i++) pos[i] = positions.get(i);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;

            long x = (prefWeighted[right + 1]
                    - prefWeighted[left] * pow10[len]) % MOD;
            if (x < 0) x += MOD;

            long sum = prefSum[right + 1] - prefSum[left];

            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
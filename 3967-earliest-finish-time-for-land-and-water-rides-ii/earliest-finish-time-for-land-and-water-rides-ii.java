import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans1 = solveOrder(
                landStartTime, landDuration,
                waterStartTime, waterDuration
        );

        long ans2 = solveOrder(
                waterStartTime, waterDuration,
                landStartTime, landDuration
        );

        return (int) Math.min(ans1, ans2);
    }

    private long solveOrder(int[] firstStart, int[] firstDur,
                            int[] secondStart, int[] secondDur) {

        int n = secondStart.length;

        int[][] rides = new int[n][2];
        for (int i = 0; i < n; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[n];
        long[] prefixMinDur = new long[n];
        long[] suffixMinFinish = new long[n + 1];

        for (int i = 0; i < n; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDur[0] = rides[0][1];
        for (int i = 1; i < n; i++) {
            prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
        }

        suffixMinFinish[n] = Long.MAX_VALUE / 4;
        for (int i = n - 1; i >= 0; i--) {
            long finish = (long) rides[i][0] + rides[i][1];
            suffixMinFinish[i] = Math.min(suffixMinFinish[i + 1], finish);
        }

        long best = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {
            long A = (long) firstStart[i] + firstDur[i];

            int idx = upperBound(starts, (int) A) - 1;

            long cur = Long.MAX_VALUE;

            if (idx >= 0) {
                cur = Math.min(cur, A + prefixMinDur[idx]);
            }

            cur = Math.min(cur, suffixMinFinish[idx + 1]);

            best = Math.min(best, cur);
        }

        return best;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
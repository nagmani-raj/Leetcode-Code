import java.util.*;

class Solution {
    private Integer[][] dp;
    private int[][] robotsArr;
    private int[] walls;
    private int n;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        n = robots.length;

        robotsArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            robotsArr[i][0] = robots[i];
            robotsArr[i][1] = distance[i];
        }

        Arrays.sort(robotsArr, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(walls);
        this.walls = walls;

        dp = new Integer[n][2];

        return dfs(n - 1, 1);
    }

    private int dfs(int i, int dir) {
        if (i < 0) return 0;

        if (dp[i][dir] != null) return dp[i][dir];

        // 🔹 Fire LEFT
        int left = robotsArr[i][0] - robotsArr[i][1];
        if (i > 0) {
            left = Math.max(left, robotsArr[i - 1][0] + 1);
        }

        int l = lowerBound(walls, left);
        int r = lowerBound(walls, robotsArr[i][0] + 1);

        int ans = dfs(i - 1, 0) + (r - l);

        // 🔹 Fire RIGHT
        int right = robotsArr[i][0] + robotsArr[i][1];
        if (i + 1 < n) {
            if (dir == 0) {
                right = Math.min(right,
                        robotsArr[i + 1][0] - robotsArr[i + 1][1] - 1);
            } else {
                right = Math.min(right,
                        robotsArr[i + 1][0] - 1);
            }
        }

        l = lowerBound(walls, robotsArr[i][0]);
        r = lowerBound(walls, right + 1);

        ans = Math.max(ans, dfs(i - 1, 1) + (r - l));

        return dp[i][dir] = ans;
    }

    private int lowerBound(int[] arr, int target) {
        int idx = Arrays.binarySearch(arr, target);
        if (idx < 0) return -idx - 1;
        return idx;
    }
}
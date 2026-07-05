public class Solution {
    private static final int[][] DIRECTIONS = new int[][] { {1, 0}, {0, 1}, {1, 1}};

    public int[] pathsWithMaxScore(List<String> board) {
        int rows = board.size();
        int columns = board.get(0).length();
        int[][][] dp = new int[rows][columns][2];
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = columns - 1; c >= 0; c--) {
                char current = board.get(r).charAt(c);
                if (current == 'S') {
                    dp[r][c][0] = 0;
                    dp[r][c][1] = 1;
                } else if (current != 'X') {
                    int maxScore = 0;
                    int paths = 0;
                    int currentScore = current == 'E' ? 0 : current - '0';
                    for (int[] dir : DIRECTIONS) {
                        int nextR = r + dir[0];
                        int nextC = c + dir[1];
                        if (nextR < rows && nextC < columns && dp[nextR][nextC][1] > 0) {
                            if (dp[nextR][nextC][0] + currentScore > maxScore) {
                                maxScore = dp[nextR][nextC][0] + currentScore;
                                paths = dp[nextR][nextC][1];
                            } else if (dp[nextR][nextC][0] + currentScore == maxScore) {
                                paths = (paths + dp[nextR][nextC][1]) % 1000000007;
                            }
                        }
                    }
                    dp[r][c][0] = maxScore;
                    dp[r][c][1] = paths;
                }
            }
        }
        return new int[] {dp[0][0][0], dp[0][0][1]};
    }
}

class Solution {
    public int findMaxSub(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int cnt = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            cnt = 1 + findMaxSub(i + 1, j + 1, s1, s2, dp);
        } else {
            int a = findMaxSub(i + 1, j, s1, s2, dp);
            int b = findMaxSub(i, j + 1, s1, s2, dp);
            cnt = Math.max(a, b);
        }
        return dp[i][j] = cnt;
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int cnt = 0;
                if (s1.charAt(i) == s2.charAt(j)) {
                    cnt = 1 + dp[i + 1][j + 1];
                } else {
                    int a = dp[i + 1][j];
                    int b = dp[i][j + 1];
                    cnt = Math.max(a, b);
                }
                dp[i][j] = cnt;
            }
        }

        return dp[0][0];

    }
}
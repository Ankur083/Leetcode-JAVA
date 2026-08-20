class Solution {
    public int find(int i, int M, int[] suff, int[][] dp) {

        if (i + 2 * M >= suff.length) {
            return suff[i];
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int ans = 0;
        for (int x = 1; x <= 2 * M; x++) {
            ans = Math.max(ans, suff[i] - find(i + x, Math.max(M, x), suff, dp));
        }

        return dp[i][M] = ans;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n][n + 1];

        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        int[] suff = new int[n];
        suff[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + piles[i];
        }
        return find(0, 1, suff, dp);
    }
}
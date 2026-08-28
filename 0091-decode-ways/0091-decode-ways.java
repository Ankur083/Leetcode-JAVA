class Solution {
    public int cntOfDecoded(int i, int j, Set<String> set, String s, int [][]dp) {

        if (j > s.length()) {
            return 0;
        }

        if (!set.contains(s.substring(i, j))) {
            return 0;
        }

        if (j == s.length()) {
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int a = cntOfDecoded(j, j + 1, set, s, dp);
        int b = cntOfDecoded(j, j + 2, set, s, dp);

        return dp[i][j] = a + b;
    }

    public int numDecodings(String s) {
        Set<String> set = new HashSet<>();

        for (int i = 1; i <= 26; i++) {
            String str = "" + i;
            set.add(str);
        }

        int n = s.length();
        int[][] dp = new int[n + 1][n + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return cntOfDecoded(0, 1, set, s, dp) + cntOfDecoded(0, 2, set, s, dp);
    }
}
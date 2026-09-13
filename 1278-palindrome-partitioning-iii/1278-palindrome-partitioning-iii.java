class Solution {
    public int makePalindromic(String str) {

        if (str.length() == 1) {
            return 0;
        }
        int cnt = 0;
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                cnt++;
            }
            i++;
            j--;

        }
        return cnt;

    }

    public int findPartitioning(int i, int j, int par, int k, String s, int [][]dp) {

        if (i == j) {
            if (par == k) {
                return 0;
            }

            return (int) 1e8;
        }

        if (par > k) {
            return (int) 1e8;
        }

        if(dp[i][par] != -1){
            return dp[i][par];
        }

        int ans = Integer.MAX_VALUE;
        for (int l = i; l < j; l++) {
            String str = s.substring(i, l + 1);
            int cnt = makePalindromic(str);
            int cost = cnt + findPartitioning(l + 1, j, par + 1, k, s, dp);
            ans = Math.min(cost, ans);
        }

        return dp[i][par] = ans;

    }

    public int palindromePartition(String s, int k) {
        int [][]dp = new int[s.length()+1][k+1];

        for(int []r:dp){
            Arrays.fill(r, -1);
        }
        return findPartitioning(0, s.length(), 0, k, s, dp);
    }
}
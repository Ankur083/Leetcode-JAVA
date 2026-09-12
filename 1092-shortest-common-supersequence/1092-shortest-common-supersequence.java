class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int take = 0;
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    take = 1 + dp[i-1][j-1];
                } else {
                    int take1 = dp[i-1][j];
                    int take2 = dp[i][j-1];
                    take =  Math.max(take1, take2);
                }
                dp[i][j] = take;
            }
            
        }

        // for (int i = 0; i < s1.length() + 1; i++) {
        //     for (int j = 0; j < s2.length() + 1; j++) {
        //         System.out.print(dp[i][j] + " ");

        //     }
        //     System.out.println();
        // }

        StringBuilder sb = new StringBuilder();

        int i = n1;
        int j = n2;

        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    sb.append(s1.charAt(i-1));
                    i--;
                } else {
                    sb.append(s2.charAt(j-1));
                    j--;
                }
            }
        }

        while (i > 0) {
            sb.append(s1.charAt(i-1));
            i--;
        }

        while (j > 0) {
            sb.append(s2.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();

    }
}
class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        for (int i = n1-1; i >= 0; i--) {
            for (int j = n2-1; j >= 0; j--) {
                int take = 0;
                if (s1.charAt(i) == s2.charAt(j)) {
                    take = 1 + dp[i+1][j+1];
                } else {
                    int take1 = dp[i+1][j];
                    int take2 = dp[i][j+1];
                    take =  Math.max(take1, take2);
                }
                dp[i][j] = take;
            }
            
        }

        // for (int i = 0; i < s1.length() + 1; i++) {
            // for (int j = 0; j < s2.length() + 1; j++) {
            //     System.out.print(dp[i][j] + " ");

            // }
            // System.out.println();
        // }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < n1  && j < n2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++;
                j++;
            } else {
                if (dp[i+1][j] > dp[i][j+1]) {
                    sb.append(s1.charAt(i));
                    i++;
                } else {
                    sb.append(s2.charAt(j));
                    j++;
                }
            }
        }

        while (i < n1) {
            sb.append(s1.charAt(i));
            i++;
        }

        while (j < n2) {
            sb.append(s2.charAt(j));
            j++;
        }

        return sb.toString();

    }
}
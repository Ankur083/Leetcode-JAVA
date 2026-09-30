class Solution {
    public boolean find(int i, int j, String s, String p, Boolean [][]dp){

        if(i == s.length() && j == p.length()){
            return true;
        }

        if(j == p.length()){
            return false;
        }

        if(i == s.length()){
            while(j < p.length()){
                if(p.charAt(j) != '*'){
                    return false;
                }
                j++;
            }
            return true;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        boolean take = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            take = find(i+1, j+1, s, p, dp);
        }
        else{
            boolean take1 = false;
            boolean take2 = false;
            if(p.charAt(j) == '*'){
                 take1 = find(i+1, j, s, p, dp);
                 take2 = find(i, j+1, s, p, dp);
            }
            else{
                return dp[i][j] =  false;
            }

            return dp[i][j] = take1 || take2;
            
        }

        return dp[i][j] = take;
    }
    public boolean isMatch(String s, String p) {
        Boolean [][]dp = new Boolean[s.length()][p.length()];
        return find(0, 0, s, p, dp);
    }
}
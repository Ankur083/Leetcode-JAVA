class Solution {
    public boolean isPalindrome(int i, int j, String str){
       
        while(i < j){
            
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
    public int find(int i, String s, int []dp){

        if(i == s.length()){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int min = Integer.MAX_VALUE;
        for(int j = i;j < s.length(); j++){
            
            int cnt = 0;
            if(!isPalindrome(i, j, s)){
                continue;    
            }

            cnt = 1 + find(j+1, s, dp);
            min = Math.min(min, cnt);
            
        }
        return dp[i] = min;
    }

    public int minCut(String s) {
        int []dp = new int[s.length()];

        Arrays.fill(dp, -1);

        return find(0, s, dp)-1;
    }
}
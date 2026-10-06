class Solution {
    public int scoreOfParentheses(String s) {

        int ans = 0;
        int cnt = 0;
        int i = 0;

        while(i < s.length()){
            if(s.charAt(i) == '('){
                cnt++;
                i++;
            }
            else{
                if(i > 0 && s.charAt(i-1) == '('){
                    ans += (int)Math.pow(2, cnt-1);
                }

                cnt--;
                i++;  
            }
        }
        return ans;
    }
}
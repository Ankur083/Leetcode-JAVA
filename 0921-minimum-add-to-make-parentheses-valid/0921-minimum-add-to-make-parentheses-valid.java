class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int cnt = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
            }
            else{
                cnt--;
            }

            if(cnt < 0){
                ans++;
                cnt = 0;
            }
        }
        return ans+cnt;
    }
}
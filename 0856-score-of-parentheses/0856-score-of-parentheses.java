class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character>st  = new Stack<>();
        int ans = 0;
        int i = 0;

        while(i < s.length()){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
                i++;
            }
            else{
                st.pop();
                int cnt = 0;
            
                if(i > 0 && s.charAt(i-1) == '('){
                    cnt = (int)Math.pow(2, st.size());
                    ans += cnt;
                }


                i++;  
            }
        }
        return ans;
    }
}
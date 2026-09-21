class Solution {
    public void find(int open, int close, int n,  List<String>ans, StringBuilder sb){
        
        if(open == n && close == n){
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            find(open+1, close, n, ans, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open > close){
            sb.append(')');
            find(open, close+1, n, ans, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();

         find(0, 0, n, ans, new StringBuilder());

         return ans;
    }
}
class Solution {
    public void reverse(int []s){
        int i = 0;
        int j = s.length-1;

        while(i < j){
            s[i] = s[i]^s[j];
            s[j] = s[i]^s[j];
            s[i] = s[i]^s[j];

            i++;
            j--;
        }
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // reverse(s);

        int cnt = 0;

        int i = 0;
        int j = 0;

        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                cnt++;
                i++;
                j++;
            }
            else{
                j++;
            }
            
        }
        return cnt;
    }
}
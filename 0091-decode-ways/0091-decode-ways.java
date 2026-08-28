class Solution {
    // public int cntOfDecoded(int i, int j, Set<String>set, String s){

    //     if(j != 0 && (j > s.length() || !set.contains(s.substring(i, j)))){
    //         return 0;
    //     }

    //     if(j == s.length()){
    //         return 1;
    //     }

    //     int a = 0;
    //     int b = 0;

    //      a = cntOfDecoded(j, j+1, set, s);
    //      b = cntOfDecoded(j, j+2, set, s);

    //     return a+b;
    // }

    public int cntOfDecoded(int i, Set<String> st, String s, int []dp) {
        int n = s.length();

        if(i > n)
            return 0;
        
        if(i == n)
            return 1;

        if(dp[i] != -1){
            return dp[i];
        }

        String one = "" + s.charAt(i);
        int a=0, b = 0;

        if(st.contains(one)) {
            a = cntOfDecoded(i+1, st, s, dp);
        }

        String two = "";
        if(i+1 < n) {
            two = ""  + s.charAt(i) + s.charAt(i+1);
        }

        if(st.contains(two)) {
            b = cntOfDecoded(i+2, st, s, dp);
        }

        return dp[i] = a+b;
    }

    public int numDecodings(String s) {
        Set<String>set = new HashSet<>();

        for(int i = 1; i <= 26; i++){
            String str = ""+i;
            set.add(str);
        }
        int n = s.length();
        int dp[] = new int[n];

        Arrays.fill(dp, -1);


        return cntOfDecoded(0, set, s, dp);
    }
}
class Solution {
    
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int l = 0;
        int r = 0;
        int cnt = Integer.MAX_VALUE;
        int oneCnt = 0;
        int a = -1;
        int b = -1;

        while ( r < n) {
            if (s.charAt(r) == '1') {
                oneCnt++;
            }

            if (oneCnt == k) {
                if (cnt > r - l + 1) {
                    a = l;
                    b = r;
                    cnt = r - l + 1;
                } else if (cnt == r - l + 1) {
                    String s1 = s.substring(a,  b + 1);
                    String s2 = s.substring(l, r + 1);

                    if (s1.compareTo(s2) > 0) {
                        a = l;
                        b = r;
                    } 
                }
            }

            while (oneCnt == k) {
                if (s.charAt(l) == '1') {
                    oneCnt--;
                }
                l++;
                if (oneCnt == k) {
                    if (cnt > r - l + 1) {
                        a = l;
                        b = r;
                        cnt = r - l + 1;
                    } else if (cnt == r - l + 1) {
                        String s1 = s.substring(a, b + 1);
                        String s2 = s.substring(l, r + 1);

                        if (s1.compareTo(s2) > 0) {
                            a = l;
                            b = r;
                        } 
                    }
                }
            }
            r++;
        }

        if(cnt == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(a, b+1);

    }
}
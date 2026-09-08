class Solution {
    public long countCommas(long n) {
        if(n < 1000) return 0;

        long cnt = 0;
        long i = 1000;
        while(i <= n){

            cnt += (n-i+1);

            i *= 1000;
        }

        return cnt;

        
    }
}
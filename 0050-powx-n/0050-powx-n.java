class Solution {
    public double myPow(double x, int n) {

        long exp = n;
        double ans = 1.0;

        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }

        while(exp > 0){
            if((exp & 1) == 1){

                ans = ans*x;
            }

            x = x*x;

            exp = exp >> 1;
        }
        return ans;
    }
}
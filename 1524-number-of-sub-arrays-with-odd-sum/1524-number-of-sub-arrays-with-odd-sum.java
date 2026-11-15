class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0;
        int even = 1;

        int ans = 0;
        int sum = 0;

        int mod = 1000000007;

        for(int num: arr){
            sum += num;

            if(sum % 2 != 0){
                ans = (ans+even)%mod;
                odd++;
            }
            else{
                ans = (ans+odd)%mod;
                even++;
            }
        }
        return ans;
    }
}
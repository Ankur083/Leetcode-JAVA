class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        PriorityQueue<Integer>pq = new PriorityQueue<>();

        for(int num:nums){
            pq.offer(num);
        }

        while(k > 0){
            int num = pq.poll();
            pq.offer(num+1);
            k--;
        }

        int ans = 1;

        while(!pq.isEmpty()){
            int num = pq.poll();
            ans = (int)((long)ans*num%mod) ;
        }

        return ans%mod;
    }
}
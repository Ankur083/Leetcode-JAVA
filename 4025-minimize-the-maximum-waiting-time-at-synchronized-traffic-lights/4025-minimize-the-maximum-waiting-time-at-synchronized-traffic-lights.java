class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        Arrays.sort(lights);
        int n = lights.length;

        int waitingTime = 0;

        for(int i = 0; i < arrivalTime.length; i++){
            int r = arrivalTime[i]%period;

            if(r < lights[n-1]){
                continue;
            }
            else{
                waitingTime = Math.max(waitingTime, period-r);
            }
        }
        return waitingTime;
    }
}
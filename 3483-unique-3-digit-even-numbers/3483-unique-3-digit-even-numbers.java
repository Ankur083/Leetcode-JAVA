class Solution {
    public int totalNumbers(int[] digits) {
        int cnt = 0;

        // brute force approach;
        // Set<Integer>s = new HashSet<>();

        // for(int i = 0; i < digits.length; i++){
        //     if(digits[i] == 0){
        //         continue;
        //     }
        //     for(int j = 0; j < digits.length; j++){
        //         if(i == j){
        //             continue;
        //         }
        //         for(int k = 0; k < digits.length; k++){
        //             if(j == k || i == k || digits[k]%2 != 0){
        //                 continue;
        //             }
        //             int num = 0;
        //             num = num*10+digits[i];
        //             num = num*10+digits[j];
        //             num = num*10+digits[k];
        //             if(!s.contains(num)){
        //                 cnt++;
        //                 s.add(num);
        //             }

        //         }
        //     }
        // }
        // return cnt;

        int[] freq = new int[10];

        for (int num : digits) {
            freq[num]++;
        }

        for (int num = 100; num <= 998; num += 2) {

            int fDigit = num / 100;
            int sDigit = (num / 10) % 10;
            int tDigit = num % 10;

            freq[fDigit]--;
            freq[sDigit]--;
            freq[tDigit]--;

            if (freq[fDigit] >= 0 && freq[sDigit] >= 0 && freq[tDigit] >= 0) {
                cnt++;
            }

            freq[fDigit]++;
            freq[sDigit]++;
            freq[tDigit]++;
        }
        return cnt;
    }
}
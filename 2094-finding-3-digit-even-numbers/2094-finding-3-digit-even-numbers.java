class Solution {
    public int[] findEvenNumbers(int[] digits) {
       int[] freq = new int[10];
       List<Integer>allNum = new ArrayList<>();

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
                allNum.add(num);
            }

            freq[fDigit]++;
            freq[sDigit]++;
            freq[tDigit]++;
        }

        if(allNum.size() == 0){
            return new int[]{};
        }
        int []ans = new int[allNum.size()];
        for(int i = 0; i < allNum.size(); i++){
            ans[i] = allNum.get(i);
        }
        return ans; 
    }
}
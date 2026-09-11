class Solution {
    public int totalNumbers(int[] digits) {
        int cnt = 0;
        Set<Integer>s = new HashSet<>();

        for(int i = 0; i < digits.length; i++){
            if(digits[i] == 0){
                continue;
            }
            for(int j = 0; j < digits.length; j++){
                if(i == j){
                    continue;
                }
                for(int k = 0; k < digits.length; k++){
                    if(j == k || i == k || digits[k]%2 != 0){
                        continue;
                    }
                    int num = 0;
                    num = num*10+digits[i];
                    num = num*10+digits[j];
                    num = num*10+digits[k];
                    if(!s.contains(num)){
                        cnt++;
                        s.add(num);
                    }

                }
            }
        }
        return cnt;
    }
}
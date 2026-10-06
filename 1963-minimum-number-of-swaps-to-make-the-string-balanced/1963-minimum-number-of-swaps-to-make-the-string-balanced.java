class Solution {
    public int minSwaps(String s) {
        int ans = 0;
        int balance = 0;
      

        int j = s.length()-1;
        char []ch = s.toCharArray();
        int i = 0;

        while(i < j){
            if(ch[i] == '['){
                balance++;
            }
            else{
                balance--;
            }

            if(balance < 0){
                ans++;
                while(j > i){
                    if(ch[j] == '['){
                        char temp = ch[i];
                        ch[i] = ch[j];
                        ch[j] = temp;
                        j--;
                        balance = 1;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        return ans;
    }
}
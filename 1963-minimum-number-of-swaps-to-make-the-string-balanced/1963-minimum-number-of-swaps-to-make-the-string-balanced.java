class Solution {
    public int minSwaps(String s) {
        int ans = 0;
        int open = 0;
        int close = 0;

        int j = s.length()-1;
        char []ch = s.toCharArray();
        int i = 0;

        while(i < j){
            if(ch[i] == '['){
                open++;
            }
            else{
                close++;
            }

            if(open < close){
                ans++;
                while(j > i){
                    if(ch[j] == '['){
                        char temp = ch[i];
                        ch[i] = ch[j];
                        ch[j] = temp;
                        j--;
                        open++;
                        close--;
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
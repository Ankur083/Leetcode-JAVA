class Solution {
    public void leftRotate(int i, int j , char []ch){

        while(i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
    public int minOperations(String s) {
        int n = s.length();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int rotate = i;
            char []ch = s.toCharArray();

            leftRotate(0, i-1, ch);
            leftRotate(i, n-1, ch);
            leftRotate(0, n-1, ch);

            int l = 0;
            int r = n-1;
            int increment = 0;
            
            while(l < r){
                int abs1 = Math.abs((int)(ch[l]-ch[r]));
                int abs2 = 26-abs1;

                increment += Math.min(abs1, abs2);
                l++;
                r--;
            }

            min = Math.min(min, rotate+increment);

        }
        return min;
    }
}
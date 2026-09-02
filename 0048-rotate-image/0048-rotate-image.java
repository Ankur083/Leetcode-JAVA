class Solution {
    public void reverse(int []matrix){
        int i = 0;
        int j = matrix.length-1;

        while(i < j){
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        // int [][]arr=new int[n][n];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         arr[j][n-1-i]=matrix[i][j];
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         matrix[i][j]=arr[i][j];
        //     }
        // }
        // it is correct code but not for this question because it constraint is not use 2d array

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            reverse(matrix[i]);
        }
    
    }
}
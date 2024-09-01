class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
         int len = original.length;

        if(len != m * n){
            return new int[0][0];
        }
        int[][] array2D = new int[m][n];
        
        // for(int i = 0; i < len; i++){
        //    array2D[i / n][i % n] = original[i];
           
        // }
        int k = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                array2D[i][j] = original[k++];
            }
        }
        return array2D;
    }
    
}

class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        ArrayList<int[]> zeroIndex = new ArrayList<>();
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(matrix[i][j] == 0){
                    zeroIndex.add(new int[]{i,j}) ; 
                }
            }
        }
        
        for(int[] zero:zeroIndex){
            int i = zero[0];
            int j = zero[1];
            setZeroRowCol(matrix, i, j,rowLen,colLen);
        }
        
        
    }
    public void setZeroRowCol(int[][] matrix, int row, int col,int rowLen
    , int colLen){
        
        for(int i = 0 ; i < colLen; i++){
            matrix[row][i] = 0;
           
        }
        for(int i = 0; i < rowLen; i++){
           
             matrix[i][col] = 0;
        }
        
    }
}

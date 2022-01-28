/*Leetcode 73
->Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
->You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */

 class Solution {
    public void setZeroes(int[][] matrix) {
        boolean colZero=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(j==0) colZero=true;
                    else{
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                }
            }
        }
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>0;j--){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
            if(colZero) matrix[i][0]=0;
        }
    }
}
/*
    ->Use the first row and first column of each index as an marker insted of using additonal space
    ->Since the(0,0) acts as a marker to both 0th row and 0th col we use it to mark the 0th row and use an additional variable to mark the 0th col.
    -> rest if the cell independent markers eg (0,1) marks the 1st col ans th 1st row is marked by (1,0)
 */
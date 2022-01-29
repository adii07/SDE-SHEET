/** Leetcode 48
Rotate Image by 90 degree
Problem Statement: Given a matrix, your task is to rotate the matrix by 90 degrees.

Example 1:
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.

Example 2:
Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix
 */

 class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //column reversing
        for(int i=0;i<n;i++){
            int up=0;
            int down=n-1;
            while(up<down){
                int temp=matrix[up][i];
                matrix[up][i]=matrix[down][i];
                matrix[down][i]=temp;
                up++;
                down--;
            }
        }
        //row reversing
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}

/**
->take the transpose of the matrix, swap column wise
->then reverse the matrix,swap row wise
 */
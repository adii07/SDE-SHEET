/**Leetcode 37
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:
->Each of the digits 1-9 must occur exactly once in each row.
->Each of the digits 1-9 must occur exactly once in each column.
->Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
->The '.' character indicates empty cells.

*/

class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
    
    public boolean helper(char[][] board,int row,int col){
        if(row==9){
            return true;
        }
        if(col==9) return helper(board,row+1,0);
        if(board[row][col]!='.') return helper(board,row,col+1);
        
        for(char i='1';i<='9';i++){
            if(isSafe(board,row,col,i)){
                board[row][col]=i;
                if(helper(board,row,col+1)) return true;
                else board[row][col]='.';
            }
        }
        
        return false;
    }
    
    public boolean isSafe(char[][] board,int row,int col,char num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num || board[i][col]==num) return false;
        }
        int x=(row/3)*3;
        int y=(col/3)*3;
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j]==num)return false;
            }
        }
        return true;
    }
}
/**Leetcode 51 - N queens
*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
*Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
*Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
*/

class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        int[][] board=new int[n][n];
        ans=new ArrayList<>();
        helper(n,0,board);
        return ans;
    }
    
    public void helper(int n,int row,int[][] board){
        if(row==n){
            addToList(board);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(board,row,i)){
                board[row][i]=1;
                helper(n,row+1,board);
                board[row][i]=0;
            }
            
        }
    }
    public void addToList(int[][] board){
        List<String> subans=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<board.length;j++){
                sb.append(board[i][j]==1?"Q":".");
            }
            subans.add(sb.toString());
        }
        ans.add(subans);
    }
    
    public boolean isSafe(int[][] board,int row,int col){
        int n=board.length;
        for(int i=row;i>=0;i--){
            if(board[i][col]==1) return false;
        }
        
        for(int i=col;i>=0;i--){
            if(board[row][i]==1) return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1) return false;
        }
        for(int i=row,j=col;i>=0 && j<n;i--,j++){
            if(board[i][j]==1) return false;
        }        
        return true;
    }
}
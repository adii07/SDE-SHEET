/**Rotting Oranges
You are given an m x n grid where each cell can have one of three values:
-0 representing an empty cell,
-1 representing a fresh orange, or
-2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1. 
Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.*/

/**Solution 1: BFS 
->Add all the rotten oranges in a queue
->Count the fresh oranges
->if count of fresh oranges is zero then return zero(EDGE CASE)
->while traveling the queue(to convert the oranges) count the total oranges converted and increment time in each cycle
->if the count of total oranges converted and the fresh oranges is the same return the time else all the oranges are yet not rotten so return -1*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)q.add(new Pair(i,j));
                else if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int minutes=-1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Pair top=q.remove();
                if(top.x+1<m && grid[top.x+1][top.y]==1){
                    grid[top.x+1][top.y]=2; q.add(new Pair(top.x+1,top.y)); fresh--;}
                if(top.x-1>=0 && grid[top.x-1][top.y]==1){
                    grid[top.x-1][top.y]=2;q.add(new Pair(top.x-1,top.y)); fresh--;}
                if(top.y+1<n && grid[top.x][top.y+1]==1){ 
                    grid[top.x][top.y+1]=2;q.add(new Pair(top.x,top.y+1)); fresh--;}
                if(top.y-1>=0 && grid[top.x][top.y-1]==1){ 
                    grid[top.x][top.y-1]=2;q.add(new Pair(top.x,top.y-1)); fresh--;}
            }
            minutes++;
        }
        
        return fresh==0?minutes:-1;
    }
}
class Pair{
    int x;int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

/**Solution 2: DFS */

class Solution {
     public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
            }
        }
        
        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }
        
        return minutes - 2;
    }
    
    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        if(i < 0 || i >= grid.length /* out of bounds */
          || j < 0 || j >= grid[0].length /* out of bounds */
          || grid[i][j] == 0 /* empty cell */
          || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
          ) return;
        else {
            grid[i][j] = minutes;
            rotAdjacent(grid, i - 1, j, minutes + 1);
            rotAdjacent(grid, i + 1, j, minutes + 1);
            rotAdjacent(grid, i, j - 1, minutes + 1);
            rotAdjacent(grid, i, j + 1, minutes + 1);
        }
    }
}
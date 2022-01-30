/**leetcode 74
Problem Statement: Given an m*n 2D matrix and an integer, write a program to find if the given integer exists in the matrix.

Given matrix has the following properties:
    ->Integers in each row are sorted from left to right.
    ->The first integer of each row is greater than the last integer of the previous row
Example 1:
Input: matrix = 
[[1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]], 
target = 3
Output: true
Explanation: As the given integer(target) exists in the given 2D matrix, the function has returned true.

Example 2:
Input: matrix = 
[[1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]], 
target = 13
Output: false
Explanation: As the given integer(target) does not exist in the given 2D matrix, the function has returned false.
 */
 /**Solution 1: brute force
 -> traverse the array and rturn true if the element is found.(2 for loops)
 TC=O(m*n)
  */
/** solution 2: binary search
->first search for the targetRow using binary search, if -1 return false else continue;
->now apply binary search on the targetRow and if found return true else return false.
Time complexity: O(log(m*n)) 
 */

 class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int targetRow=binarySearch(matrix,target,0,m);
        if(targetRow==-1) return false;
        int start=0,end=n;
        while(start<=end){
            int mid=start+((end-start)/2);            
            if(target==matrix[targetRow][mid]) return true;
            else if(matrix[targetRow][mid]<target) start=mid+1;
            else end=mid-1;
        }
        return false;
    }
    
    public int binarySearch(int[][] matrix,int target,int start,int end){
        int n=matrix[0].length-1;
        if(start>end) return -1;
        if(start==end) return end;
        int mid=start+((end-start)/2);
        if(matrix[mid][n]==target) return mid;
        else if(matrix[mid][n]<target) return binarySearch(matrix,target,mid+1,end);
        else return binarySearch(matrix,target,0,mid);
    }
}
/**
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa". */

/**Solution1 : find all substring and check the count
    TC:O(n^3) */

/**Solution 2: Dynamic Programming
->Declare a 2-D array with length equal to the string length
->the cell at i,j represents if the substring starting form i till j is a plindrome substring
->For a String to be palindrome it's starting and ending char should same and the string in between should be palindrone.
->Therefore to check for the given cell we check the starting and ending char and then move a row below(move the starting index by 1) and a col back(skip the last char).
-> we move diagonally. 

TC:O(n*(n+1)/2)*/
class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int count=0;
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                if(gap==0){
                    dp[i][j]=true;
                }else if(gap==1){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j))&&(dp[i+1][j-1]);
                }
                if(dp[i][j]) count++;
            }
        }
        return count;
    }
}
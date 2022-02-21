/**
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb" */

class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        String ans="";
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                if(gap==0){
                    dp[i][j]=true;
                }else if(gap==1){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j))&&(dp[i+1][j-1]);
                }
                if(dp[i][j]){
                    String subString =s.substring(i,j+1);
                    if(subString.length()>ans.length()) ans=subString;
                }
            }
        }
        return ans;
    }
}   
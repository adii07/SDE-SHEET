/**Leetcode 44
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:
    0 <= s.length, p.length <= 2000
    s contains only lowercase English letters.
    p contains only lowercase English letters, '?' or '*'.
*/


/**Solution 1: Recursion->TLE */
class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s,p,s.length()-1,p.length()-1);
    }
    
    public boolean helper(String s,String p,int i,int j){
        if(j<0){
            if(i<0) return true;
            else return false;
        }
        if(i<0){
            while(j>=0 && p.charAt(j)=='*') j--;
            if(j==-1) return true;
            else return false;
        }
        
        char S=s.charAt(i);
        char P=p.charAt(j);
        if(P==S || P=='?') return helper(s,p,i-1,j-1);
        else if(P=='*') return helper(s,p,i,j-1) || helper(s,p,i-1,j);
        else return false;
    }
}

/**Solution 2:Memoization */
class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()+1][p.length()+1];
        return helper(s,p,s.length(),p.length(),dp);    
    }
    
    public boolean helper(String s,String p,int i,int j,int[][] dp){
        if(j==0 && i==0) return true;
        if(j==0 && i>0) return false;
        if(i==0 && j>0){
            for(int idx=1;idx<=j;idx++){
                if(p.charAt(idx-1)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=0) return dp[i][j]==1?true:false;
        char S=s.charAt(i-1);
        char P=p.charAt(j-1);
        boolean val=false;
        if(P==S || P=='?') val= helper(s,p,i-1,j-1,dp);
        else if(P=='*') val= helper(s,p,i,j-1,dp) || helper(s,p,i-1,j,dp);
        dp[i][j]=val?1:-1;
        return val;
    }
}

/**Solution 3: Tabulation */
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        
        dp[0][0]=true;
        
        for(int i=1;i<=s.length();i++) dp[i][0]=false;
        
        for(int i=1;i<=p.length();i++){
            boolean flag=true;
            for(int idx=1;idx<=i;idx++){
                if(p.charAt(idx-1)!='*') {
                    flag= false; break;
                }
            }
            dp[0][i]=flag;
        }
        
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                char S=s.charAt(i-1);
                char P=p.charAt(j-1);
                boolean val=false;
                if(P==S || P=='?') val= dp[i-1][j-1];
                else if(P=='*') val= dp[i][j-1] || dp[i-1][j];
                else val=false;
                dp[i][j]=val;
            }
        }
        return dp[s.length()][p.length()];    
    }
}
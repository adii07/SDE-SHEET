/**Count All Valid Pickup and Delivery Options

*Given n orders, each order consist in pickup and delivery services. 
*Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 
*Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.

Example 2:
Input: n = 2
Output: 6
Explanation: All possible orders: 
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.

Example 3:
Input: n = 3
Output: 90

https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
*/

/**Memoization*/
class Solution {
    final int MOD=1000000007;
    public int countOrders(int n) {
        long[][] dp=new long[n+1][n+1];
        return (int)helper(n,n,dp);
    }
    
    public long helper(int unpicked,int undelivered,long[][] dp){
        if(unpicked==0 && undelivered==0) return 1;
        if(unpicked<0 || undelivered<0 || undelivered<unpicked) return 0;
        if(dp[unpicked][undelivered]!=0) return dp[unpicked][undelivered];
        long pick=(unpicked*helper(unpicked-1,undelivered,dp))%MOD;
        long drop=((undelivered-unpicked)*helper(unpicked,undelivered-1,dp))%MOD;
        return dp[unpicked][undelivered]=(pick+drop)%MOD; 
    }
}
/**Tabulation*/
class Solution {
    final int MOD=1000000007;
    public int countOrders(int n) {
        long[][] dp=new long[n+1][n+1];
        for(int unpicked=0;unpicked<=n;unpicked++){
            for(int undelivered=0;undelivered<=n;undelivered++){
                if(unpicked==0 && undelivered==0){
                    dp[unpicked][undelivered]=1;
                    continue;
                }
                if(unpicked>0){
                    dp[unpicked][undelivered]=(unpicked*dp[unpicked-1][undelivered])%MOD;
                }
                if(undelivered>unpicked){
                    dp[unpicked][undelivered]+=((undelivered-unpicked)*dp[unpicked][undelivered-1])%MOD;
                }
                dp[unpicked][undelivered]%=MOD;
            }
        }
        return (int)dp[n][n];
    }
}
/**Space optimized Tabulation*/
class Solution {
    final int MOD=1000000007;
    public int countOrders(int n) {
        long[] prev=new long[n+1];
        long[] curr=new long[n+1];
        for(int unpicked=0;unpicked<=n;unpicked++){
            for(int undelivered=0;undelivered<=n;undelivered++){
                if(unpicked==0 && undelivered==0){
                    curr[undelivered]=1;
                    continue;
                }
                if(unpicked>0){
                    curr[undelivered]=(unpicked*prev[undelivered])%MOD;
                }
                if(undelivered>unpicked){
                    curr[undelivered]+=((undelivered-unpicked)*curr[undelivered-1])%MOD;
                }
                curr[undelivered]%=MOD;
            }
            prev=curr;
        }
        return (int)prev[n];
    }
}

/**Space optimized Tabulation*/
class Solution {
    final int MOD=1000000007;
    public int countOrders(int n) {
        long[] prev=new long[n+1];
        for(int unpicked=0;unpicked<=n;unpicked++){
            for(int undelivered=0;undelivered<=n;undelivered++){
                if(unpicked==0 && undelivered==0){
                    prev[undelivered]=1;
                    continue;
                }
                if(unpicked>0){
                    prev[undelivered]=(unpicked*prev[undelivered])%MOD;
                }
                if(undelivered>unpicked){
                    prev[undelivered]+=((undelivered-unpicked)*prev[undelivered-1])%MOD;
                }
                prev[undelivered]%=MOD;
            }
        }
        return (int)prev[n];
    }
}

/**Permutations
Thus, we can come to the formula that, to place NN pickups we have N!N! ways,
and to place the NN deliveries we have 1 * 3 * 5 * ....  (2N−1) ways.

So, total ways to arrange all pickups and deliveries are, N! *(2N−1) .*/
class Solution {
    final int MOD=1000000007;
    public int countOrders(int n) {
        long ans=1;
        for(int i=1;i<=n;i++){
            ans=ans*i;
            ans=ans*(2*i-1);
            ans%=MOD;
        }
        return (int)ans;
    }
}
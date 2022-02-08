/**
*Dora, the explorer, visits India and decides to try the famous Indian food. 
*However, the restaurant accepts only Indian currency i.e. [1, 2, 5, 10, 20, 50, 100, 500, 1000] valued coins.
*So, Dora goes to a bank that has an infinite supply of each of the denominations to make a change for a given ‘Amount’ of money. 
*As a cashier at the bank, your task is to provide Dora the minimum number of coins that add up to the given ‘Amount’.
For Example
For Amount = 70, the minimum number of coins required is 2 i.e an Rs. 50 coin and a Rs. 20 coin. 
*/

/**
Solution 1: Sorting 
-> Sort the coins in decending order.
-> If the total money required is greater than the coin at the top, take the coin and subtract it from the total.
-> If the coin at the top is greater than the total remove the coins till the coin at the top is smaller than the total.
-> Repeat this till total isnot zero. */

public class Solution
{
	public static int findMinimumCoins(int amount)
    {
         int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int i=coins.length-1;
        int ans=0;
        while(amount!=0){
            while(coins[i]<=amount){
                amount-=coins[i];
                ans++;
            }
            i--;
        }
        return ans;
    }
}

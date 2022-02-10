/**Nth Root of a Number using Binary Search
Problem Statement: Given two numbers N and M, find the Nth root of M.

The nth root of a number M is defined as a number X when raised to the power N equals M.

Example 1:
Input: N=3 M=27
Output: 3
Explanation: The cube root of 27 is 3.

Example 2:
Input: N=2 M=16
Output: 4
Explanation: The square root of 16 is 4

Example 3:
Input: N=5 M=243
Output: 3
Explaination: The 5th root of 243 is 3 */

private static double multiply(double number, int n) {
        double ans = 1.0;
        for(int i = 1;i<=n;i++) {
            ans = ans * number;
        }
        return ans; 
    }
    private static void getNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-6; 
        
        while((high - low) > eps) {
            double mid = (low + high) / 2.0; 
            if(multiply(mid, n) < m) {
                low = mid; 
            }
            else {
                high = mid; 
            }
        }
        
        System.out.println(n+"th root of "+m+" is "+low);  
        
    }
/**Binary Search

Nth root of a number M is defined as a number X when raised to the power N equals to M.

Approach: In order to find the Nth root of any given integer we are gonna use Binary Search.

Step 1: Take low and high. Low will be equal to 1 and high will be M. We will take the mid of low and high such that the searching space is reduced using low + high / 2.
Step 2: Make a separate function to multiply mid N times.
Step 3: Run the while loop till (high – low > eps). Take eps as 1e-6, since we have to find answers to 6 decimal places.
Step 4:  If the mid is less than M, then we will reduce search space to low and mid. Else, if it is greater than M then search space will be reduced to mid and high.
Step 5: After the loop breaks we will have our answer as low or high.

 */
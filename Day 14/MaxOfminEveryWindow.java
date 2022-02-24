/** Maximum of minimum for every window size
Problem Statement
You are given an array of ‘N’ integers, you need to find the maximum of minimum for every window size. The size of the window should vary from 1 to ‘N’ only.
For example:
ARR = [1,2,3,4]
Minimums of window size 1 = min(1), min(2), min(3), min(4) = 1,2,3,4
Maximum among (1,2,3,4)  is 4

Minimums of window size 2 = min(1,2), min(2,3),   min(3,4) = 1,2,3
Maximum among (1,2,3) is 3

Minimums of window size 3 = min(1,2,3), min(2,3,4) = 1,2
Maximum among (1,2) is 2

Minimums of window size 4 = min(1,2,3,4) = 1
Maximum among them is 1
The output array should be [4,3,2,1]. */


/**Solution 1: Using stack to find the max of min for each window->>>>>>>>>>>.TLE */
import java.util.*;
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] ans=new int[n];
        for(int i=1;i<=n;i++){
            ans[i-1]=helper(a,i);
        }
        return ans;
    }
    
    public static int helper(int[] a,int k){
        PriorityQueue<Pair> pq=new PriorityQueue<>((f,g)->{return f.val-g.val;});
        int start=0;
        int end=0;
        int ans=Integer.MIN_VALUE;
        while(k-->1)pq.add(new Pair(a[end],end++));
        while(end<a.length){
            while(!pq.isEmpty() && pq.peek().idx<start)pq.remove();
            pq.add(new Pair(a[end],end++));
            start++;
            ans=Math.max(ans,pq.peek().val);
        }
        return ans;
    }
}

class Pair{
    int val;
    int idx;
    Pair(int val,int idx){
        this.val=val;
        this.idx=idx;
    }
}
/**Leetcode 56
Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

Example 1: 
Input: intervals=[[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6] intervals.
 */
 class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }else{
                List<Integer> temp=new ArrayList<>();
                temp.add(start);temp.add(end);
                list.add(temp);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(start);temp.add(end);
        list.add(temp);
        int[][] ans=new int[list.size()][2];
        for(int i=0;i<ans.length;i++){
            ans[i][0]=list.get(i).get(0);
            ans[i][1]=list.get(i).get(1);
        }
        return ans;
    }
}
/**
->Sort the array on the basis of the first/starting value.
->If the end value of the i-1 point is greater than the start value ifith point then merge
    (i.e. the start is same(that of the i-1 point),but the end now is the max of the last points of i&i-1)
->If the end value i-1 is samller than the start of the starting value of ith ,
    then add the current start and end to the ans and update start as the start if ith and end as end point of i.
->When the loop ends add the start and end to the ans and return.    
 */
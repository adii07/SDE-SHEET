/**
N meetings in one room
Problem Statement: 
*There is one meeting room in a firm. 
*You are given two arrays, start and end each of size N.For an index ‘i’, 
    start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. 
*Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. 
*Print the order in which these meetings will be performed.

Example:
Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
Output: 1 2 4 5
 */

/**Solution 1: sorting
*Simillar to nMeeting

->Sort the array on the end time
->the meeitng with the smallest end time is on the top
->for a meeting to occur its start time has to be greater than the end time prev meeting,ie, it can only start once the prev meeting has ended */
import java.util.*;
import java.io.*;
public class Solution {
    public static int maximumActivities(List<Integer> startList, List<Integer> endList) {
        //Write your code here
        int n=startList.size();
        PriorityQueue<Activity> pq=new PriorityQueue<>((a,b)->{
            return a.end==b.end?a.activity-b.activity:a.end-b.end;
        });
        for(int i=0;i<n;i++){
            pq.add(new Activity(i+1,startList.get(i),endList.get(i)));
        }
        int ans=1;
        Activity ending=pq.remove();
        while(!pq.isEmpty()){
            Activity top=pq.remove();
            if(top.start>=ending.end){
                ans++;
                ending=top;
            }
        }
        return ans;
    }
}
class Activity{
    int activity;
    int start;
    int end;
    Activity(int activity,int start,int end){
        this.activity=activity;
        this.start=start;
        this.end=end;
    }
}

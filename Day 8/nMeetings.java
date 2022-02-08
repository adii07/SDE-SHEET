/**N meetings in one room 
Problem Statement: 
There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’, 
start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. 
Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. 
Print the order in which these meetings will be performed.

Sample Input 1:
2
6
1 3 0 5 8 5
2 4 6 7 9 9
3
1 1 1
4 5 9
Sample Output 1:
1 2 4 5
1

Sample Input 2:
2
5
0 7 1 4 8
2 9 5 9 10
3
1 2 3
4 4 4
Sample Output 2:
1 2 
1
*/

/**Solution:(Greedy Algorithm)
->Sort the meeting on the basis of their ending time.
->if the ending time collides keep the meeting with the smaller number in the top
->the 1st meeting will always occur, therefore add it to the ans and set it as prev
->now for every meeting check if it's starting time is greater than the ending time of the prev meeting
    ->IF YES, then add the meeting to the ans and set it as the prev meeting
    ->ELSE continue without doing anything.
->return the ans list containing the valid meeting numbers.*/
import java.util.*;
public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) { 
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->{
            return a.end==b.end?a.meetingNumber-b.meetingNumber:a.end-b.end;
        });
        for(int i=0;i<start.length;i++){
            q.add(new Pair(start[i],end[i],i+1));
        }
        if(q.isEmpty())return ans;
        Pair prev=q.remove();
        ans.add(prev.meetingNumber);
        while(!q.isEmpty()){
            Pair top=q.remove();
            if(top.start>prev.end){
                ans.add(top.meetingNumber);
                prev=top;
            }
        }
        return ans;
    }
}
class Pair{
    int start;
    int end;
    int meetingNumber;
    Pair(int start,int end,int meetingNumber){
        this.start=start;
        this.end=end;
        this.meetingNumber=meetingNumber;
    }
}

/**Initial Thought Process:-
*Say if you have two meetings, one which gets over early and another which gets over late. 
*Which one should we choose?  
*If our meeting lasts longer the room stays occupied and we lose our time. On the other hand, if we choose a meeting that finishes early we can accommodate more meetings. 
*Hence we should choose meetings that end early and utilize the remaining time for more meetings. 
*/
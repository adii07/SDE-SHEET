/**Minimum Number of Platforms
Problem Statement: 
*We are given two arrays that represent the arrival and departure times of trains that stop at the platform. 
*We need to find the minimum number of platforms needed at the railway station so that no train has to wait.

Examples 1:
Input: N=6, 
arr[] = {9:00, 9:45, 9:55, 11:00, 15:00, 18:00} 
dep[] = {9:20, 12:00, 11:30, 11:50, 19:00, 20:00}
Output:3
Explanation: There are at-most three trains at a time. 
The train at 11:00 arrived but the trains which had arrived at 9:45 and 9:55 have still not departed. So, we need at least three platforms here.

Example 2:
Input Format: N=2, 
arr[]={10:20,12:00}
dep[]={10:50,12:30}
Output: 1
Explanation: Before the arrival of the new train, the earlier train already departed. So, we don’t require multiple platforms.

 */

/**Solution 1:Use 2 for loops to calculate all the possible ans */

/**Solution 2:PriorityQueue(TLE)
*Make a list of pair of train(arrivaltime and departuretime)
*sort the list on the basis of arrivaltime
*now use a priority queue to store the departure time of each train
*if the current train has arrival time greater than the departure time on top of the queue remove the top and add the current trains departure time 
    this is because when the current train arrives the previous would have already left so we donot need to increment the platforms
*else if the current arrival time is less than the prev departure time increment the platform as the previous train is yet to leave
*return the q size at the end as that is the number of train timming that collide and need different platoform
*/
import java.util.*;

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        List<Pair> trains=new ArrayList<>();
        for(int i=0;i<n;i++){
            trains.add(new Pair(at[i],dt[i]));
        }
        Collections.sort(trains,(a,b)->{
            return a.arrival-b.arrival;
        });
        PriorityQueue<Integer> q=new PriorityQueue<>();
        q.add(trains.get(0).departure);
        for(int i=1;i<n;i++){
            int arr=trains.get(i).arrival;
            int dep=trains.get(i).departure;
            if(arr>q.peek()){
                q.remove();
                q.add(dep);
            }else{
                q.add(dep);
            }
        }
        return q.size();
    }
}
class Pair{
    int arrival;
    int departure;
    Pair(int arrival,int departure){
        this.arrival=arrival;
        this.departure=departure;
    }
}

/**Solution 3:Sorting 
Intuition: 
*At first we need to sort both the arrays. 
*When the events will be sorted, it will be easy to track the count of trains that have arrived but not departed yet. 
*Total platforms needed at one time can be found by taking the difference of arrivals and departures at that time and the maximum value of all times will be the final answer.

Algo:
->At first we need to sort both the arrays. When the events will be sorted, it will be easy to track the count of trains that have arrived but not departed yet. 
->Total platforms needed at one time can be found by taking the difference of arrivals and departures at that time and the maximum value of all times will be the final answer.
*/
import java.util.Arrays;
public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        Arrays.sort(at);
        Arrays.sort(dt);
        int ans=1;
        int platform=1;
        int arrivalTime=1;
        int departureTime=0;
        while(arrivalTime<n && departureTime<n){
            if(at[arrivalTime]<=dt[departureTime]){
                platform++;
                arrivalTime++;
            }else{
                platform--;
                departureTime++;
            }
            ans=Math.max(ans,platform);
        }
        return ans;
    }
}
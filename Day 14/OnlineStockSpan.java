/**Online Stock Span
-Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
-The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.
    For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
-Implement the StockSpanner class:
    StockSpanner() Initializes the object of the class.
    int next(int price) Returns the span of the stock's price given that today's price is price.
Example 1:
Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 */

/**Solution 1: 2 Stacks-------->TLE */

 class StockSpanner {
    Stack<Integer> st;
    Stack<Integer> helper;
    public StockSpanner() {
        st=new Stack<>();
        helper=new Stack<>();
    }
    
    public int next(int price) {
        int count=1;
        while(!st.isEmpty() && st.peek()<=price){
            helper.push(st.pop());count++;
        }
        while(!helper.isEmpty()) st.push(helper.pop());
        st.push(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

 /**Solution 2: Stack and pair
 ->Every stack element has its price along it's span ->>>>Step0
 ->by doing this we can remove the smaller stock and it's count would be preserved in the larger stock ->>>>Step1*/
 class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int ans=1;
       while(!st.isEmpty() && st.peek().stockPrice<=price){
            ans+=st.pop().stockSpan;//->>>>Step1
        }
        st.push(new Pair(price,ans));//->>>>Step0
        return ans;
    }
}
class Pair{
    int stockPrice;
    int stockSpan;
    Pair(int stockPrice,int stockSpan){
        this.stockPrice=stockPrice;
        this.stockSpan=stockSpan;
    }
}
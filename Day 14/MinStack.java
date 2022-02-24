/**Implement Min Stack */



/**Solution 1: Stack and Pair(val,min)
-> each stack element contains it's value and the min element present in the stack, including the element */
class MinStack {
    Stack<Pair> st;
    
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }else{
            int min=Math.min(st.peek().min,val);
            st.push(new Pair(val,min));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

class Pair{
    int val;
    int min;
    Pair(int val,int min){
        this.val=val;
        this.min=min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
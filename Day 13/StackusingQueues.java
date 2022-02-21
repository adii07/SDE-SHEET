/**Implement Stack using Queues
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:
-void push(int x) Pushes element x to the top of the stack.
-int pop() Removes the element on the top of the stack and returns it.
-int top() Returns the element on the top of the stack.
-boolean empty() Returns true if the stack is empty, false otherwise.

Notes:
-You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
-Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations. */

class MyStack {
    Queue<Integer> q1;Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        if(q1.isEmpty() && q2.isEmpty())q1.add(x);
        else if(q1.isEmpty()) q2.add(x);
        else q1.add(x);
    }
    
    public int pop() {
        if(q2.isEmpty()){
            while(q1.size()>1){
                q2.add(q1.remove());
            }
            return q1.remove();
        }else{
            while(q2.size()>1){
                q1.add(q2.remove());
            }
            return q2.remove();
        }
    }
    
    public int top() {
        if(q2.isEmpty()){
            while(q1.size()>1){
                q2.add(q1.remove());
            }
            int val=q1.remove();
            q2.add(val);
            return val;
        }else{
            while(q2.size()>1){
                q1.add(q2.remove());
            }
            int val=q2.remove();
            q1.add(val);
            return val;
        }
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
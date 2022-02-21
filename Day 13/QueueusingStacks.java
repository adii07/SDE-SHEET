/** Implement Queue using Stacks
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:
-void push(int x) Pushes element x to the back of the queue.
-int pop() Removes the element from the front of the queue and returns it.
-int peek() Returns the element at the front of the queue.
-boolean empty() Returns true if the queue is empty, false otherwise.

Notes:
-You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
-Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations. */
class MyQueue {
    int first;
    Stack<Integer> a;
    Stack<Integer> b;
        
    public MyQueue() {
        a=new Stack<>();
        b=new Stack<>();
        first=0;
    }
    
    public void push(int x) {
        if(a.isEmpty() && b.isEmpty()) first=x;
        a.push(x);
    }
    
    public int pop() {
        int ans=0;
        if(b.isEmpty()){
           while(!a.isEmpty()){
               b.push(a.pop());
           }
        }
        ans=b.pop();
        if(!b.isEmpty()){
          first=b.peek();  
        } else{
            while(!a.isEmpty()){
               b.push(a.pop());
           }
            if(!b.isEmpty()) first=b.peek();
        }
        return ans;
    }
    
    public int peek() {
        return first;
    }
    
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
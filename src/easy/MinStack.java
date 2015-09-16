package easy;

import java.util.Stack;

//解法1
class MinStack {	
	class StackNode{
        int curr_min;
        int val;
        StackNode next;
        StackNode(int x){
            this.val = x;
        }
    }
    StackNode head;
    int size;
    
    public void push(int x) {
        if(size==0){
            head = new StackNode(x);
            head.curr_min = x;
        }else{
            StackNode t = new StackNode(x);
            t.next = head;
            t.curr_min = Math.min(x,head.curr_min);
            head = t;
        }
        size++;
    }

    public void pop() {
        if(size==0) System.err.println("Empty Stack!");
        else{
            StackNode t = head;
            head = head.next;
            t.next = null;
            size--;
        }
    }

    public int top() {
        if(size==0) return Integer.MAX_VALUE;
        else return head.val;
    }

    public int getMin() {
        if(size==0) return Integer.MAX_VALUE;
        else return head.curr_min;
    }
}
//解法2 ，用两个stack，维护一个minStack
class MinStack2 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()) minStack.push(x);
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

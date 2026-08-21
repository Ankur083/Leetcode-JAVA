class MinStack {
    Stack<Integer>s;
    PriorityQueue<Integer>pq;

    public MinStack() {
        s = new Stack();
        pq = new PriorityQueue<>();
    }
    
    public void push(int value) {
        s.push(value);
        pq.add(value);
    }
    
    public void pop() {
        int remove = s.pop();
        pq.remove(remove);
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
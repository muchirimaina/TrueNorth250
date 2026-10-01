class MinStack {
    class Element{
        int val;
        int min;
        Element(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    Deque<Element> stack; 
    public MinStack() {
       stack = new ArrayDeque<>();
    } 
    public void push(int val) {
        int min = stack.isEmpty()?val:Math.min(val,stack.peek().min);
        stack.push(new Element(val,min));   
    } 
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek().val;
    }
    public int getMin() {
        return stack.peek().min;
    }
}


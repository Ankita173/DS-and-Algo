package org.example.neetcode.stack;

public class ImplementStack {
    Node stack;

    public void push(int val) {
        if (stack == null) {
            stack = new Node(val, null, val);
        } else {
            stack = new Node(val, stack, stack.min > val ? val : stack.min);
        }
    }

    public void pop() {
        stack = stack.next;
    }

    public int top() {
        return stack.value;
    }

    public int getMin() {
        return stack.min;
    }

    public static void main(String[] args) {
        ImplementStack s = new ImplementStack();

        s.push(4);
        s.push(3);
        s.push(1);
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());

    }
}

class Node {
    int value;
    Node next;
    int min;
    Node(int value, Node next, int min) {
        this.value = value;
        this.next = next;
        this.min = min;
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


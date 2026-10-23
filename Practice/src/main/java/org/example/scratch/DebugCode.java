package org.example.scratch;
public class DebugCode {

    //Stack<MinNode>
    public static void main(String[] args) {
        DebugCode node = new DebugCode();
        node.push(-1);
        node.push(0);
        node.push(-3);
        System.out.println(node.getMin());
        System.out.println(node.top());
        node.pop();
        System.out.println(node.top());
        System.out.println(node.getMin());
    }
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
}

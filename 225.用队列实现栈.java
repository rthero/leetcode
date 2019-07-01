import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (57.45%)
 * Likes:    52
 * Dislikes: 0
 * Total Accepted:    12.1K
 * Total Submissions: 20.4K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * 使用队列实现栈的下列操作：
 * 
 * 
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 
 * 
 * 注意:
 * 
 * 
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty
 * 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * 
 * 
 */
//基本题目，反之同样可以使用两个栈实现一个队列
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
            for (Integer var : queue2) {
                queue1.add(queue2.poll());
            }
        } else {
            queue2.add(x);
            for (Integer var : queue1) {
                queue2.add(queue1.poll());
            }

        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.isEmpty()) {
            return queue2.poll();
        } else {
            return queue1.poll();
        }

    }

    /** Get the top element. */
    public int top() {
        if (queue1.isEmpty()) {
            return queue2.peek();
        } else {
            return queue1.peek();
        }

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

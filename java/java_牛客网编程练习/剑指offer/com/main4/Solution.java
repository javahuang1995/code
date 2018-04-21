package com.main4;
import java.util.Stack;

/**
 * 题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author Administrator 黄宁
 * 2018-4-21下午06:20:24
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	// 先判断弹出栈是否为空，如果为空就将插入栈的所有数据放到弹出栈，
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }

        // 如果弹出栈中还没有数据就抛出异常
        if (stack2.isEmpty()) {
            throw new RuntimeException("No more element.");
        }

        // 返回弹出栈的栈顶元素，对应的就是队首元素。
        return stack2.pop();
    }
}
package com.main4;
import java.util.Stack;

/**
 * ��Ŀ����
������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * @author Administrator ����
 * 2018-4-21����06:20:24
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	// ���жϵ���ջ�Ƿ�Ϊ�գ����Ϊ�վͽ�����ջ���������ݷŵ�����ջ��
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }

        // �������ջ�л�û�����ݾ��׳��쳣
        if (stack2.isEmpty()) {
            throw new RuntimeException("No more element.");
        }

        // ���ص���ջ��ջ��Ԫ�أ���Ӧ�ľ��Ƕ���Ԫ�ء�
        return stack2.pop();
    }
}
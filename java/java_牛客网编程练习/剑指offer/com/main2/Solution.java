package com.main2;

import java.util.Stack;

/**
 * 
 * @author Administrator ����
 * 2018-4-21����02:13:36
 */
public class Solution {

    /**
     * ������
     */
    public static class ListNode {
        int val; // ����ֵ
        ListNode nxt; // ��һ�����
    }
    
    /**
     * ����������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
     * ʹ��ջ�ķ�ʽ����
     *
     * @param root ����ͷ���
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (root != null) {
            stack.push(root);//�Ȱ�Listһ��һ���ŵ�ջ����
            root = root.nxt;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val + " ");//Ȼ���ٵ�����
        }
    }

    /**
     * ����������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
     * ʹ��ջ�ķ�ʽ����
     *
     * @param root ����ͷ���
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.nxt);
            System.out.print(root.val + " ");
        }
    }
    
    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.nxt = new ListNode();
        root.nxt.val = 2;
        root.nxt.nxt = new ListNode();
        root.nxt.nxt.val = 3;
        root.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.val = 4;
        root.nxt.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.nxt.val = 5;

        printListInverselyUsingIteration(root);
        System.out.println();
        printListInverselyUsingRecursion(root);
    }
    
    
    
}

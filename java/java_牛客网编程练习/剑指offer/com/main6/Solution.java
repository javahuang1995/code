package com.main6;
/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
n<=39
����õݹ��㷨������򵥵�
n=0, f(n)=0
n=1,f(n)=1
f(n)=f(n-1)+f(n-2) n>1
 * @author Administrator ����
 * 2018-4-22����10:01:35
 * ����ʱ�䣺1304ms
ռ���ڴ棺8608k
 */
public class Solution {
    public int Fibonacci(int n) {
         if(n==0)	{
        	 return 0;
         }else if(n==1){
        	 return 1;
         }else{
        	 return Fibonacci(n-1)+Fibonacci(n-2);
         }
    }
    
    /**
     * ����ⷨ�ٶȸ���
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        int a=1,b=1,c=0;
        if(n<0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{
            for (int i=3;i<=n;i++){
                c=a+b;//���Ǽ���ǰ��2�����ĺ�
                //����ǰ��2���� 1,1,2,3,5,8,13,21
                b=a;
                a=c;
            }
            return c;
        }
    }
    
    /**
     * a,b��̫����⣬д��������������������
     * дһ������������n����쳲�������Fibonacci) ���еĵ�n��
     * @param n Fibonacci��������
     * @return ��n��Ľ��
     */
    public static long fibonacci(int n) {

        // ���������������ʱ�򷵻�0
        if (n <= 0) {
            return 0;
        }

        // ����1����2��ʱ�򷵻�1
        if (n == 1 || n == 2) {
            return 1;
        }

        // ��¼ǰ��������n-2������Fibonacci����ֵ
        long prePre = 1;
        // ��¼ǰ��������n-1������Fibonacci����ֵ
        long pre = 1;
        // ��¼ǰ��������n������Fibonacci����ֵ
        long current = 2;

        // ����n����Fibonacci����ֵ
        for (int i = 3; i <= n ; i++) {
            // ���i����Fibonacci����ֵ
            current = prePre + pre;
            // ���¼�¼�Ľ����prePreԭ�ȼ�¼��i-2��Fibonacci����ֵ
            // ���ڼ�¼��i-1��Fibonacci����ֵ
            prePre = pre;
            // ���¼�¼�Ľ����preԭ�ȼ�¼��i-1��Fibonacci����ֵ
            // ���ڼ�¼��i��Fibonacci����ֵ
            pre = current;
        }

        // ��������Ľ��
        return current;
    }
    
    
}
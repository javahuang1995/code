package com.main6;
/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39
如果用递归算法，是最简单的
n=0, f(n)=0
n=1,f(n)=1
f(n)=f(n-1)+f(n-2) n>1
 * @author Administrator 黄宁
 * 2018-4-22上午10:01:35
 * 运行时间：1304ms
占用内存：8608k
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
     * 这个解法速度更快
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
                c=a+b;//就是计算前面2个数的和
                //更新前面2个数 1,1,2,3,5,8,13,21
                b=a;
                a=c;
            }
            return c;
        }
    }
    
    /**
     * a,b不太好理解，写成这样，代码更容易理解
     * 写一个函数，输入n，求斐波那契（Fibonacci) 数列的第n项
     * @param n Fibonacci数的项数
     * @return 第n项的结果
     */
    public static long fibonacci(int n) {

        // 当输入非正整数的时候返回0
        if (n <= 0) {
            return 0;
        }

        // 输入1或者2的时候返回1
        if (n == 1 || n == 2) {
            return 1;
        }

        // 记录前两个（第n-2个）的Fibonacci数的值
        long prePre = 1;
        // 记录前两个（第n-1个）的Fibonacci数的值
        long pre = 1;
        // 记录前两个（第n个）的Fibonacci数的值
        long current = 2;

        // 求解第n个的Fibonacci数的值
        for (int i = 3; i <= n ; i++) {
            // 求第i个的Fibonacci数的值
            current = prePre + pre;
            // 更新记录的结果，prePre原先记录第i-2个Fibonacci数的值
            // 现在记录第i-1个Fibonacci数的值
            prePre = pre;
            // 更新记录的结果，pre原先记录第i-1个Fibonacci数的值
            // 现在记录第i个Fibonacci数的值
            pre = current;
        }

        // 返回所求的结果
        return current;
    }
    
    
}
package com.main7;
/**
 * 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author Administrator 黄宁
 * 2018-4-22上午10:13:08
 */
public class Solution {
    public int JumpFloor(int target) {
    	  if(target <= 0) return 0;
          if(target == 1) return 1;
          if(target == 2) return 2;
          int one = 1;
          int two = 2;
          int result = 0;
          for(int i = 2; i < target; i++){
              result = one+ two;
              one = two;
              two = result;
          }
          return result;
    }
    
    /**
     * 变态跳台阶题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target == 0) {
            return 0;
        }
         
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
         
        for(int i = 2;i <= target;i++) {
            dp[i] = 0;
            for(int j = 0;j < i;j++) {
                dp[i] += dp[j];
            }
        }
         
        return dp[target];
    }
    
    
    
}
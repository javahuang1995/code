package com.main7;
/**
 * ��Ŀ����
һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * @author Administrator ����
 * 2018-4-22����10:13:08
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
     * ��̬��̨����Ŀ����
һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж���������
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
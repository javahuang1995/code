package com.main1;
/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有
 * 该整数。
 * @author Administrator 黄宁
 * 2018下午12:33:43
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
    	
    	//合法性校验
    	if(array == null || array.length < 1 || array[0].length<1){
    		return false;
    	}
    	int rows = array.length;
    	int cols = array[1].length;
    	int row =0;
    	int col = cols - 1;
    	while(row >=0 && row<rows && col >=0 && col <cols	){
    		if(array[row][col] == target){
    			return true;
    		}else if(array[row][col] > target){
    			col --;
    		}else{
    			row ++;
    		}
    	}
    	return false;
    }
}
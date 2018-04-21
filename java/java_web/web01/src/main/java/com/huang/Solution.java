package com.huang;
public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array.length == 0){
            return false;
        }
        int row = array.length-1;
        int col = 0;
        while(col < array[0].length && row > 0){
            if(target == array[row][col]){
                return true;
            }else if(target > array[row][col]){
                col++;
            }else{
                row--;
            }
        }
        return false;
        
    }
}
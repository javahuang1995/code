package com.main;

import java.util.Scanner;

/**
 * ��Ŀ����
�� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ��ţţ����� n ��ѧ���а���˳��ѡȡ k ��ѧ����Ҫ����������ѧ����λ�ñ�ŵĲ���� d��ʹ���� k ��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���
��������:
ÿ��������� 1 ������������ÿ���������ݵĵ�һ�а���һ������ n (1 <= n <= 50)����ʾѧ���ĸ�������������һ�У����� n ����������˳���ʾÿ��ѧ��������ֵ ai��-50 <= ai <= 50������������һ�а�������������k �� d (1 <= k <= 10, 1 <= d <= 50)��
�������:
���һ�б�ʾ���ĳ˻���
 * @author Administrator
 *
 */
public class Main01 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n=0,k=0,d=0;
		int[] array = null;
		while(cin.hasNextInt()){
			n = cin.nextInt();
			array=new int[n];
			for(int i =0;i< n;i++){
				array[i] = cin.nextInt();
			}
			k = cin.nextInt();
			d = cin.nextInt();
		}
		System.out.println(computeMaxProduct(array,k,d));
	}


static long max(long a, long b) {
    return a > b ? a : b;
}

static long min(long a, long b) {
    return a < b ? a : b;
}

private static long computeMaxProduct(int[] array, int k, int d) {
	long dpMax[][] = new long[array.length][k+1];
	long dpMin[][] = new long[array.length][k+1];
	for(int i = 0;i<array.length;i++){
		dpMax[i][1] = array[i];
		dpMax[i][0] = array[0];
	}
	
	long maxSoFar = Long.MIN_VALUE;
	for(int j=2;j<=k;j++){
		for(int i=j-1;i<array.length;i++){
			dpMax[i][j] = Long.MIN_VALUE;
			dpMin[i][j] = Long.MAX_VALUE;
			for(int x=1;x<=d&&(i-x)>=j-x;x++){
				long resMax = max(dpMax[i-x][j-1]*array[i],
						dpMin[i-x][j-1]*array[i]);
				long resMin = min(dpMax[i-x][j-1]*array[i],
						dpMin[i-x][j-1]*array[i]);
				if (resMax > dpMax[i][j])
                    dpMax[i][j] = resMax;
                if (resMin < dpMin[i][j])
                    dpMin[i][j] = resMin;
			}
		}
	}
    for (int i = k-1; i < array.length; i++) {
        if (dpMax[i][k] > maxSoFar) {
            maxSoFar = dpMax[i][k];
        }
    }

    return maxSoFar;
	
}


}




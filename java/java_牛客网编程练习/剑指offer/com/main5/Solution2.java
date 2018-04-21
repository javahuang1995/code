package com.main5;

/**
 * 
 * @author Administrator ����
 * 2018-4-21����08:00:26
 */
public class Solution2 {
    public static int min(int[] numbers) {
        // �ж������Ƿ�Ϸ�
        if (numbers == null || numbers.length == 0) {
            throw new RuntimeException("Invalid input.");
        }

        // ��ʼ����ĵ�һ��λ��
        int lo = 0;
        // ��ʼ��������һ��λ��
        int hi = numbers.length - 1;
        // ���ó�ʼֵ
        int mi = lo;

        // ȷ��lo��ǰһ���ź���Ĳ��֣�hi���ź���ĺ�һ������
        while (numbers[lo] >= numbers[hi]) {
            // ������Χֻ����������ʱ�����غ�һ�����
            // ��Ϊnumbers[lo] >= numbers[hi]���ǳ�������һ�������Ӧ������С��ֵ
            if (hi - lo == 1) {
                return numbers[hi];
            }

            // ȡ�м��λ��
            mi = lo + (hi - lo) / 2;

            // �������������ȣ�����Ҫ����˳������ͷ��β����С��ֵ
            if (numbers[mi] == numbers[lo] && numbers[hi] == numbers[mi]) {
                return minInorder(numbers, lo, hi);
            }

            // ����м�λ�ö�Ӧ��ֵ��ǰһ���ź���Ĳ��֣���lo����Ϊ�µĴ���λ��
            if (numbers[mi] >= numbers[lo]) {
                lo = mi;
            }
            // ����м�λ�ö�Ӧ��ֵ�ں�һ���ź���Ĳ��֣���hi����Ϊ�µĴ���λ��
            else if (numbers[mi] <= numbers[hi]) {
                hi = mi;
            }
        }

        // �������յĴ�����
        return numbers[mi];
}


    /**
     * �������е���Сֵ
     *
     * @param numbers ����
     * @param start   �������ʼλ��
     * @param end     ����Ľ���λ��
     * @return �ҵ�����С����
     */
    public static int minInorder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
    
}
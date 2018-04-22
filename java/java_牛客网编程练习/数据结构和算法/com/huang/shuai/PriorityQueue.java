package com.huang.shuai;
/**
 * ���ȼ����о����������
 * @author Administrator
 *
 */
public class PriorityQueue {  
    private long[] a;  
    private int size;  
    private int nItems;//Ԫ�ظ���  
      
    public PriorityQueue(int maxSize) {  
        size = maxSize;  
        nItems = 0;  
        a = new long[size];  
    }  
      
    public void insert(long value) {  
        if(isFull()){  
            System.out.println("����������");  
            return;  
        }  
        int j;  
        if(nItems == 0) { //�ն���ֱ�����  
            a[nItems++] = value;  
        }  
        else{//�������е����������±갴�մӴ�С����  
            for(j = nItems-1; j >= 0; j--) {  
                if(value > a[j]){  
                    a[j+1] = a[j];  
                }  
                else {  
                    break;  
                }  
            }  
            a[j+1] = value;  
            nItems++;  
        }  
    }  
      
    public long remove() {  
        if(isEmpty()){  
            System.out.println("����Ϊ�գ�");  
            return 0;  
        }  
        return a[--nItems];  
    }  
      
    public long peekMin() {  
        return a[nItems-1];  
    }  
      
    public boolean isFull() {  
        return (nItems == size);  
    }  
      
    public boolean isEmpty() {  
        return (nItems == 0);  
    }  
      
    public int size() {  
        return nItems;  
    }  
  
    public void display() {  
        for(int i = nItems-1; i >= 0; i--) {  
            System.out.print(a[i] + " ");  
        }  
        System.out.println(" ");  
    }  
}  
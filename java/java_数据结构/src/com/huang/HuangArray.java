package com.huang;

public class HuangArray {
	 	private int[] a;  
	    private int size; //����Ĵ�С  
	    private int nElem; //�������ж�����  
	    public HuangArray(int max) { //��ʼ������  
	        this.a = new int[max];  
	        this.size = max;  
	        this.nElem = 0;  
	    }  
	    public boolean find(int searchNum) { //����ĳ��ֵ      
	        int j;  
	        for(j = 0; j < nElem; j++)
	        {  
	            if(a[j] == searchNum)  
	                break;  
	        }  
	        if(j == nElem)  
	            return false;  
	        else  
	            return true;  
	    }  
	    public boolean insert(int value) { //����ĳ��ֵ  
	        if(nElem == size){  
	            System.out.println("����������");  
	            return false;  
	        }  
	        a[nElem] = value;  
	        nElem++;          
	        return true;  
	    }  
	    public boolean delete(int value) {//ɾ��ĳ��ֵ  
	        int j;  
	        for(j = 0; j < nElem; j++) {  
	            if(a[j] == value) {  
	                break;  
	            }  
	        }  
	        if(j == nElem)   
	            return false;  
	        if(nElem == size) //����������
	        {  
	            for(int k = j; k < nElem - 1; k++) 
	            {  
	                a[k] = a[k+1];  
	            }  
	        }  
	        else //���鲻������
	        {  
	            for(int k = j; k < nElem; k++) 
	            {  
	                a[k] = a[k+1];  
	            }  
	        }  
	        nElem--;  
	        return true;  
	    }  
	    public void display() { //��ӡ��������  
	        for(int i = 0; i < nElem; i++) {  
	            System.out.print(a[i] + " ");  
	        }  
	        System.out.println("");  
	    }  
}

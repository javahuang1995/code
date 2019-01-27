package com.huang.datastruct;

public class MyArray<T> {
	
	private Object[] table;
	private int size;
	private static final int INIT = 10;
	
	public MyArray() { //锟斤拷始锟斤拷锟斤拷锟斤拷
		this.table = new Object[INIT];
		this.size = 0;
	}
	
	public MyArray(int max) { //锟斤拷始锟斤拷锟斤拷锟斤拷
		this.table = new Object[max];
		this.size = 0;
	}
	
	public void add(T e){
		table[size++] = e;
	}
	
	public void remove() {
		table[--size] = null;
	}
	
	/**
	 * 锟斤拷锟斤不锟斤拷要锟叫讹拷index锟角凤拷锟叫★拷锟�锟斤拷java锟斤拷锟絠ndex小锟斤拷0锟斤拷table[]锟酵会报锟�
	 * @param index
	 * @return
	 */
    public T get(int index) {
        if(index>size){
        	return null;
        }
        return elementData(index);
    }
    
    @SuppressWarnings("unchecked")
    T elementData(int i){
    	return (T)table[i];
    }
    
	
	

}

package com.huang.datastruct.study.line;

public class MyArray<T> {
	
	private Object[] table;
	private int size;
	private static final int INIT = 10;
	
	public MyArray() { //阌熸枻鎷峰阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷?
		this.table = new Object[INIT];
		this.size = 0;
	}
	
	public MyArray(int max) { //阌熸枻鎷峰阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷?
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
	 * 阌熸枻鎷烽敓鏂や笉阌熸枻鎷疯阌熷彨璁规嫹index阌熻鍑ゆ嫹阌熷彨钸呮嫹阌燂拷阌熸枻鎷穓ava阌熸枻鎷烽敓绲爊dex灏忛敓鏂ゆ嫹0阌熸枻鎷穞able[]阌熼叺浼氭姤阌燂拷
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

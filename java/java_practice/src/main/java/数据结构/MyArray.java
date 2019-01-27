package ���ݽṹ;

public class MyArray<T> {
	
	private Object[] table;
	private int size;
	private static final int INIT = 10;
	
	public MyArray() { //��ʼ������
		this.table = new Object[INIT];
		this.size = 0;
	}
	
	public MyArray(int max) { //��ʼ������
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
	 * ���ﲻ��Ҫ�ж�index�Ƿ��С��0��java�������indexС��0��table[]�ͻᱨ��
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

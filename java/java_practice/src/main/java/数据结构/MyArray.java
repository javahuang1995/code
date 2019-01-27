package 数据结构;

public class MyArray<T> {
	
	private Object[] table;
	private int size;
	private static final int INIT = 10;
	
	public MyArray() { //初始化数组
		this.table = new Object[INIT];
		this.size = 0;
	}
	
	public MyArray(int max) { //初始化数组
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
	 * 这里不需要判断index是否会小于0，java如果看到index小于0，table[]就会报错。
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

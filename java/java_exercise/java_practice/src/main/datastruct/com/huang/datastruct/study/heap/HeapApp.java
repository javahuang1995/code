package com.huang.datastruct.study.heap;
public class HeapApp {

	public static void main(String[] args) {
		Heap theHeap = new Heap(20);
		theHeap.insert(13);
		theHeap.insert(43);
		theHeap.insert(57);
		theHeap.insert(52);
		theHeap.insert(33);
		theHeap.insert(70);
		theHeap.insert(8);
		theHeap.insert(75);
		theHeap.insert(22);
		theHeap.insert(65);
		theHeap.insert(90);
		while (!theHeap.isEmpty()){
			System.out.print(theHeap.remove().getKey() + " ");
		}
	}
}
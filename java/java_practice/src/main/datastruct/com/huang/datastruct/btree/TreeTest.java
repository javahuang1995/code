package com.huang.datastruct.btree;

public class TreeTest {
	public static void main(String[] args) {
		BinarySortTree test = new BinarySortTree();
		test.insert(8, 8);
		test.insert(5, 5);
		test.insert(1, 1);
		test.insert(0, 0);
		test.insert(4, 4);
		
		
		test.delete(4);
		
		test.traverse(2);
		
	}
}

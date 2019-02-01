﻿package com.huang.datastruct.line;

public

class

HashChain {

	private

	SortedList[] hashArray;
	// 数组中存放链表

	private

	int arraySize;

	public

	HashChain(int size) {
		arraySize = size;
		hashArray = new

		SortedList[arraySize];

		// new出每个空链表初始化数组

		for (int i = 0; i < arraySize; i++) {
			hashArray[i] = new

			SortedList();
		}
	}

	public

			void displayTable() {

		for (int i = 0; i < arraySize; i++) {

			System.out.print(i + ": ");
			hashArray[i].displayList();
		}
	}

	public

			int hashFunction(int key) {

		return key % arraySize;
	}

	public

			void insert(LinkNode node) {

		int key = node.getKey();

		int hashVal = hashFunction(key);
		hashArray[hashVal].insert(node);
		// 直接往链表中添加即可
	}

	public

			LinkNode

			delete(int key) {

		int hashVal = hashFunction(key);

		LinkNode temp = find(key);
		hashArray[hashVal].delete(key);
		// 从链表中找到要删除的数据项，直接删除

		return temp;
	}

	public

			LinkNode find(int key) {

		int hashVal = hashFunction(key);

		LinkNode node = hashArray[hashVal].find(key);

		return node;
	}
}
package com.huang.datastruct.line;

public

class

HashChain {

	private

	SortedList[] hashArray;
	// �����д������

	private

	int arraySize;

	public

	HashChain(int size) {
		arraySize = size;
		hashArray = new

		SortedList[arraySize];

		// new��ÿ���������ʼ������

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
		// ֱ������������Ӽ���
	}

	public

			LinkNode

			delete(int key) {

		int hashVal = hashFunction(key);

		LinkNode temp = find(key);
		hashArray[hashVal].delete(key);
		// ���������ҵ�Ҫɾ���������ֱ��ɾ��

		return temp;
	}

	public

			LinkNode find(int key) {

		int hashVal = hashFunction(key);

		LinkNode node = hashArray[hashVal].find(key);

		return node;
	}
}
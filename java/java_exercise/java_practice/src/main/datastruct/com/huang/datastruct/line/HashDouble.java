package com.huang.datastruct.line;

public

class

HashDouble {

	private

	DataItem[] hashArray;

	private

	int arraySize;

	private

	int itemNum;

	private

	DataItem nonItem;

	public

	HashDouble() {
		arraySize = 13;
		hashArray = new

		DataItem[arraySize];
		nonItem = new

		DataItem(-1);
	}

	public

			void displayTable() {

		System.out.print("Table:");

		for (int i = 0; i < arraySize; i++) {

			if (hashArray[i] != null) {

				System.out.print(hashArray[i].getKey() + " ");
			}

			else {

				System.out.print("** ");
			}
		}

		System.out.println("");
	}

	public

			int hashFunction1(int key) {
		// first hash function

		return key % arraySize;
	}

	public

			int hashFunction2(int key) {
		// second hash function

		return

		5 - key % 5;
	}

	public

			boolean isFull() {

		return (itemNum == arraySize);
	}

	public

			boolean isEmpty() {

		return (itemNum == 0);
	}

	public

			void insert(DataItem item) {

		if (isFull()) {

			System.out.println("哈希表已满，重新哈希化..");
			extendHashTable();
		}

		int key = item.getKey();

		int hashVal = hashFunction1(key);

		int stepSize = hashFunction2(key);
		// 用hashFunction2计算探测步数

		while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
			hashVal += stepSize;
			hashVal %= arraySize;
			// 以指定的步数向后探测
		}
		hashArray[hashVal] = item;
		itemNum++;
	}

	public

			void extendHashTable() {

		int num = arraySize;
		itemNum = 0;
		// 重新记数，因为下面要把原来的数据转移到新的扩张的数组中
		arraySize *= 2;
		// 数组大小翻倍

		DataItem[] oldHashArray = hashArray;
		hashArray = new

		DataItem[arraySize];

		for (int i = 0; i < num; i++) {
			insert(oldHashArray[i]);
		}
	}

	public

			DataItem

			delete(int key) {

		if (isEmpty()) {

			System.out.println("Hash table is empty!");

			return

			null;
		}

		int hashVal = hashFunction1(key);

		int stepSize = hashFunction2(key);

		while (hashArray[hashVal] != null) {

			if (hashArray[hashVal].getKey() == key) {

				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				itemNum--;

				return temp;
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		}

		return

		null;
	}

	public

			DataItem find(int key) {

		int hashVal = hashFunction1(key);

		int stepSize = hashFunction2(key);

		while (hashArray[hashVal] != null) {

			if (hashArray[hashVal].getKey() == key) {

				return hashArray[hashVal];
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		}

		return

		null;
	}
}
package com.huang.datastruct.line;

public

class

HashTable {

	private

	DataItem[] hashArray;
	// DateItem�����������װ������Ϣ

	private

	int arraySize;

	private

	int itemNum;
	// ������Ŀǰ�洢�˶�����

	private

	DataItem nonItem;
	// ����ɾ�����

	public

	HashTable() {
		arraySize = 13;
		hashArray = new

		DataItem[arraySize];
		nonItem = new

		DataItem(-1);
		// deleted item key is -1
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

			void displayTable() {

		System.out.print("Table:");

		for (int j = 0; j < arraySize; j++) {

			if (hashArray[j] != null) {

				System.out.print(hashArray[j].getKey() + " ");
			}

			else {

				System.out.print("** ");
			}
		}

		System.out.println("");
	}

	public

			int hashFunction(int key) {

		return key % arraySize;
		// hash function
	}

	public

			void insert(DataItem item) {

		if (isFull()) {

			// ��չ��ϣ��

			System.out.println("��ϣ�����������¹�ϣ��..");
			extendHashTable();
		}

		int key = item.getKey();

		int hashVal = hashFunction(key);

		while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
			++hashVal;
			hashVal %= arraySize;
		}
		hashArray[hashVal] = item;
		itemNum++;
	}

	/*
	 * �����й̶��Ĵ�С�����Ҳ�����չ��������չ��ϣ��ֻ�����ⴴ��һ����������飬Ȼ��Ѿ������е����ݲ嵽�µ������С�
	 * ���ǹ�ϣ���Ǹ��������С����������ݵ�λ�õģ�������Щ��������ٷ����������к���������ͬ��λ���ϣ���˲���ֱ�ӿ�������Ҫ��˳����������飬
	 * ��ʹ��insert�������������в���ÿ�������������¹�ϣ��������һ����ʱ�Ĺ��̣����������Ҫ������չ����������Ǳ���ġ�
	 */

	public

			void extendHashTable() {
		// ��չ��ϣ��

		int num = arraySize;
		itemNum = 0;
		// ���¼�������Ϊ����Ҫ��ԭ��������ת�Ƶ��µ����ŵ�������
		arraySize *= 2;
		// �����С����

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

		int hashVal = hashFunction(key);

		while (hashArray[hashVal] != null) {

			if (hashArray[hashVal].getKey() == key) {

				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				// nonItem��ʾ��Item,��keyΪ-1
				itemNum--;

				return temp;
			}
			++hashVal;
			hashVal %= arraySize;
		}

		return

		null;
	}

	public

			DataItem find(int key) {

		int hashVal = hashFunction(key);

		while (hashArray[hashVal] != null) {

			if (hashArray[hashVal].getKey() == key) {

				return hashArray[hashVal];
			}
			++hashVal;
			hashVal %= arraySize;
		}

		return

		null;
	}
}

class

DataItem {

	private

	int iData;

	public

	DataItem(int data) {
		iData = data;
	}

	public

			int getKey() {

		return iData;
	}
}
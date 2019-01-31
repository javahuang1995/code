/**
 * ���ѵ�ʵ��
 */
package com.huang.datastruct.heap;

// ����ڵ�
class Node {
	private int data;

	public Node(int d) {
		data = d;
	}

	public int getKey() {
		return data;
	}
}

// �����
class Heap {
	private Node[] heapArray; // �洢�ڵ������
	private int maxSize; // ���洢��С
	private int currSize; // ��ǰ��С

	public Heap(int size) {
		maxSize = size;
		currSize = 0;
		heapArray = new Node[size];
	}

	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return (currSize == 0);
	}

	// ����Ԫ��
	public boolean insert(int key) {
		// �洢����
		if (currSize == maxSize)
			return false;
		Node node = new Node(key);
		// ���½ڵ�ŵ��������
		heapArray[currSize] = node;
		// �����ѽṹ
		trickleUp(currSize++);
		return true;
	}

	/**
	 * �������100��һ���Ƚϴ��������Ҫ������ĩ�����ϵ���
	 * 
	 * @param i
	 */
	// ���ϱȽ�
	private void trickleUp(int i) {
		// ���ڵ�Ǳ�
		int parent = (i - 1) / 2;
		Node temp = heapArray[i];// ��ΪҪ���������������м䱣��һ�¡�
		// ��ǰ�ڵ�ؼ��ִ��ڸ��ڵ�ؼ���
		while (i > 0 && heapArray[i].getKey() > heapArray[parent].getKey()) {
			heapArray[i] = heapArray[parent];
			i = parent;// ����i��i���ǲ������ݣ�����˵100 ��λ�á��ǲ��������ߵġ�
			parent = (i - 1) / 2; // i���ˣ�parentҲҪ��
		}

		heapArray[i] = temp;// iѭ�����֮��������յ�����λ�ã���temp�Ž�ȥ��
	}

	// ɾ��Ԫ��
	public Node remove() {
		Node root = heapArray[0];
		// ���һ��Ԫ�طŵ��Ѷ�
		heapArray[0] = heapArray[--currSize];
		// ���±Ƚ�
		trickleDown(0);
		return root;
	}

	/**
	 * ���µ���
	 * @param i
	 */
	private void trickleDown(int i) {
		int largeChild;
		Node top = heapArray[i];
		while (i < currSize / 2) {
			int leftChild = 2 * i + 1;
			int rightChild = leftChild + 1;
			if (rightChild < currSize && heapArray[rightChild].getKey() > heapArray[leftChild].getKey())
				largeChild = rightChild;
			else
				largeChild = leftChild;
			if (top.getKey() >= heapArray[largeChild].getKey())
				break;
			heapArray[i] = heapArray[largeChild];
			i = largeChild;
		}
		heapArray[i] = top;
	}
}

/**
 * 最大堆的实现
 */
package com.huang.datastruct.study.heap;

// 定义节点
class Node {
	private int data;

	public Node(int d) {
		data = d;
	}

	public int getKey() {
		return data;
	}
}

// 定义堆
class Heap {
	private Node[] heapArray; // 存储节点的数组
	private int maxSize; // 最大存储大小
	private int currSize; // 当前大小

	public Heap(int size) {
		maxSize = size;
		currSize = 0;
		heapArray = new Node[size];
	}

	// 判断是否为空
	public boolean isEmpty() {
		return (currSize == 0);
	}

	// 插入元素
	public boolean insert(int key) {
		// 存储已满
		if (currSize == maxSize)
			return false;
		Node node = new Node(key);
		// 将新节点放到数组最后
		heapArray[currSize] = node;
		// 调整堆结构
		trickleUp(currSize++);
		return true;
	}

	/**
	 * 比如插入100，一个比较大的数，需要从数组末端向上调整
	 * 
	 * @param i
	 */
	// 向上比较
	private void trickleUp(int i) {
		// 父节点角标
		int parent = (i - 1) / 2;
		Node temp = heapArray[i];// 因为要交换，所以这里中间保存一下。
		// 当前节点关键字大于父节点关键字
		while (i > 0 && heapArray[i].getKey() > heapArray[parent].getKey()) {
			heapArray[i] = heapArray[parent];
			i = parent;// 更新i，i就是插入数据，比如说100 的位置。是不断往上走的。
			parent = (i - 1) / 2; // i变了，parent也要变
		}

		heapArray[i] = temp;// i循环完毕之后就是最终调整的位置，把temp放进去。
	}

	// 删除元素
	public Node remove() {
		Node root = heapArray[0];
		// 最后一个元素放到堆顶
		heapArray[0] = heapArray[--currSize];
		// 向下比较
		trickleDown(0);
		return root;
	}

	/**
	 * 向下调整
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

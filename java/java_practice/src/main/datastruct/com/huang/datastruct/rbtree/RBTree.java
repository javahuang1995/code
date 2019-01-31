package com.huang.datastruct.rbtree;

public class RBTree<T extends Comparable<T>> {

	private static final boolean BLACK = false;
	private static final boolean RED = true;

	private RBNode root;

	/************* �Ժ�����ڵ�x������������ ******************/
	private void leftRotate(RBNode<T> x) {
		// 1. ��y�����ӽڵ㸳��x�����ӽڵ㣬����x����y���ӽڵ�ĸ��ڵ�(y���ӽڵ�ǿ�ʱ)
		RBNode<T> y = x.right;
		x.right = y.left;

		if (y.left != null)
			y.left.parent = x;

		// 2. ��x�ĸ��ڵ�p(�ǿ�ʱ)����y�ĸ��ڵ㣬ͬʱ����p���ӽڵ�Ϊy(�����)
		y.parent = x.parent;

		if (x.parent == null) {

			this.root = y;
			// ���x�ĸ��ڵ�Ϊ�գ���y��Ϊ���ڵ�
		} else {

			if (x == x.parent.left)
				// ���x�����ӽڵ�
				x.parent.left = y;
			// ��Ҳ��y��Ϊ���ӽڵ�

			else
				x.parent.right = y;
			// ����y��Ϊ���ӽڵ�
		}

		// 3. ��y�����ӽڵ���Ϊx����x�ĸ��ڵ���Ϊy
		y.left = x;
		x.parent = y;
	}

	/************* �Ժ�����ڵ�y������������ ******************/
	private void rightRotate(RBNode<T> y) {
		// 1. ��y�����ӽڵ㸳��x�����ӽڵ㣬����x����y���ӽڵ�ĸ��ڵ�(y���ӽڵ�ǿ�ʱ)
		RBNode<T> x = y.left;
		y.left = x.right;
		if (x.right != null)
			x.right.parent = y;
		// 2. ��x�ĸ��ڵ�p(�ǿ�ʱ)����y�ĸ��ڵ㣬ͬʱ����p���ӽڵ�Ϊy(�����)
		x.parent = y.parent;

		if (y.parent == null) {

			this.root = x;
			// ���x�ĸ��ڵ�Ϊ�գ���y��Ϊ���ڵ�
		} else {

			if (y == y.parent.right)
				// ���x�����ӽڵ�
				y.parent.right = x;
			// ��Ҳ��y��Ϊ���ӽڵ�

			else
				y.parent.left = x;
			// ����y��Ϊ���ӽڵ�
		}

		// 3. ��y�����ӽڵ���Ϊx����x�ĸ��ڵ���Ϊy
		x.right = y;
		y.parent = x;
	}

	/*********************** �������в���ڵ� **********************/
	public void insert(T key) {
		RBNode<T> node = new RBNode<T>(key, RED, null, null, null);
		if (root == null)
			root = node;
		if (node != null)
			insert(node);
		insertFixUp(node);
	}

	// ���ڵ���뵽������У���������������������һ����
	private void insert(RBNode<T> node) {
		// current��ʾ�����λ�ã�parent�ǲ���λ�õĸ��ڵ㡣
		RBNode<T> current = root;
		RBNode<T> parent;
		while (true) {
			parent = current;// �ڸ���current֮ǰ���ȱ���currentֵ��parent
			if (node.key.compareTo(current.key) < 0) { // turn left
				current = current.left;
				if (current == null) {
					parent.left = node;
					node.parent = parent;
					return;
				}
			} else { // turn right
				current = current.right;
				if (current == null) {
					parent.right = node;
					node.parent = parent;
					return;
				}
			}
		}

	}

	private void insertFixUp(RBNode<T> node) {
		RBNode<T> parent, gparent;
		// ���常�ڵ���游�ڵ�
		// ��Ҫ���������������ڵ���ڣ��Ҹ��ڵ����ɫ�Ǻ�ɫ
		while (((parent = parentOf(node)) != null) && isRed(parent)) {
			gparent = parentOf(parent);
			// ����游�ڵ�
			// �����ڵ����游�ڵ�����ӽڵ㣬����else�����෴
			if (parent == gparent.left) {
				RBNode<T> uncle = gparent.right;
				// �������ڵ�
				// case1: ����ڵ�Ҳ�Ǻ�ɫ
				if (uncle != null && isRed(uncle)) {
					setBlack(parent);
					// �Ѹ��ڵ������ڵ�Ϳ��
					setBlack(uncle);
					setRed(gparent);
					// ���游�ڵ�Ϳ��
					node = gparent;
					// ��λ�÷ŵ��游�ڵ㴦
					continue;
					// ����while�������ж�
				}
				// case2: ����ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ������ӽڵ�
				if (node == parent.right) {
					leftRotate(parent);
					// �Ӹ��ڵ㴦����
					RBNode<T> tmp = parent;
					// Ȼ�󽫸��ڵ���Լ�����һ�£�Ϊ����������׼��
					parent = node;
					node = tmp;
				}
				// case3: ����ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ������ӽڵ�
				setBlack(parent);
				setRed(gparent);
				rightRotate(gparent);
			} else {
				// �����ڵ����游�ڵ�����ӽڵ�,���������ȫ�෴������һ����
				RBNode<T> uncle = gparent.left;
				// case1: ����ڵ�Ҳ�Ǻ�ɫ
				if (uncle != null & isRed(uncle)) {
					setBlack(parent);
					setBlack(uncle);
					setRed(gparent);
					node = gparent;
					continue;
				}
				// case2: ����ڵ��Ǻ�ɫ�ģ��ҵ�ǰ�ڵ������ӽڵ�
				if (node == parent.left) {
					rightRotate(parent);
					RBNode<T> tmp = parent;
					parent = node;
					node = tmp;
				}

				// case3: ����ڵ��Ǻ�ɫ�ģ��ҵ�ǰ�ڵ������ӽڵ�
				setBlack(parent);
				setRed(gparent);
				leftRotate(gparent);
			}
		}
		// �����ڵ�����Ϊ��ɫ
		setBlack(this.root);
	}

	private boolean isRed(RBNode<T> node) {
		return node.color == RED;
	}

	private RBNode<T> parentOf(RBNode<T> node) {
		return node.parent;
	}

	private void setRed(RBNode<T> node) {
		node.color = RED;
	}

	private void setBlack(RBNode<T> node) {
		node.color = BLACK;
	}

}

class RBNode<T extends Comparable<T>> {

	private static final boolean BLACK = false;
	private static final boolean RED = true;

	// ��ɫ
	boolean color;

	// �ؼ���(��ֵ)
	T key;

	// ���ӽڵ�
	RBNode<T> left;

	// ���ӽڵ�
	RBNode<T> right;

	// ���ڵ�
	RBNode<T> parent;

	public RBNode(T key, boolean color, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {

		this.key = key;

		this.color = color;

		this.parent = parent;

		this.left = left;

		this.right = right;
	}

	public T getKey() {
		return key;
	}

	public String toString() {

		return "" + key + (this.color == RED ? "R" : "B");
	}
}

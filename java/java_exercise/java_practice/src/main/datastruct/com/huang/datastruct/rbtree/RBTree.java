package com.huang.datastruct.rbtree;

public class RBTree<T extends Comparable<T>> {

	private static final boolean BLACK = false;
	private static final boolean RED = true;

	private RBNode root;

	/************* 对红黑树节点x进行左旋操作 ******************/
	private void leftRotate(RBNode<T> x) {
		// 1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
		RBNode<T> y = x.right;
		x.right = y.left;

		if (y.left != null)
			y.left.parent = x;

		// 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
		y.parent = x.parent;

		if (x.parent == null) {

			this.root = y;
			// 如果x的父节点为空，则将y设为父节点
		} else {

			if (x == x.parent.left)
				// 如果x是左子节点
				x.parent.left = y;
			// 则也将y设为左子节点

			else
				x.parent.right = y;
			// 否则将y设为右子节点
		}

		// 3. 将y的左子节点设为x，将x的父节点设为y
		y.left = x;
		x.parent = y;
	}

	/************* 对红黑树节点y进行右旋操作 ******************/
	private void rightRotate(RBNode<T> y) {
		// 1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
		RBNode<T> x = y.left;
		y.left = x.right;
		if (x.right != null)
			x.right.parent = y;
		// 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
		x.parent = y.parent;

		if (y.parent == null) {

			this.root = x;
			// 如果x的父节点为空，则将y设为父节点
		} else {

			if (y == y.parent.right)
				// 如果x是左子节点
				y.parent.right = x;
			// 则也将y设为左子节点

			else
				y.parent.left = x;
			// 否则将y设为右子节点
		}

		// 3. 将y的左子节点设为x，将x的父节点设为y
		x.right = y;
		y.parent = x;
	}

	/*********************** 向红黑树中插入节点 **********************/
	public void insert(T key) {
		RBNode<T> node = new RBNode<T>(key, RED, null, null, null);
		if (root == null)
			root = node;
		if (node != null)
			insert(node);
		insertFixUp(node);
	}

	// 将节点插入到红黑树中，这个过程与二叉搜索树是一样的
	private void insert(RBNode<T> node) {
		// current表示插入的位置，parent是插入位置的父节点。
		RBNode<T> current = root;
		RBNode<T> parent;
		while (true) {
			parent = current;// 在更新current之前，先保存current值到parent
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
		// 定义父节点和祖父节点
		// 需要修整的条件：父节点存在，且父节点的颜色是红色
		while (((parent = parentOf(node)) != null) && isRed(parent)) {
			gparent = parentOf(parent);
			// 获得祖父节点
			// 若父节点是祖父节点的左子节点，下面else与其相反
			if (parent == gparent.left) {
				RBNode<T> uncle = gparent.right;
				// 获得叔叔节点
				// case1: 叔叔节点也是红色
				if (uncle != null && isRed(uncle)) {
					setBlack(parent);
					// 把父节点和叔叔节点涂黑
					setBlack(uncle);
					setRed(gparent);
					// 把祖父节点涂红
					node = gparent;
					// 将位置放到祖父节点处
					continue;
					// 继续while，重新判断
				}
				// case2: 叔叔节点是黑色，且当前节点是右子节点
				if (node == parent.right) {
					leftRotate(parent);
					// 从父节点处左旋
					RBNode<T> tmp = parent;
					// 然后将父节点和自己调换一下，为下面右旋做准备
					parent = node;
					node = tmp;
				}
				// case3: 叔叔节点是黑色，且当前节点是左子节点
				setBlack(parent);
				setRed(gparent);
				rightRotate(gparent);
			} else {
				// 若父节点是祖父节点的右子节点,与上面的完全相反，本质一样的
				RBNode<T> uncle = gparent.left;
				// case1: 叔叔节点也是红色
				if (uncle != null & isRed(uncle)) {
					setBlack(parent);
					setBlack(uncle);
					setRed(gparent);
					node = gparent;
					continue;
				}
				// case2: 叔叔节点是黑色的，且当前节点是左子节点
				if (node == parent.left) {
					rightRotate(parent);
					RBNode<T> tmp = parent;
					parent = node;
					node = tmp;
				}

				// case3: 叔叔节点是黑色的，且当前节点是右子节点
				setBlack(parent);
				setRed(gparent);
				leftRotate(gparent);
			}
		}
		// 将根节点设置为黑色
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

	// 颜色
	boolean color;

	// 关键字(键值)
	T key;

	// 左子节点
	RBNode<T> left;

	// 右子节点
	RBNode<T> right;

	// 父节点
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

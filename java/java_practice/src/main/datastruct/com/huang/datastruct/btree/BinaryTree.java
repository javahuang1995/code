package com.huang.datastruct.btree;

/**
 * 二叉树
 * 
 * @author Administrator 实现方法：查找，插入，遍历，删除。
 *
 */
public class BinaryTree {
	private BNode root;

	public BinaryTree() {
		root = null;
	}

	/**
	 * 定义一个BNode作为result返回 当result.key和查找的内容不一样，就一直循环 小，则向左，大则向右
	 * 
	 * @param key
	 * @return
	 */
	public BNode find(int key) { // find node with given key
		BNode result = root;
		while (result.key != key) {
			if (key < result.key) {
				result = result.left;
			} else {
				result = result.right;
			}
			if (result == null) {
				return null;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void insert(int key, double value) {
		// 根据传入的参数构造一个节点
		BNode newNode = new BNode();
		newNode.key = key;
		newNode.data = value;

		if (root == null) { // if tree is null
			root = newNode;
		} else {
			// current表示插入的位置，parent是插入位置的父节点。
			BNode current = root;
			BNode parent;
			while (true) {
				parent = current;
				if (key < current.data) { // turn left
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						newNode.parent = parent;
						return;
					}
				} else { // turn right
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						newNode.parent = parent;
						return;
					}
				}
			}
		}
	}

	/**
	 * 遍历
	 * 
	 * @param traverseType
	 */
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.println("Preorder traversal:");
			preOrder(root);// 前序遍历
			break;
		case 2:
			System.out.println("Inorder traversal:");
			inOrder(root);// 中序遍历
			break;
		case 3:
			System.out.println("Postorder traversal:");
			postOrder(root);// 后序遍历
			break;
		default:
			System.out.println("Inorder traversal:");
			inOrder(root);
			break;
		}
		System.out.println("");
	}

	private void preOrder(BNode localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.data + " ");// 打印data就完事了
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}

	private void inOrder(BNode localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.left);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.right);
		}
	}

	private void postOrder(BNode localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data + " ");
		}
	}

	public boolean delete(int key) {
		BNode current = find(key);
		if (current == null) {
			return false;
		}
		if (current.left == null && current.right == null) {
			return deleteNoChild(current);
		}

		else if (current.left != null && current.right != null) {
			return deleteTwoChild(current);
		} else {
			return deleteOneChild(current);
		}
	}

	public boolean deleteNoChild(BNode node) {
		if (node == root) {
			root = null;
			return true;
		}
		// 判断Node是不是父节点的左节点
		if (node.parent.left == node) {
			node.parent.left = null;
		} else {
			node.parent.right = null;
		}
		return true;
	}

	public boolean deleteOneChild(BNode node) {
		if (node == root) {
			root = null;
			return true;
		}
		// 先找到子节点，不需要管他是左是右
		BNode child = null;
		if (node.left != null) {
			child = node.left;
		} else {
			child = node.right;
		}

		// 这里忽略了父节点不存在的情况，最后会巧妙的处理这种情况
		// 将父节点和子节点建立关系
		if (node.parent.left == node) {
			node.parent.left = child;
		} else {
			node.parent.right = child;
		}

		child.parent = node.parent;
		return true;
	}

	/**
	 * 1.获取要删除节点的后继节点 2.转移值 3.删除后继节点。
	 * 
	 * @param node
	 * @param isLeftChild
	 * @return
	 */
	public boolean deleteTwoChild(BNode node) {
		// 获取后继结点
		BNode successor = getSuccessor(node);
		// 转移后继结点值到当前节点
		node.key = successor.key;

		// 把要删除的当前节点设置为后继结点
		// 经过前一步处理，下面只有前两种情况，只能是一个节点或者没有节点
		// 后继节点一定不会有左节点，但是一定有右节点
		node = successor;
		if (node.right == null) {
			return deleteNoChild(node);
		}else{
			return deleteOneChild(node);
		}
	}

	public BNode getSuccessor(BNode node) {
		BNode successor = node;
		BNode current = node.right;
		while (current != null) {
			successor = current;
			current = current.left;
		}
		if (successor != node.right) {
			successor.parent.left = successor.right;
			if (successor.right != null) {
				successor.right.parent = successor.parent;
			}
			successor.right = node.right;
		}
		return successor;
	}
}

class BNode {
	public int key;
	public double data;
	public BNode parent;
	public BNode left;
	public BNode right;

	public void displayNode() {
		System.out.println("{" + key + ":" + data + "}");
	}
}

package com.huang.datastruct;
public class BinaryTree {
	private BNode root; //锟斤拷诘锟�
	
	public BinaryTree() {
		root = null;
	}
	
	//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟揭碉拷时锟戒复锟接讹拷为O(logN)
	public BNode find(int key) { //find node with given key
		BNode result = root;
		while(result.key != key) {
			if(key < result.key) {
				result = result.leftChild;
			}
			else {
				result = result.rightChild;
			}
			if(result == null) {
				return null;
			}
		}
		return result;
	}
	
	//锟斤拷锟斤拷诘锟�
	public void insert(int key, double value) {
		BNode newNode = new BNode();
		newNode.key = key;
		newNode.data = value;
		if(root == null) { //if tree is null
			root = newNode;
		}
		else {
			BNode current = root;
			BNode parent;
			while(true) {
				parent = current;
				if(key < current.data) { //turn left
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = newNode;
						newNode.parent = parent;
						return;
					}
				}
				else { //turn right
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						newNode.parent = parent;
						return;
					}
				}
			}
		}
	}
	
	//锟斤拷锟斤拷锟斤拷锟斤拷锟�
	public void traverse(int traverseType) {
		switch(traverseType)
		{
		case 1: System.out.println("Preorder traversal:");
				preOrder(root);//前锟斤拷锟斤拷锟�
				break;
		case 2: System.out.println("Inorder traversal:");
				inOrder(root);//锟斤拷锟斤拷锟斤拷锟�
				break;
		case 3: System.out.println("Postorder traversal:");
				postOrder(root);//锟斤拷锟斤拷锟斤拷锟�
				break;
		default: System.out.println("Inorder traversal:");
				inOrder(root);
				break;
		}
		System.out.println("");
	}
	
	//前锟斤拷锟斤拷锟�
	private void preOrder(BNode localRoot) {
		if(localRoot != null) {
			System.out.print(localRoot.data + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	//锟斤拷锟斤拷锟斤拷锟�
	private void inOrder(BNode localRoot) {
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	//锟斤拷锟斤拷锟斤拷锟�
	private void postOrder(BNode localRoot) {
		if(localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.data + " ");
		}
	}
	
	//锟斤拷锟斤拷锟斤拷小值
	/*锟斤拷荻锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷拇娲拷锟斤拷锟斤拷锟叫≈涤︼拷锟斤拷锟斤拷锟斤拷锟角革拷没锟斤拷锟接节碉拷锟斤拷歉锟斤拷诘锟�/
	public BNode minNumber() {
		BNode current = root;
		BNode parent = root;
		while(current != null) {
			parent = current;
			current = current.leftChild;
		}	
		return parent;
	}
	
	//锟斤拷锟斤拷锟斤拷锟街�
	/*锟斤拷荻锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷拇娲拷锟斤拷锟斤拷锟斤拷值应锟斤拷锟斤拷锟揭憋拷锟角革拷没锟斤拷锟接节碉拷锟斤拷歉锟斤拷诘锟�/
	public BNode maxNumber() {
		BNode current = root;
		BNode parent = root;
		while(current != null) {
			parent = current;
			current = current.rightChild;
		}	
		return parent;
	}
	
	//删锟斤拷诘锟�
	/*
	 * 删锟斤拷诘锟斤拷诙锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷罡达拷拥模锟斤拷锟揭拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	 * 1. 锟矫节碉拷没锟斤拷锟接节点（锟津单ｏ拷
	 * 2. 锟矫节碉拷锟斤拷一锟斤拷锟接节点（锟斤拷锟叫ｏ拷
	 * 3. 锟矫节碉拷锟斤拷锟斤拷锟斤拷锟接节点（锟斤拷锟接ｏ拷
	 * 删锟斤拷诘锟斤拷时锟戒复锟接讹拷为O(logN)
	 */
	public boolean delete(int key) {
		BNode current = root;
//		BNode parent = root;
		boolean isLeftChild = true;
		
		if(current == null) {
			return false;
		}
		//寻锟斤拷要删锟斤拷慕诘锟�
		while(current.data != key) {
//			parent = current;
			if(key < current.key) {
				isLeftChild = true;
				current = current.leftChild;
			}
			else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null) {
				return false;
			}
		}
		
		//锟揭碉拷锟斤拷要删锟斤拷慕诘悖拷锟斤拷婵忌撅拷锟�
		//1. 要删锟斤拷慕诘锟矫伙拷锟斤拷咏诘锟�直锟接斤拷锟戒父锟节碉拷锟斤拷锟斤拷咏诘锟斤拷锟斤拷锟斤拷锟接节点赋为null锟斤拷锟斤拷
		if(current.leftChild == null && current.rightChild == null) {
			return deleteNoChild(current, isLeftChild);
		}
		
		//3. 要删锟斤拷慕诘锟斤拷锟斤拷锟斤拷锟斤拷咏诘锟�
		else if(current.leftChild != null && current.rightChild != null) {
			return deleteTwoChild(current, isLeftChild);
		}
		
		//2. 要删锟斤拷慕诘锟斤拷锟揭伙拷锟斤拷咏诘悖憋拷咏锟斤拷淇筹拷希锟斤拷锟斤拷锟斤拷咏诘锟斤拷锟斤拷涓革拷诘锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷桑锟揭拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷删锟斤拷锟节点，锟斤拷为锟斤拷诘锟矫伙拷懈锟斤拷诘锟�
		else {
			return deleteOneChild(current, isLeftChild);
		}
		
	}
	
	public boolean deleteNoChild(BNode node, boolean isLeftChild) {
		if(node == root) {
			root = null;
			return true;
		}
		if(isLeftChild) {
			node.parent.leftChild = null;
		}
		else {
			node.parent.rightChild = null;
		}
		return true;
	}
	
	public boolean deleteOneChild(BNode node, boolean isLeftChild) {
		if(node.leftChild == null) {
			if(node == root) {
				root = node.rightChild;
				node.parent = null;
				return true;
			}
			if(isLeftChild) {
				node.parent.leftChild  = node.rightChild;
			}
			else {
				node.parent.rightChild = node.rightChild;
			}
			node.rightChild.parent = node.parent;
		}
		else {
			if(node == root) {
				root = node.leftChild;
				node.parent = null;
				return true;
			}
			if(isLeftChild) {
				node.parent.leftChild  = node.leftChild;
			}
			else {
				node.parent.rightChild = node.leftChild;
			}
			node.leftChild.parent = node.parent;
		}
		return true;
	}
	
	public boolean deleteTwoChild(BNode node, boolean isLeftChild) {
		BNode successor = getSuccessor(node);
		if(node == root) {
			successor.leftChild = root.leftChild;
			successor.rightChild = root.rightChild;
			successor.parent = null;
			root = successor;
		}
		else if(isLeftChild) {
			node.parent.leftChild = successor;
		}
		else {
			node.parent.rightChild = successor;
		}
		successor.leftChild = node.leftChild;//connect successor to node's left child
		return true;
	}
	
	//锟斤拷锟揭撅拷锟节碉拷暮锟教节点（锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟节点）
	public BNode getSuccessor(BNode delNode) {
		BNode successor = delNode;
		BNode current = delNode.rightChild;
		while(current != null) {
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild) {
			successor.parent.leftChild = successor.rightChild;
			if(successor.rightChild != null) {		
				successor.rightChild.parent = successor.parent;//删锟斤拷锟斤拷锟节碉拷锟斤拷原锟斤拷锟斤拷位锟斤拷
			}
			successor.rightChild = delNode.rightChild;//锟斤拷锟斤拷锟斤拷诘锟脚碉拷锟斤拷确位锟矫ｏ拷锟斤拷锟揭憋拷锟斤拷锟斤拷
		}
		return successor;
	}
}
 
class BNode {
	public int key;
	public double data;
	public BNode parent;
	public BNode leftChild;
	public BNode rightChild;
	
	public void displayNode() {
		System.out.println("{" + key + ":" + data + "}");
	}
}

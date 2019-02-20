package com.huang.datastruct.study.btree;

import com.huang.datastruct.study.rbtree.BNode;

/**
 * 浜屽弶鎺掑簭镙态ST
 * 
 * @author Administrator 瀹炵幇鏂规硶锛?镆ユ垒 阆嶅巻 鍒犻櫎 鎻掑叆
 *
 */
public class BinarySortTree {
	protected BNode root;

	public BinarySortTree() {
		root = null;
	}

	/**
	 * 瀹氢箟涓€涓狟Node浣滀负result杩斿洖 褰搑esult.key鍜屾煡镓剧殑鍐呭涓崭竴镙凤紝灏变竴鐩村惊鐜?灏忥紝鍒椤悜宸︼紝澶у垯鍚戝彸
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
		// 镙规嵁浼犲叆镄勫弬鏁版瀯阃犱竴涓妭镣?
		BNode newNode = new BNode();
		newNode.key = key;
		newNode.data = value;

		if (root == null) { // if tree is null
			root = newNode;
		} else {
			// current琛ㄧず鎻掑叆镄勪綅缃紝parent鏄彃鍏ヤ綅缃殑鐖惰妭镣广€?
			BNode current = root;
			BNode parent;
			while (true) {
				parent = current;//鍦ㄦ洿鏂瘫urrent涔嫔墠锛屽厛淇濆瓨current链煎埌parent
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
	 * 阆嶅巻
	 * 
	 * @param traverseType
	 */
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.println("Preorder traversal:");
			preOrder(root);// 鍓嶅簭阆嶅巻
			break;
		case 2:
			System.out.println("Inorder traversal:");
			inOrder(root);// 涓簭阆嶅巻
			break;
		case 3:
			System.out.println("Postorder traversal:");
			postOrder(root);// 鍚庡簭阆嶅巻
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
			System.out.print(localRoot.data + " ");// 镓揿嵃data灏卞畲浜嬩简
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
		// 鍒ゆ柇Node鏄笉鏄埗鑺傜偣镄勫乏鑺傜偣
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
		// 鍏堟垒鍒板瓙鑺傜偣锛屼笉闇€瑕佺浠栨槸宸︽槸鍙?
		BNode child = null;
		if (node.left != null) {
			child = node.left;
		} else {
			child = node.right;
		}

		// 杩欓噷蹇界暐浜嗙埗鑺傜偣涓嶅瓨鍦ㄧ殑鎯呭喌锛屾渶鍚庝细宸у镄勫鐞呜繖绉嶆儏鍐?
		// 灏嗙埗鑺傜偣鍜屽瓙鑺傜偣寤虹珛鍏崇郴
		if (node.parent.left == node) {
			node.parent.left = child;
		} else {
			node.parent.right = child;
		}

		child.parent = node.parent;
		return true;
	}

	/**
	 * 1.銮峰彇瑕佸垹闄よ妭镣圭殑鍚庣户鑺傜偣 2.杞Щ链?3.鍒犻櫎鍚庣户鑺傜偣銆?
	 * 
	 * @param node
	 * @param isLeftChild
	 * @return
	 */
	public boolean deleteTwoChild(BNode node) {
		// 銮峰彇鍚庣户缁撶偣
		BNode successor = getSuccessor(node);
		// 杞Щ鍚庣户缁撶偣链煎埌褰揿墠鑺傜偣
		node.key = successor.key;

		// 鎶婅鍒犻櫎镄勫綋鍓嶈妭镣硅缃负鍚庣户缁撶偣
		// 缁忚绷鍓崭竴姝ュ鐞嗭紝涓嬮溃鍙湁鍓崭袱绉嶆儏鍐碉紝鍙兘鏄竴涓妭镣规垨钥呮病链夎妭镣?
		// 鍚庣户鑺傜偣涓€瀹氢笉浼氭湁宸﹁妭镣癸紝浣嗘槸涓€瀹氭湁鍙宠妭镣?
		node = successor;
		if (node.right == null) {
			return deleteNoChild(node);
		} else {
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



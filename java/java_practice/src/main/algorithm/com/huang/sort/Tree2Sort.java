package com.huang.sort;

public class Tree2Sort {
	private Node root;

	public Tree2Sort() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void insertSort(int[] source) {
		for (int i = 0; i < source.length; i++) {
			int value = source[i];
			Node node = new Node(value);
			if (root == null) {
				root = node;
			} else {
				Node current = root;
				Node parent;
				boolean insertedOK = false;
				while (!insertedOK) {
					parent = current;
					if (value < current.value) {
						current = current.leftChild;
						if (current == null) {
							parent.leftChild = node;
							insertedOK = true;
						}
					} else {
						current = current.rightChild;
						if (current == null) {
							parent.rightChild = node;
							insertedOK = true;
						}
					}
				}

			}
		}
	}

	// ÖÐÐò±éÀú
	public void inOrder(Node current) {
		if (current != null) {
			inOrder(current.leftChild);
			System.out.print(current.value + " ");
			inOrder(current.rightChild);
		}
	}
}

class Node {
	public int value;
	Node leftChild;
	Node rightChild;

	public Node(int val) {
		value = val;
	}
}
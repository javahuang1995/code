package com.huang.sort;

import java.util.Arrays;

public class Tree2Sort {
	private Node root;

	public Tree2Sort() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}
	
	public static void main(String[] args) {
		Tree2Sort treesort = new Tree2Sort();
		int[] a = { 2, 3, 5, 1, 23, 6, 78, 34, 23, 4, 5, 78, 34, 65, 32, 65, 76, 32, 76, 1, 9 };
		treesort.insertSort(a);
		treesort.inOrder(treesort.root);
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

	// 中序遍历
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
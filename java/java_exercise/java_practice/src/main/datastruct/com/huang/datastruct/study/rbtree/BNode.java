package com.huang.datastruct.study.rbtree;
public class BNode {
	public int key;
	public double data;
	public BNode parent;
	public BNode left;
	public BNode right;

	public void displayNode() {
		System.out.println("{" + key + ":" + data + "}");
	}
}
package com.main3;

/**
 * 
 * @author Administrator 黄宁 2018-4-21下午02:27:48
 */
public class Solution {
	static  class  TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length
				|| in.length < 1) {
			return null;
		}
		return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	/**
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 
	 * @param preorder
	 *            前序遍历
	 * @param ps
	 *            前序遍历的开始位置
	 * @param pe
	 *            前序遍历的结束位置
	 * @param inorder
	 *            中序遍历
	 * @param is
	 *            中序遍历的开始位置
	 * @param ie
	 *            中序遍历的结束位置
	 * @return 树的根结点
	 */
	public  static TreeNode construct(int[] preorder, int ps, int pe,
			int[] inorder, int is, int ie) {
		if (ps > pe) {
			return null;
		}
		int value = preorder[ps];
		int index = is;
		while (index <= ie && inorder[index] != value) {
			index++;
		}
		if (index > ie) {
			throw new RuntimeException("Invalid Input");
		}
		TreeNode node = new TreeNode(value);

		node.left = construct(preorder, ps + 1, ps + index - is, inorder, is,
				index - 1);
		node.right = construct(preorder, ps + index - is + 1, pe, inorder,
				index + 1, ie);

		return node;
	}

	// 中序遍历二叉树
	public static void printTree(TreeNode root) {
		if (root != null) {
			printTree(root.left);
			System.out.print(root.val + " ");
			printTree(root.right);
		}

	}
	
	
    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
       TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }
    
    public static void main(String[] args) {
		test1();
		System.out.println();
	}
    
    
    
}
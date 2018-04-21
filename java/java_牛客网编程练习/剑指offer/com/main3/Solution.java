package com.main3;

/**
 * 
 * @author Administrator ���� 2018-4-21����02:27:48
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
	 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
	 * 
	 * @param preorder
	 *            ǰ�����
	 * @param ps
	 *            ǰ������Ŀ�ʼλ��
	 * @param pe
	 *            ǰ������Ľ���λ��
	 * @param inorder
	 *            �������
	 * @param is
	 *            ��������Ŀ�ʼλ��
	 * @param ie
	 *            ��������Ľ���λ��
	 * @return ���ĸ����
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

	// �������������
	public static void printTree(TreeNode root) {
		if (root != null) {
			printTree(root.left);
			System.out.print(root.val + " ");
			printTree(root.right);
		}

	}
	
	
    // ��ͨ������
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
package prj_04;

import java.util.Stack;

/**
 * 20190507
 * @author Liu
 * 判断一棵二叉树是否是二叉搜索树/二叉排序树/二叉查找树
 * 思路：
 * 非递归中序遍历，升序则为二叉搜索树
 */
public class Code_06_BinarySearchTree {
	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
		public static boolean isBST(Node head) {
			if(head==null)
				return true;
			boolean flag = false;
			Stack<Node> mystack = new Stack<>();
			Node cur = head;
			Node before = new Node(Integer.MIN_VALUE);
			while(!mystack.isEmpty() || cur!=null) {
				if(cur!=null) {
					mystack.add(cur);
					cur = cur.left;
				}
				else {
					cur = mystack.pop();
					flag = cur.val>before.val? true : false;
					before = cur;
					cur = cur.right;
				}
			}
			return flag;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(60);
		Node n2 = new Node(30);
		Node n3 = new Node(80);
		Node n4 = new Node(20);
		Node n5 = new Node(40);
		Node n6 = new Node(70);
		Node n7 = new Node(90);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		System.out.println(Node.isBST(n1));
	}

}

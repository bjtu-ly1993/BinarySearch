package prj_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 20190507 AM
 * @author Liu
 * 需求：判断一棵二叉树是否是完全二叉树
 * 思路：
 * 1.按层遍历
 * 2.若某个节点没有左孩子，有右孩子，不是完全二叉树
 * 3.若某个节点有左孩子没有右孩子，或者左右孩子都没有，则需要继续遍历，若后面出现非
 * 叶子节点，则不是完全二叉树。
 */
public class Code_07_CompleteBinaryTree {
	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
		public static boolean isCBT(Node head) {
			if(head==null)
				return false;
			Queue<Node> myqueue = new LinkedList<>();
			boolean flag = false;
			myqueue.offer(head);
			Node node = null;
			while(!myqueue.isEmpty()) {
				node = myqueue.poll();
				//后续不能出现叶子结点
				if(flag==true) {
					if(node.left!=null || node.right!=null) {
						flag = false;
						break;
					}	
				}
				//没有左孩子但有右孩子不是完全二叉树
				if(node.left==null && node.right!=null) {
					flag = false;
					break;
				}
				//有左孩子没有右孩子，左孩子右孩子都没有，进入判断状态，若接下来出现不是叶子节点的则不是CBT
				if(node.right==null) {
					flag = true;
				}
				//按层遍历
				if(node.left!=null)
					myqueue.offer(node.left);
				if(node.right!=null)
					myqueue.offer(node.right);
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
		
		System.out.println(Node.isCBT(n1));
	}

}

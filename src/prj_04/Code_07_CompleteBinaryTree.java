package prj_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 20190507 AM
 * @author Liu
 * �����ж�һ�ö������Ƿ�����ȫ������
 * ˼·��
 * 1.�������
 * 2.��ĳ���ڵ�û�����ӣ����Һ��ӣ�������ȫ������
 * 3.��ĳ���ڵ�������û���Һ��ӣ��������Һ��Ӷ�û�У�����Ҫ������������������ַ�
 * Ҷ�ӽڵ㣬������ȫ��������
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
				//�������ܳ���Ҷ�ӽ��
				if(flag==true) {
					if(node.left!=null || node.right!=null) {
						flag = false;
						break;
					}	
				}
				//û�����ӵ����Һ��Ӳ�����ȫ������
				if(node.left==null && node.right!=null) {
					flag = false;
					break;
				}
				//������û���Һ��ӣ������Һ��Ӷ�û�У������ж�״̬�������������ֲ���Ҷ�ӽڵ������CBT
				if(node.right==null) {
					flag = true;
				}
				//�������
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

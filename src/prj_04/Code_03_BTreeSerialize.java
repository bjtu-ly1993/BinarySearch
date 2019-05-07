package prj_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 20190506 PM
 * @author Liu
 * ���������л�
 * ˼·��
 * ���л��ǵݹ��˼·�������������򡢺�����˵���ǵ�ǰ�ڵ�Ĵ������������صĴ������������صĴ�
 * ���ڰ��������˵������Ҫʵ��һ�ö���������������������еĵ������������Ʋ��������Ҫ�ж��Ƿ���
 * null,��nullȡleft/right������
 */
public class Code_03_BTreeSerialize {
	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
		//����������л�
		public static String preSerialize(Node head) {
			if(head==null)
				return new String("#!");
			String s1 = new String(head.val+"!");
			String s2 = preSerialize(head.left);
			String s3 = preSerialize(head.right);
			return s1+s2+s3;
		}
		//����������л�
		public static String midSerialize(Node head) {
			if(head==null)
				return new String("#!");
			String s2 = midSerialize(head.left);
			String s1 = new String(head.val+"!");
			String s3 = midSerialize(head.right);
			return s2+s1+s3;
		}
		//����������л�
		public static String aftSerialize(Node head) {
			if(head==null)
				return new String("#!");
			String s2 = aftSerialize(head.left);
			String s3 = aftSerialize(head.right);
			String s1 = new String(head.val+"!");
			return s2+s3+s1;
		}
		//����������л�
		public static String levelSerialize(Node head) {
			if(head==null)
				return new String("#!");
			Queue<Node> myqueue = new LinkedList<>();
			myqueue.add(head);
			String s = "";
			while(!myqueue.isEmpty()) {
				s += myqueue.peek().val+"!";
				if(myqueue.peek().val!=-1) {
					if(myqueue.peek().left!=null)
						myqueue.add(myqueue.peek().left);
					else
						myqueue.add(new Node(-1));
					if(myqueue.peek().right!=null)
						myqueue.add(myqueue.peek().right);
					else
						myqueue.add(new Node(-1));
					myqueue.poll();
				}
				else {
					myqueue.poll();
				}
			}
			return s;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		String s = Node.preSerialize(n1);
		System.out.println(s);
		s = Node.midSerialize(n1);
		System.out.println(s);
		s = Node.aftSerialize(n1);
		System.out.println(s);
		s = Node.levelSerialize(n1);
		System.out.println(s);
	}

}

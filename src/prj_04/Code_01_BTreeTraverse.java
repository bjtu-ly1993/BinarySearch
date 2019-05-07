package prj_04;
import java.util.Stack;
/**
 * 20190505 PM
 * @author Liu
 *   �������ķǵݹ����
 * 1.���������
 * a.׼��һ��ջ������ͷ�ڵ���ջ
 * b.��ջ�ǿ�ʱ���ȴ�ӡջ��Ԫ�أ������ν�ջ�����Һ��ӡ����ӷֱ���ջ��
 * c.���Ե�����˳��Ϊ�������ң����ϵ���
 * 2.���������
 * a.׼��һ��ջ
 * b.��ǰָ��ָ��ͷ���
 * c.��ջ�ǿջ��ߵ�ǰָ��ǿյ�ʱ�����ѭ��
 * d.��ǰָ��ǿյ�ʱ�򣬽���ǰָ��Ԫ����ջ��ָ����ָ������
 * e.��ǰָ��Ϊ�յ�ʱ�򣬽�ջ��Ԫ�ص��������������ǰָ��ָ�򵯳��ڵ���Һ���
 * 3.�������
 * a.׼������ջ����ͷ������һ��ջ
 * b.����һ��ջ�ǿ�ʱ������һ��ջ��ջ��Ԫ�ص�����ڶ���ջ�������ν���һ��ջ�������ӡ��Һ��ӷֱ����һ��ջ
 * c.�ڶ���ջ��ջ˳��(��һ��ջ����˳��)����->��->��  �ڶ���ջ����˳����->��->��
 */
public class Code_01_BTreeTraverse {
	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
		public static void preTraverse(Node head) {
			if(head==null) {
				return ;
			}
			Stack<Node> mystack = new Stack<>();
			mystack.add(head);
			while(!mystack.isEmpty()) {
				System.out.print(mystack.peek().val+"->");
				Node tmp = mystack.pop();
				if(tmp.right!=null) {
					mystack.add(tmp.right);
				}
				if(tmp.left!=null) {
					mystack.add(tmp.left);
				}
			}
		}
		public static void midTraverse(Node head) {
			if(head==null) {
				return ;
			}
			Stack<Node> mystack = new Stack<>();
			Node cur = head;
			while(!mystack.isEmpty() || cur!=null) {
				if(cur!=null) {
					mystack.push(cur);
					cur = cur.left;
				}
				else {
					System.out.print(mystack.peek().val+"->");
					cur = mystack.pop().right;
				}
			}
		}
		public static void aftTraverse(Node head) {
			if(head==null) {
				return ;
			}
			Stack<Node> mystack = new Stack<>();
			Stack<Node> mystack2 = new Stack<>();
			mystack.add(head);
			while(!mystack.isEmpty()) {
				Node tmp = mystack.pop();
				mystack2.push(tmp);
				if(tmp.left!=null) {
					mystack.add(tmp.left);
				}
				if(tmp.right!=null) {
					mystack.add(tmp.right);
				}
			}
			while(!mystack2.isEmpty()) {
				System.out.print(mystack2.pop().val+"->");
			}
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
		
		Node.preTraverse(n1);
		System.out.print("\n");
		Node.aftTraverse(n1);
		System.out.print("\n");
		Node.midTraverse(n1);
	}

}

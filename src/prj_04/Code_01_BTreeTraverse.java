package prj_04;
import java.util.Stack;
/**
 * 20190505 PM
 * @author Liu
 *   二叉树的非递归遍历
 * 1.先序遍历：
 * a.准备一个栈，先让头节点入栈
 * b.当栈非空时，先打印栈顶元素，在依次将栈顶的右孩子、左孩子分别入栈。
 * c.所以弹出的顺序为根，左，右，从上到下
 * 2.中序遍历：
 * a.准备一个栈
 * b.当前指针指向头结点
 * c.当栈非空或者当前指针非空的时候进入循环
 * d.当前指针非空的时候，将当前指针元素入栈，指针再指向左孩子
 * e.当前指针为空的时候，将栈顶元素弹出输出，并将当前指针指向弹出节点的右孩子
 * 3.后序遍历
 * a.准备两个栈，让头结点入第一个栈
 * b.当第一个栈非空时，将第一个栈的栈顶元素弹出入第二个栈，再依次将第一个栈顶的左孩子、右孩子分别入第一个栈
 * c.第二个栈入栈顺序(第一个栈弹出顺序)：根->右->左  第二个栈弹出顺序：左->右->根
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

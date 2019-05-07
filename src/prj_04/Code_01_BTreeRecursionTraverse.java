package prj_04;
/**
 * 20190505 AM
 * @author Liu
 *    ¶þ²æÊ÷µÝ¹é±éÀú
 */
public class Code_01_BTreeRecursionTraverse {
	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
		public static void preTraverse(Node head) {
			if(head==null)
				return ;
			else {
				System.out.print(head.val+"->");
				preTraverse(head.left);
				preTraverse(head.right);
			}
		}
		public static void midTraverse(Node head) {
			if(head==null)
				return ;
			else {
				midTraverse(head.left);
				System.out.print(head.val+"->");
				midTraverse(head.right);
			}
		}
		public static void aftTraverse(Node head) {
			if(head==null)
				return ;
			else {
				aftTraverse(head.left);
				aftTraverse(head.right);
				System.out.print(head.val+"->");
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
		Node.midTraverse(n1);
		System.out.print("\n");
		Node.aftTraverse(n1);
	}

}

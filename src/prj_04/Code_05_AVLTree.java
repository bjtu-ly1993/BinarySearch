package prj_04;
/**
 * 20190506 PM
 * @author Liu
 *  需求：判断一棵树是否为平衡二叉树
 *  定义：对于任意一个节点左，右子树高度差的绝对值不超过1
 */
public class Code_05_AVLTree {
	public static class Returntype{
		boolean balance;
		int height;
		Returntype(boolean balance,int height){
			this.balance = balance;
			this.height = height;
		}
	}
	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
		public static Returntype isAvlTree(Node head) {
			if(head==null) {
				return new Returntype(true,0);
			}
			Returntype left = isAvlTree(head.left);
			if(left.balance==false) 
				return new Returntype(false,0);
			Returntype right = isAvlTree(head.right);
			if(right.balance==false) 
				return new Returntype(false,0);
			if(Math.abs(left.height-right.height)>1)
				return new Returntype(false,0);
			else
				return new Returntype(true,Math.max(left.height,right.height)+1);
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
		Node n8 = new Node(80);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		Returntype ret = Node.isAvlTree(n1);
		System.out.println(ret.balance+" "+ret.height);
	}

}

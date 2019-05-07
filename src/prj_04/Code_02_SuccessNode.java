package prj_04;
/**
 * 20190505 PM
 * @author Liu
 *   需求：在二叉树中找到某一个节点的后继节点
 *   后继节点：中序遍历中的某个节点后面的节点
 *   每个节点多了指向Parent的指针
 *   
  *  思路：
  *  1.如果当前节点有右子树，则右子树最左面的那个节点就是后继节点
  *  2.如果当前节点没有右子树，则找到使得当前节点为某个节点左子树最后访问的节点的那个节点
  *      实现方法：cur和parent指针，当cur为parent的左孩子，则parent就是后继节点
 */
public class Code_02_SuccessNode {
	public static class Node{
		int val;
		Node left;
		Node right;
		Node Parent;
		public Node(int val) {
			this.val = val;
		}
		public static Node findSuccessNode(Node node) {
			Node cur  = node;
			Node parent = node.Parent;
			Node sucnode = null;
			if(cur.right!=null) {
				cur = cur.right;
				while(cur.left!=null) {
					cur = cur.left;
				}
				sucnode = cur;
			}
			else {
				while(parent!=null) {
					if(cur==parent.left) {
						sucnode = parent;
						break;
					}
					else {
						cur = cur.Parent;
						parent = parent.Parent;
					}
				}
				if(parent==null) {
					sucnode = null;
				}
			}
			return sucnode;
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
		n1.Parent = null;
		n2.left = n4;
		n2.right = n5;
		n2.Parent = n1;
		n3.left = n6;
		n3.right = n7;
		n3.Parent = n1;
		n4.Parent = n2;
		n5.Parent = n2;
		n6.Parent = n3;
		n7.Parent = n3;
		
		Node successnode = Node.findSuccessNode(n7);
		if(successnode==null) {
			System.out.println("No success node");
		}
		else{
			System.out.println(successnode.val);
		}
	}

}

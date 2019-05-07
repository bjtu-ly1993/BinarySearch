package prj_04;

/**
 * 20190507 AM
 * @author Liu
 * 需求：求完全二叉树的节点个数，时间复杂度低于O(N),N为树的节点个数
 * 知识点：满二叉树的节点个数2^k-1，k为树的深度
 * 思路：
 * 1.求数的深度
 * 2.求当前节点右子树的深度，若深度加当前节点的高度达到了整个树深
 * 则当前节点的左子树满，利用公式求出左子树深度，右子树迭代
 * 3.若深度加当前节点的高度没有达到了整个树深，则右子树满，左子树迭代
 */
public class Code_08_NodeNumofCBT {
	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
		//求二叉树树高
		public static int treeHeight(Node head) {
			int h = 0;
			while(head!=null) {
				h++;
				head = head.left;
			}
			return h;
		}
		//注意返回值中的移位一定要分开写否则会错乱，因为level在进子函数前会变化，出来之后不知道怎么变
		public static int nodeCnt(Node head,int level,int h) {
			if(level>h)    //叶子节点
				return 0;
			int RightTreeH = treeHeight(head.right);
			if(level+RightTreeH==h) {
				int s1 = 1<<(h-level);
				return s1 + nodeCnt(head.right,++level,h);
			}
			else {
				int s2 = 1<<(h-level-1);
				return s2+nodeCnt(head.left,++level,h);
			}
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
		
		System.out.println(Node.nodeCnt(n1, 1, Node.treeHeight(n1)));
	}

}

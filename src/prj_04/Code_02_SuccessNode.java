package prj_04;
/**
 * 20190505 PM
 * @author Liu
 *   �����ڶ��������ҵ�ĳһ���ڵ�ĺ�̽ڵ�
 *   ��̽ڵ㣺��������е�ĳ���ڵ����Ľڵ�
 *   ÿ���ڵ����ָ��Parent��ָ��
 *   
  *  ˼·��
  *  1.�����ǰ�ڵ���������������������������Ǹ��ڵ���Ǻ�̽ڵ�
  *  2.�����ǰ�ڵ�û�������������ҵ�ʹ�õ�ǰ�ڵ�Ϊĳ���ڵ������������ʵĽڵ���Ǹ��ڵ�
  *      ʵ�ַ�����cur��parentָ�룬��curΪparent�����ӣ���parent���Ǻ�̽ڵ�
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

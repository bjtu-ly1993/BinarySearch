package prj_04;

/**
 * 20190507 AM
 * @author Liu
 * ��������ȫ�������Ľڵ������ʱ�临�Ӷȵ���O(N),NΪ���Ľڵ����
 * ֪ʶ�㣺���������Ľڵ����2^k-1��kΪ�������
 * ˼·��
 * 1.���������
 * 2.��ǰ�ڵ�����������ȣ�����ȼӵ�ǰ�ڵ�ĸ߶ȴﵽ����������
 * ��ǰ�ڵ���������������ù�ʽ�����������ȣ�����������
 * 3.����ȼӵ�ǰ�ڵ�ĸ߶�û�дﵽ�������������������������������
 */
public class Code_08_NodeNumofCBT {
	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
		//�����������
		public static int treeHeight(Node head) {
			int h = 0;
			while(head!=null) {
				h++;
				head = head.left;
			}
			return h;
		}
		//ע�ⷵ��ֵ�е���λһ��Ҫ�ֿ�д�������ң���Ϊlevel�ڽ��Ӻ���ǰ��仯������֮��֪����ô��
		public static int nodeCnt(Node head,int level,int h) {
			if(level>h)    //Ҷ�ӽڵ�
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

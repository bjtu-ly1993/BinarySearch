package prj_03;
/**
 * 20190428
 * @author Liu
 * ˼·��
 * 1.��ԭ���Ĵ�������С��kֵ������kֵ������kֵ����Ϊ����С����
 * 2.������С����ͷβ����
 * 3.ע��߽�ֵ(����ĳ������Ϊ��)
 * 4.�÷������Ա�֤ԭʼ˳���Ҳ�ռ�ö���ռ�
 */
public class Code10_LinkListPointer_Method2 {
	public static class SingleList{
		public int elem;
		public SingleList next;
		public SingleList(int elem) {
			this.elem = elem;
		}
		public static void printSingleList(SingleList head) {
			SingleList tmp = head;
			while(tmp!=null) {
				if(tmp.next==null) {
					System.out.print(tmp.elem);
					tmp = tmp.next;
				}
				else {
					System.out.print(tmp.elem+"->");
					tmp = tmp.next;
				}
			}
		}
		public static SingleList netherPointer(SingleList head,int key) {
			SingleList traverse = head;
			SingleList minus_head = null;
			SingleList minus_end = null;
			SingleList equals_head = null;
			SingleList equals_end = null;
			SingleList max_head = null;
			SingleList max_end = null;
			SingleList new_head = null;
			while(traverse!=null) {
				if(traverse.elem==key) {
					SingleList tmp = new SingleList(traverse.elem);//ע������Ҫ���·���ռ䣬����ͺ�ԭ��һ��
					if(equals_head==null) {
						equals_head = tmp;
						equals_end = equals_head;  //��һ���ڵ���Ҫ��ͷ����β�ڵ㶼ȷ������
					}
					else {
						equals_end.next = tmp;   //���β���β�ͣ���end����β�͵�λ��
						equals_end = tmp;
					}
					traverse = traverse.next;
				}
				else if(traverse.elem<key) {
					SingleList tmp = new SingleList(traverse.elem);
					if(minus_head==null) {
						minus_head = tmp;
						minus_end = minus_head;
					}
					else {
						minus_end.next = tmp;
						minus_end = tmp;
					}
					traverse = traverse.next;
				}
				else {
					SingleList tmp = new SingleList(traverse.elem);
					if(max_head==null) {
						max_head = tmp;
						max_end = max_head;
					}
					else {
						max_end.next = tmp;
						max_end = tmp;
					}
					traverse = traverse.next;
				}
			}
			//�߽������жϣ���û�����е�ĳһ���ָ���ô��
			if(minus_head==null) {
				equals_end.next = max_head;
				new_head = equals_head;
			}
			else if(equals_head==null) {
				minus_end.next = max_head;
				new_head = minus_head;
			}
			else if(max_head==null) {
				minus_end.next = equals_head;
				new_head = minus_head;
			}
			else if(minus_head==null && equals_head==null) {
				new_head = max_head;
			}
			else if(minus_head==null && max_head==null) {
				new_head = equals_head;
			}
			else if(max_head==null && equals_head==null) {
				new_head = minus_head;
			}
			else {
				minus_end.next = equals_head;
				equals_end.next = max_head;
				new_head = minus_head;
			}
		return new_head;
		}
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleList s1 = new SingleList(50);
		SingleList s2 = new SingleList(20);
		SingleList s3 = new SingleList(30);
		SingleList s4 = new SingleList(30);
		SingleList s5 = new SingleList(60);
		SingleList s6 = new SingleList(10);
		SingleList s7 = new SingleList(45);
		s1.next = s2;
		s2.next = s3;
		s3.next = s4;
		s4.next = s5;
		s5.next = s6;
		s6.next = s7;
		s7.next = null;
		
		SingleList.printSingleList(s1);
		SingleList head = SingleList.netherPointer(s1,10);
		
		System.out.println("\n");
		SingleList.printSingleList(head);	
	}
}

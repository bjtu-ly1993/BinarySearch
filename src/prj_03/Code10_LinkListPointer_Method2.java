package prj_03;
/**
 * 20190428
 * @author Liu
 * 思路：
 * 1.将原来的大链表按照小于k值，等于k值，大于k值划分为三条小链表
 * 2.将三条小链表头尾相连
 * 3.注意边界值(可能某条链表为空)
 * 4.该方法可以保证原始顺序，且不占用额外空间
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
					SingleList tmp = new SingleList(traverse.elem);//注意这里要重新分配空间，否则就和原来一样
					if(equals_head==null) {
						equals_head = tmp;
						equals_end = equals_head;  //第一个节点需要把头结点和尾节点都确定出来
					}
					else {
						equals_end.next = tmp;   //依次插入尾巴，用end保存尾巴的位置
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
			//边界条件判断，若没有其中的某一部分该怎么办
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

package prj_03;
/**
 * 20190426
 * @author Liu
 * 需求：打印两个有序链表的公共部分
 */
public class Code09_LinkCommnElem {
	public static class SingleList{
		public int elem;
		public SingleList next;
		public SingleList(int elem) {
			this.elem = elem;
		}
		public void printSingleList(SingleList head) {
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
		public static void printCommn(SingleList head1,SingleList head2) {
			SingleList p = head1;
			SingleList q = head2;
			while(p!=null && q!=null) {
				if(p.elem==q.elem) {
					System.out.println(p.elem);
					p = p.next;
					q = q.next;
				}
				else if(p.elem<q.elem) {
					p = p.next;
				}
				else {
					q = q.next;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleList s1 = new SingleList(10);
		SingleList s2 = new SingleList(20);
		SingleList s3 = new SingleList(30);
		s1.next = s2;
		s2.next = s3;
		s3.next = null;
		
		SingleList s4 = new SingleList(20);
		SingleList s5 = new SingleList(30);
		SingleList s6 = new SingleList(40);
		s4.next = s5;
		s5.next = s6;
		s6.next = null;
		
		SingleList.printCommn(s1, s4);
		
	}

}

package prj_03;

public class Code05_ReverseLinkedList {
	public static class SingleList{
		public int elem;
		public SingleList next;
		public SingleList(int elem) {
			this.elem = elem;
		}
		public SingleList reverseSingleList(SingleList head) {
			SingleList pre = null;
			SingleList next = null;
			while(head!=null) {
				next = head.next;
				head.next = pre;
				pre = head;
				head = next;
			}
			return pre;
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
	}
	public static class DoubleList{
		public int elem;
		public DoubleList leftp;
		public DoubleList rightp;
		public DoubleList(int elem) {
			this.elem = elem;
		}
		public DoubleList reverseDoubleList(DoubleList head) {
			DoubleList pre = null;
			DoubleList next = null;
			while(head!=null) {
				next = head.rightp;
				head.rightp = pre;
				head.leftp = next;
				pre = head;
				head = next;
			}
			return pre;
		}
		public void printDoubleList(DoubleList head) {
			DoubleList tmp = head;
			while(tmp!=null) {
				if(tmp.rightp==null) {
					System.out.print(tmp.elem);
					tmp = tmp.rightp;
				}
				else {
					System.out.print(tmp.elem+"->");
					tmp = tmp.rightp;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SingleList s1 = new  SingleList(10);
//		SingleList s2 = new  SingleList(20);
//		SingleList s3 = new  SingleList(30);
//		s1.next = s2;
//		s2.next = s3;
//		s3.next = null;
//		s1.printSingleList(s1);
//		SingleList tmp = s1.reverseSingleList(s1);
//		System.out.println("\n");
//		s1.printSingleList(tmp);
		
		DoubleList s1 = new  DoubleList(10);
		DoubleList s2 = new  DoubleList(20);
		DoubleList s3 = new  DoubleList(30);
		s1.rightp = s2;
		s1.leftp = null;
		s2.rightp = s3;
		s2.leftp = s1;
		s3.rightp = null;
		s3.leftp =s2;
		s1.printDoubleList(s1);
		DoubleList tmp = s1.reverseDoubleList(s1);
		System.out.println("\n");
		s1.printDoubleList(tmp);
	}

}

package prj_03;
/**
 * 20190429 PM
 * @author Liu
 * 用指针的方式判断链表是否有环
 * 算法：
 * 1.设置快慢指针，快指针每次走2步，慢指针每次走1步
 * 2.如果有环的话，由于快指针速度比慢指针块，因此会追上慢指针
 * 3.在追击点处，满指针继续走，同时头指针继续走，两个必相遇到入环节点
 */
public class Code11_LoopLinkList_Method2 {
	public static class SingleList{
	public int elem;
	public SingleList next;
	public SingleList(int elem) {
		this.elem = elem;
	}
	public static SingleList isLoop(SingleList head) {
		SingleList fastp = head;
		SingleList lowp = head;
		SingleList new_head = null;
		boolean loopflag = false;
		while(fastp!=null && fastp.next!=null) {
			fastp = fastp.next.next;
			lowp = lowp.next;
			if(fastp==lowp) {
				SingleList tmp_head = head;
				while(tmp_head!=lowp) {
					tmp_head = tmp_head.next;
					lowp = lowp.next;
				}
				new_head = lowp;
				loopflag = true;
				break;
			}
		}
		if(!loopflag) {
			return null;
		}
		else {
			return new_head;
		}
	}
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleList s1 = new SingleList(10);
		SingleList s2 = new SingleList(20);
		SingleList s3 = new SingleList(30);
		SingleList s4 = new SingleList(40);
		SingleList s5 = new SingleList(50);
		
		s1.next = s2;
		s2.next = s3;
		s3.next = s4;
		s4.next = s5;
		s5.next = s1;
		
		SingleList fisrtloopnode = SingleList.isLoop(s1);
		if(fisrtloopnode==null) {
			System.out.println("No loop");
		}
		else {
			System.out.println("Loop! "+fisrtloopnode.elem);
		}
	}

}

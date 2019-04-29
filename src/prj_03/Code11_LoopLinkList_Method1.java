package prj_03;
import java.util.HashSet;
/**
 * 20190429
 * @author Liu
 * 使用HashSet判断链表是否有环
 */
public class Code11_LoopLinkList_Method1 {
	public static class SingleList{
	public int elem;
	public SingleList next;
	public SingleList(int elem) {
		this.elem = elem;
	}
	public static SingleList isLoop(SingleList head) {
		SingleList tmp = head;
		SingleList firstin = null;
		HashSet<SingleList> myset= new HashSet<>();
		boolean loopflag = false;
		while(tmp!=null) {
			if(myset.contains(tmp)) {
				loopflag = true;
				firstin = tmp;
				break;
			}
			myset.add(tmp);
			tmp = tmp.next;
		}
		if(loopflag) 
			return firstin;
		else 
			return null;
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

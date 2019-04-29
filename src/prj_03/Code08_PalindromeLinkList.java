package prj_03;
/**
 * 20190426
 * @author Liu
 * 需求：判断一个链表是否是回文结构
 * 法1：利用栈结构，第一次遍历时从头到尾将每一个元素入栈，第二次遍历时，将栈中元素弹出并作对比
 * 法2：分别设置快慢指针，快指针每次2步，慢指针每次1步，快指针走完，慢指针刚好走一半
 *      将慢指针后面的链表逆置并与前面进行比较，最后再将链表反转回来
 */
public class Code08_PalindromeLinkList {
	public static class SingleList{
		public int elem;
		public SingleList next;
		public SingleList(int elem) {
			this.elem = elem;
		}
		public static boolean isPalindrome(SingleList head) {
			SingleList p_slow = head;
			SingleList p_fast = head;
			SingleList p_comp = head;
			boolean flag = true;
			while(p_fast.next!=null && p_fast.next.next!=null) {   //注意区分奇偶
				p_fast = p_fast.next.next;
				p_slow = p_slow.next;
			}
			SingleList cur = p_slow.next;
			SingleList pre = null;
			SingleList bac = null;
			while(cur!=null) {
				bac = cur.next;
				cur.next = pre;
				pre = cur;
				cur = bac;
			}
			SingleList tmp_head = pre;
			while(pre!=null) {
				if(pre.elem!=p_comp.elem) {
					flag = false;
					break;
				}
				pre = pre.next;
				p_comp = p_comp.next;
			}
			cur = tmp_head;
			pre = null;
			while(cur!=null) {
				bac = cur.next;
				cur.next = pre;
				pre = cur;
				cur = bac;
			}
			return flag;
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
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleList s1 = new SingleList(1);
		SingleList s2 = new SingleList(2);
		SingleList s3 = new SingleList(1);
		s1.next = s2;
		s2.next = s3;
		s3.next = null;
		boolean flag = SingleList.isPalindrome(s1);
		System.out.println(flag);
		SingleList.printSingleList(s1);
	}

}

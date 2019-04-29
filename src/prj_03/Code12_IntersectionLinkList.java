package prj_03;
/**
 * 20490429 PM
 * @author Liu
 * 需求：判断链表是否相交，若相交返回第一交点，若不相交返回null。
 * 其中链表可能有环，也可能无环
 * 要求时间复杂度O(N+M),N为链表1的长度，M为链表2的长度
 * 空间复杂度O(1)
 * 思路：
 * 1.判断每个链表是否有环，若有环返回第一个入环节点
 * 2.分三种情况讨论：
 *   A.一个链表有环，一个链表没环，不可能相交
 *   B.一个链表有环，另一个链表有环，可能相交也可能不相交
 *     相交的条件：从一个链表的入环节点出发可以到达另一个链表的入环节点
 *     求交点：将环点以下的部分忽略，分别求两个链表的头结点到环点的长度，然后调整长链表后(先走k步)，两个链表的第一次相遇点即为交点
 *   C.两个链表都没环，可能相交也可能不相交
 *     相交的条件：两个链表的尾节点相等
 *     求交点：分别求两个链表的头结点到末尾的长度，然后调整长链表后(先走k步)，两个链表的第一次相遇点即为交点
 */

public class Code12_IntersectionLinkList {
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
	public static SingleList isCross(SingleList head1,SingleList head2) {
		SingleList inloop1 = SingleList.isLoop(head1);
		SingleList inloop2 = SingleList.isLoop(head2);
		SingleList tmp_head1 = head1;
		SingleList tmp_head2 = head2;
		SingleList cross_first = null;
		int list_len1 = 0;
		int list_len2 = 0;
		if(inloop1==null && inloop2==null) {
			while(tmp_head1.next!=null) {
				tmp_head1 = tmp_head1.next;
			}
			while(tmp_head2.next!=null) {
				tmp_head2 = tmp_head2.next;
			}
			if(tmp_head1!=tmp_head2) {
				cross_first = null;
			}
			else
			{
				tmp_head1 = head1;
				tmp_head2 = head2;
				while(tmp_head1!=null) {
					list_len1++;
					tmp_head1 = tmp_head1.next;
				}
				while(tmp_head2!=null) {
					list_len2++;
					tmp_head2 = tmp_head2.next;
				}
				tmp_head1 = head1;
				tmp_head2 = head2;
				if(list_len1==list_len2) {
					while(tmp_head1!=tmp_head2) {
						tmp_head1 = tmp_head1.next;
						tmp_head2 = tmp_head2.next;
					}
					cross_first = tmp_head1;
				}
				else if(list_len1<list_len2) {
					int diff_cnt = list_len2-list_len1;
					while(diff_cnt>0) {
						tmp_head2 = tmp_head2.next;
						diff_cnt--;
					}
					while(tmp_head1!=tmp_head2) {
						tmp_head1 = tmp_head1.next;
						tmp_head2 = tmp_head2.next;
					}
					cross_first = tmp_head1;
				}
				else {
					int diff_cnt = list_len1-list_len2;
					while(diff_cnt>0) {
						tmp_head1 = tmp_head1.next;
						diff_cnt--;
					}
					while(tmp_head1!=tmp_head2) {
						tmp_head1 = tmp_head1.next;
						tmp_head2 = tmp_head2.next;
					}
					cross_first = tmp_head1;
				}
			}
		}
		else if(inloop1!=null && inloop2!=null) {
			boolean cross = false;
			SingleList traverse = inloop1.next;
			while(traverse!=inloop1) {
				traverse = traverse.next;
			}
			if(traverse==inloop2) {
				cross = true;
			}
			else {
				cross = false;
			}
			if(cross) {
				while(tmp_head1!=inloop1.next) {
					list_len1++;
					tmp_head1 = tmp_head1.next;
				}
				while(tmp_head2!=inloop2.next) {
					list_len2++;
					tmp_head2 = tmp_head2.next;
				}
				tmp_head1 = head1;
				tmp_head2 = head2;
				if(list_len1==list_len2) {
					while(tmp_head1!=tmp_head2) {
						tmp_head1 = tmp_head1.next;
						tmp_head2 = tmp_head2.next;
					}
					cross_first = tmp_head1;
				}
				else if(list_len1<list_len2) {
					int diff_cnt = list_len2-list_len1;
					while(diff_cnt>0) {
						tmp_head2 = tmp_head2.next;
						diff_cnt--;
					}
					while(tmp_head1!=tmp_head2) {
						tmp_head1 = tmp_head1.next;
						tmp_head2 = tmp_head2.next;
					}
					cross_first = tmp_head1;
				}
				else {
					int diff_cnt = list_len1-list_len2;
					while(diff_cnt>0) {
						tmp_head1 = tmp_head1.next;
						diff_cnt--;
					}
					while(tmp_head1!=tmp_head2) {
						tmp_head1 = tmp_head1.next;
						tmp_head2 = tmp_head2.next;
					}
					cross_first = tmp_head1;
				}
			}
			else {
				cross_first = null;
			}
		}
		else {
			cross_first = null;
		}
		return cross_first;
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleList s1 = new SingleList(10);
		SingleList s2 = new SingleList(20);
		SingleList s3 = new SingleList(30);
		SingleList s4 = new SingleList(40);
		
		s1.next = s2;
		s2.next = s3;
		s3.next = s4;
		s4.next = null;
		
		SingleList s5 = new SingleList(50);
		SingleList s6 = new SingleList(60);
		SingleList s7 = new SingleList(70);
		SingleList s8 = new SingleList(80);
		
		s5.next = s6;
		s6.next = s3;
		s3.next = s4;
		s4.next = null;
		
		SingleList cross_node = SingleList.isCross(s1,s5);
		
		if(cross_node!=null) {
			System.out.println(cross_node.elem);
		}
		else {
			System.out.println("No Cross");
		}
	}
}

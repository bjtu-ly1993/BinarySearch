package prj_03;
/**
 * 20490429 PM
 * @author Liu
 * �����ж������Ƿ��ཻ�����ཻ���ص�һ���㣬�����ཻ����null��
 * ������������л���Ҳ�����޻�
 * Ҫ��ʱ�临�Ӷ�O(N+M),NΪ����1�ĳ��ȣ�MΪ����2�ĳ���
 * �ռ临�Ӷ�O(1)
 * ˼·��
 * 1.�ж�ÿ�������Ƿ��л������л����ص�һ���뻷�ڵ�
 * 2.������������ۣ�
 *   A.һ�������л���һ������û�����������ཻ
 *   B.һ�������л�����һ�������л��������ཻҲ���ܲ��ཻ
 *     �ཻ����������һ��������뻷�ڵ�������Ե�����һ��������뻷�ڵ�
 *     �󽻵㣺���������µĲ��ֺ��ԣ��ֱ������������ͷ��㵽����ĳ��ȣ�Ȼ������������(����k��)����������ĵ�һ�������㼴Ϊ����
 *   C.��������û���������ཻҲ���ܲ��ཻ
 *     �ཻ�����������������β�ڵ����
 *     �󽻵㣺�ֱ������������ͷ��㵽ĩβ�ĳ��ȣ�Ȼ������������(����k��)����������ĵ�һ�������㼴Ϊ����
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

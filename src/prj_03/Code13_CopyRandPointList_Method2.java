package prj_03;

import java.util.HashMap;

/**
 * 20190430 AM
 * @author Liu
 *   ���󣺸��ƺ������ָ�������ṹ
 *   ˼· ��
 * 1.��ԭ��������ϲ��뿽���ڵ㣬���м����
 * 2.����������randָ���ָ���ϵ
 * 3.���������ԭ������룬ע�ⲻҪ�ƻ�ԭ����ṹ
 *    ����ռ临�Ӷ�O(1)
 */
public class Code13_CopyRandPointList_Method2 {
	public static class SingleList{
	public int elem;
	public SingleList next;
	public SingleList rand;
	public SingleList(int elem) {
		this.elem = elem;
	}
	public static SingleList copyStruct(SingleList head) {
		SingleList new_head;
		SingleList traverse = head;
		SingleList pre = null;
		SingleList bac = null;
		SingleList back = head.next;
		while(traverse!=null) {
			SingleList tmp = new SingleList(traverse.elem);
			if(traverse.next==null) {
				traverse.next = tmp;
				tmp.next = null;
				traverse = back;
			}
			else {
				traverse.next = tmp;
				tmp.next = back;
				traverse = back;
				back = back.next;
			}
		}
		pre = head;
		traverse = head.next;
		while(traverse!=null) {
			if(traverse.next==null) {
				if(pre.rand==null) {
					traverse.rand = pre.rand;     //ע���ж���pre.randΪnull����ֿ�ָ�����
				}
				else
				{
				    traverse.rand = pre.rand.next;
				}
				traverse = traverse.next;
			}
			else {
				if(pre.rand==null) {
					traverse.rand = pre.rand;
				}
				else
				{
				    traverse.rand = pre.rand.next;
				}
			    traverse = traverse.next.next;
			    pre = pre.next.next;
			}
		}
		pre = head;
		traverse = head.next;
		new_head = head.next;
		bac = head.next.next;
		while(bac!=null) {
			pre.next = bac;
			traverse.next = bac.next;
			bac = bac.next.next;
			pre = pre.next;
			traverse = traverse.next;
		}
		pre.next = null;
		return new_head;
	}
	public static void printSingleList(SingleList head) {
		SingleList tmp = head;
		while(tmp!=null) {
			if(tmp.next==null) {
				System.out.println(tmp.elem);
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
		SingleList s1 = new SingleList(10);
		SingleList s2 = new SingleList(20);
		SingleList s3 = new SingleList(30);
		SingleList s4 = new SingleList(40);
		
		s1.next = s2;
		s2.next = s3;
		s3.next = s4;
		s4.next = null;
		
		s1.rand = s2;
		s2.rand = s3;
		s3.rand = s1;
		s4.rand = null;
		
		SingleList s11 = SingleList.copyStruct(s1);
		SingleList.printSingleList(s11);
		SingleList tmp = s11;
		while(tmp!=null) {
			if(tmp.rand==null) {
				System.out.println(tmp.elem+"->"+"null");
			}
			else {
				System.out.println(tmp.elem+"->"+tmp.rand.elem);
			}
			tmp = tmp.next;
		}
	}

}

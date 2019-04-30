package prj_03;

import java.util.HashMap;

/**
 * 20190430 AM
 * @author Liu
 *   需求：复制含有随机指针的链表结构
 *   思路 ：
 * 1.选择HashMap来存储原链表节点和拷贝节点
 * 2.根据原链表的next关系建立拷贝链表的next关系
 * 3.根据原链表的rand关系建立拷贝链表的rand关系
 * 4.额外空间复杂度O(n)
 */
public class Code13_CopyRandPointList_Method1 {
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
		SingleList cur = head;
		SingleList next = head;
		HashMap<SingleList,SingleList> myhash = new HashMap<>();
		while(traverse!=null) {
			SingleList tmp = new SingleList(traverse.elem);
			myhash.put(traverse, tmp);
			traverse = traverse.next;     //traverse要下移，否则死循环
		}
		traverse = head;          //注意第一次遍历完后要重回头结点
		while(traverse.next!=null) {
			myhash.get(traverse).next = myhash.get(traverse.next);
			myhash.get(traverse).rand = myhash.get(traverse.rand);
			traverse = traverse.next;
		}
		return myhash.get(head);
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

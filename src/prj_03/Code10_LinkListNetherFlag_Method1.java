package prj_03;
/**
 * 2019.0428
 * @author Liu
 * 将链表结构装入荷兰国旗数组，利用荷兰国旗来进行相应范围的划分
 * 最后将数组元素重新进行链接
 * 但是荷兰国旗是不稳定的，因此无法保证原始顺序
 * 额外空间复杂度O(N)
 */

public class Code10_LinkListNetherFlag_Method1 {
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
	}
	public static void swap(SingleList[] arr,int index1,int index2) {
		SingleList temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		}
	public static void nFlag(SingleList[] arr,int L,int R,int key) {
		int less = L-1;
		int more = R+1;
		int current = L;
		while(current<more) {
			if(arr[current].elem==key) {
				current++;
			}
			else if(arr[current].elem<key) {
				swap(arr,current,less+1);
				less++;
				current++;
			}
			else {
				swap(arr,current,more-1);
				more--;
			}
		}
	}
	
	public static void main(String[] args) {
		int i;
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
		
		SingleList[] arr = new SingleList[] {s1,s2,s3,s4,s5,s6,s7};

		nFlag(arr,0,6,30);
		System.out.println("\n");
		for(i=0;i<arr.length-1;i++) {
			arr[i].next = arr[i+1];
		}
		arr[i].next = null;
		SingleList.printSingleList(arr[0]);

	}

}

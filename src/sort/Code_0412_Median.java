//此程序为在数据流中求中位数的程序
//数据流用变长随机数组模拟
package sort;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;
import java.util.PriorityQueue;

import sort.Code_0414_Comparator.Student;
public class Code_0412_Median {
	public static int[] test(int length,int max_num) {
		int[] test_arry = new int[length];
		for(int i=0;i<test_arry.length;i++) {
			test_arry[i] = (int)(Math.random() * max_num);
		}
		return test_arry;
	}
	public static void swap(int[] arr,int index1,int index2) {
		int temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	public static class IntAscending implements Comparator<Integer>{
		public int compare(Integer a,Integer b) {
			return a-b;
		}
	}
	public static class IntDscending implements Comparator<Integer>{
		public int compare(Integer a,Integer b) {
			return b-a;
		}
	}
	public static void main(String[] args) {
			int[] arr = test(10,1000);
			System.out.print(Arrays.toString(arr)+"\n");
			PriorityQueue<Integer> maxrootheap = new PriorityQueue<>(new IntDscending());//构建大根堆
			PriorityQueue<Integer> minrootheap = new PriorityQueue<>(new IntAscending());//构建小根堆
			maxrootheap.add(arr[0]);//第一个元素进大根堆
			for(int i=1;i<arr.length;i++) {
				if(arr[i]<maxrootheap.peek()) {  //若比大根堆的堆顶小则进大根堆，否则进小根堆
					maxrootheap.add(arr[i]);
				}
				else {
					minrootheap.add(arr[i]);
				}
				if(Math.abs(minrootheap.size()-maxrootheap.size())>1) {//使得大根堆和小根堆元素个数差值不超过2
					if(minrootheap.size()>maxrootheap.size()) {
						int temp1 = minrootheap.peek();
						minrootheap.poll();
						maxrootheap.add(temp1);
					}
					else {
						int temp2 = maxrootheap.peek();
						maxrootheap.poll();
						minrootheap.add(temp2);
					}
				}
				//中位数是排序后的中间值，若有奇数个数，则为中间，若为偶数个数则为中间两个数的均值
				if(minrootheap.size()==maxrootheap.size()) {
					System.out.print((maxrootheap.peek()+minrootheap.peek())/2+" ");//相等取中间两个
				}
				else if(minrootheap.size()<maxrootheap.size()) {//大根堆多取大根堆堆顶
					System.out.print(maxrootheap.peek()+" ");
				}
				else //小根堆多取小根堆堆顶
				{
					System.out.print(minrootheap.peek()+" ");
				}
			}
	}
}

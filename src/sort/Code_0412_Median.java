//�˳���Ϊ��������������λ���ĳ���
//�������ñ䳤�������ģ��
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
			PriorityQueue<Integer> maxrootheap = new PriorityQueue<>(new IntDscending());//���������
			PriorityQueue<Integer> minrootheap = new PriorityQueue<>(new IntAscending());//����С����
			maxrootheap.add(arr[0]);//��һ��Ԫ�ؽ������
			for(int i=1;i<arr.length;i++) {
				if(arr[i]<maxrootheap.peek()) {  //���ȴ���ѵĶѶ�С�������ѣ������С����
					maxrootheap.add(arr[i]);
				}
				else {
					minrootheap.add(arr[i]);
				}
				if(Math.abs(minrootheap.size()-maxrootheap.size())>1) {//ʹ�ô���Ѻ�С����Ԫ�ظ�����ֵ������2
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
				//��λ�����������м�ֵ������������������Ϊ�м䣬��Ϊż��������Ϊ�м��������ľ�ֵ
				if(minrootheap.size()==maxrootheap.size()) {
					System.out.print((maxrootheap.peek()+minrootheap.peek())/2+" ");//���ȡ�м�����
				}
				else if(minrootheap.size()<maxrootheap.size()) {//����Ѷ�ȡ����ѶѶ�
					System.out.print(maxrootheap.peek()+" ");
				}
				else //С���Ѷ�ȡС���ѶѶ�
				{
					System.out.print(minrootheap.peek()+" ");
				}
			}
	}
}

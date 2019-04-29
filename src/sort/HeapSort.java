package sort;
import java.util.Arrays;
import java.lang.Math;
public class HeapSort {
	public static int[] test(int length,int max_num) {
		int[] test_arry = new int[length];
		for(int i=0;i<test_arry.length;i++) {
			test_arry[i] = (int)(Math.random() * max_num);
		}
		return test_arry;
	}
	public static void arrySort(int[] arr) {
		Arrays.sort(arr);
	}
	public static int[] copyArray(int[] arr) {
		int[] cpyarr = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			cpyarr[i]=arr[i];
		}
		return cpyarr;
	}
	public static void swap(int[] arr,int index1,int index2) {
		int temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	public static void maxRootHeap(int[] arr) {    //建立大根堆 O(N)
		for(int cur = 1;cur<arr.length;cur++) {
			while(arr[cur]>arr[(cur-1)/2]) {
				swap(arr,cur,(cur-1)/2);
				cur = (cur-1)/2;
			}
		}
	}
	public static void heapify(int[] arr,int size) { //由于交换而引来的插入
		int cur = 0;
		if(size==0) return;
		while((2*cur+1)<size) {    //特别注意左孩子没有就停止
			int left = 2*cur+1;
			int right = 2*cur+2;
			int max_child = (arr[right]>arr[left])&&(right<size)?right:left;
			if(arr[max_child]>arr[cur]) {
				swap(arr,cur,max_child);
				cur = max_child;
			}
			else
				break;
		}
	}
	public static void heapSort(int[] arr) {
		maxRootHeap(arr);
		int heapsize = arr.length;
		while(heapsize>=1) {               //堆一定>=1，保证堆里的最后一个数能够输出,空间复杂度O(1)
			swap(arr,0,heapsize-1);
			heapsize--;
			heapify(arr,heapsize);
		}
	}
	public static boolean isEqual(int[] arr1,int[] arr2) {
		if(arr1==null || arr2==null || arr1.length==0 || arr2.length==0) {
			return false;
		}
		if(arr1.length != arr2.length) {
			return false;
		}
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i]) {
				System.out.println(i);
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		for(int i=1;i<1000;i++) {
			int[] arr1 = test(i,1000);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			arrySort(arr2);
			boolean resul = isEqual(arr1,arr2);
			if(!resul) {
				System.out.println("Bad");
				System.out.println(i);
			}
		}

	}

}

package search;
import java.util.Arrays;
import java.lang.Math;
public class BinarySearch {
	public static int binarySearch(int []arr,int L,int R,int key) {
		int mid=0;
		while(L<=R) {
			mid = (L+R)/2;
			if(key==arr[mid]) break;
			else if(key<arr[mid]) R=mid-1;
			else L=mid+1;
		}
		if(L>R) return -1;
		else return mid;
	}
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
	public static void main(String[] args) {
		int flag = 1;
		for(int i=1;i<1000;i++) {
			int[] arry1 = test(i,1000);
			int[] arry2 = copyArray(arry1);
			arrySort(arry1);
			arrySort(arry2);
			int L= 0;
			int R= arry1.length-1;
			int randkey = (int)(Math.random() * 1000);
			int index1 = binarySearch(arry1,L,R,randkey);
			int index2 = Arrays.binarySearch(arry2,randkey);
			if(index1!=index2) {
				flag = 0;
				System.out.println(i);
			}
		}
		if(flag==1) {
			System.out.println("Succeed!");
		}
		else {
			System.out.println("Fuck");
		}
	}
}

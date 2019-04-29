package sort;
import java.util.Arrays;
import java.lang.Math;
public class SelectSort {
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
	public static void selectSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int min = i;
			for(int j=i+1;j<arr.length;j++) {           //×¢Òâ²»ÄÜ³¬·¶Î§
				if(arr[j]<arr[min])
					min = j;
			}
			swap(arr,i,min);
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
			selectSort(arr1);
			arrySort(arr2);
			boolean resul = isEqual(arr1,arr2);
			if(!resul) {
				System.out.println("Bad");
				System.out.println(i);
			}
		}

	}

}

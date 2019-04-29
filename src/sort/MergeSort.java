package sort;
import java.util.Arrays;
import java.lang.Math;
public class MergeSort {
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
	public static void merge(int[] arr,int L,int mid,int R) {
		int p = L;
		int q = mid+1;
		int[] help_Array = new int[R-L+1];  //注意归并的区间范围是R-L+1
		int i = 0;
		while(p<=mid && q<=R) {
			help_Array[i++] = (arr[p]<arr[q])? arr[p++]:arr[q++];
		}
		while(p<=mid) {
			help_Array[i++] = arr[p++];
		}
		while(q<=R) {
			help_Array[i++] = arr[q++];
		}
		for(int j=0;j<help_Array.length;j++) {  //注意是以拷贝数组的长度为原型
			arr[L+j] = help_Array[j];         //注意原数组的左区间
		}
	}
	public static void mergeSort(int[] arr, int L, int R) {
		if(L==R) 
			return ;
		int mid = (L+R)/2;
		mergeSort(arr, L, mid);
		mergeSort(arr,mid+1,R);
		merge(arr,L,mid,R);
		return ;
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
			mergeSort(arr1,0,arr1.length-1);
			arrySort(arr2);
			boolean resul = isEqual(arr1,arr2);
			if(!resul) {
				System.out.println("Bad");
				System.out.println(i);
			}
		}

	}

}

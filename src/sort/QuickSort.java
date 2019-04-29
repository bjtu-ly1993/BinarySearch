package sort;
import java.util.Arrays;
import java.lang.Math;
public class QuickSort {
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
	public static int[] nFlag(int[] arr,int L,int R,int key) {
		int less = L-1;
		int more = R+1;
		int current = L;
		int[] r_arr = new int[2];
		while(current<more) {
			if(arr[current]==key) {
				current++;
			}
			else if(arr[current]<key) {
				swap(arr,current,less+1);
				less++;
				current++;
			}
			else {
				swap(arr,current,more-1);
				more--;
			}
		}
		r_arr[0] = less;
		r_arr[1] = more;
		return r_arr;
	}
	public static void quickSort(int[] arr,int L,int R) {
		if(L>=R) return;       //非常重要
		int rand_index = (int)(L+(int)(R-L+1)*Math.random());//随机快排，若key=arr[R]则为经典快排
		int[] contain = nFlag(arr,L,R,arr[rand_index]);
		int less = contain[0];
		int more = contain[1];
		quickSort(arr,L,less);
		quickSort(arr,more,R);  //注意，一旦出现more>R的情况即L>R要直接返回
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
			quickSort(arr1,0,arr1.length-1);
			arrySort(arr2);
			boolean resul = isEqual(arr1,arr2);
			if(!resul) {
				System.out.println("Bad");
				System.out.println(i);
			}
		}

	}

}

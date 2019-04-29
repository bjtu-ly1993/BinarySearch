package sort;

public class NederlandFlag {
	public static void swap(int[] arr,int index1,int index2) {
		int temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	public static void nFlag(int[] arr,int L,int R,int key) {
		int less = L-1;
		int more = R+1;
		int current = L;
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
	}
	public static void main(String[] args) {
		int[] arry = {2,5,5,7,4,1,9,5,2,6,5};
		nFlag(arry,0,arry.length-1,5);
		for(int i=0;i<arry.length;i++) {
			System.out.print(arry[i]+" ");
		}
	}

}

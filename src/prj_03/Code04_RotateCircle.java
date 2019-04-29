package prj_03;

public class Code04_RotateCircle {
	public static void swap(int[][] arr,int a1,int b1,int a2,int b2) {
		int temp;
		temp = arr[a1][b1];
		arr[a1][b1]=arr[a2][b2];
		arr[a2][b2]=temp;
	}
	public static void outRotate(int[][] arr,int R1,int C1,int R2,int C2) {
		int remain = 0;
		if(R1<R2 && C1<C2 && (R2-R1)==(C2-C1)) {
			for(int i=R1;i<R2;i++) {
				remain = i%(R2-R1);
				swap(arr,R1,C1+remain,R2-remain,C1);
				swap(arr,R2-remain,C1,R2,C2-remain);
				swap(arr,R2,C2-remain,R1+remain,C2);
			}
		}
		else {
			return ;
		}
	}
	public static void printCircle(int[][] arr,int R1,int C1,int R2,int C2) {
		int l1=R1;
		int l2=R2;
		int r1=C1;
		int r2=C2;
		while(l1<=l2 && r1<=r2) {
			outRotate(arr,l1++,r1++,l2--,r2--);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= new int[3][3];
		int k=1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				a[i][j]=k++;
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.print("\n");
		}
		printCircle(a,0,0,2,2);
		System.out.print("\n");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.print("\n");
		}
	}

}

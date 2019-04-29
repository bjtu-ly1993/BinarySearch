package prj_03;

public class Code04_CircleMatrix {
	public static void outCircle(int[][] arr,int L1,int R1,int L2,int R2) {
		int i=R1;
		int j=L1;
		int k1=R1;
		int k2=L1;
		int k3=R2;
		int k4=L2;
		if(L1==L2 && R1==R2) {
			System.out.print(arr[L1][R1]);
		}
		else if(L1==L2 && R1!=R2) {
			while(i<=(R2-R1)) {
				System.out.print(arr[L1][i++]+" ");
			}
		}
		else if(R1==R2 && L1!=L2) {
			while(j<=(L2-L1)) {
				System.out.print(arr[j++][R1]+" ");
			}
		}
		else {
			while(k1<R2) {
				System.out.print(arr[L1][k1++]+" ");
			}
			while(k2<L2) {
				System.out.print(arr[k2++][R2]+" ");
			}
			while(k3>R1) {
				System.out.print(arr[L2][k3--]+" ");
			}
			while(k4>L1) {
				System.out.print(arr[k4--][R1]+" ");
			}
			
		}
		
	}
	public static void printCircle(int[][] arr,int L1,int R1,int L2,int R2) {
		int l1=L1;
		int l2=L2;
		int r1=R1;
		int r2=R2;
		while(l1<=l2 && r1<=r2) {
			outCircle(arr,l1++,r1++,l2--,r2--);
		}
	}
	public static void main(String[] args) {
		int[][] a= new int[2][4];
		int k=1;
		for(int i=0;i<2;i++) {
			for(int j=0;j<4;j++) {
				a[i][j]=k++;
			}
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.print("\n");
		}
		printCircle(a,0,0,1,3);
		// TODO Auto-generated method stub

	}

}

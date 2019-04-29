package prj_03;

public class Code07_MatrixFind {

	public static boolean findElem(int[][] arr,int R1,int R2,int L1,int L2,int key) {
		int p = R1;
		int q = R2;
		boolean find_flag = false;
		while(p<=L1 && q>=L2) {
			if(arr[p][q]==key) {
				find_flag = true;
				break;
			}
			else if(arr[p][q]<key) {
				p++;
			}
			else {
				q--;
			}
		}
		return find_flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[3][3];
		int k=1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				arr[i][j]=k++;
			}
		}
		boolean flag = findElem(arr,0,2,2,0,0);
		System.out.println(flag);
	}

}

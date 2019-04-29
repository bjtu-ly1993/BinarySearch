package prj_03;
//自己没想出来
public class Code06_ZigZagMatrix {
	//打印对角线的函数
	//(R1,C1)左下角，(R2,C2)右上角
	//flag==1 从左下角往右上角打印，行--，列++，行再减也不能小于右下角行标，列再加也不能大于右上角列标
	//flag==-1从右上角往左下角打印，行++，列--，行再加也不能大于左下角行标，列再减也不能小于左下角列标
	public static void obliqueLine(int[][] arr,int R1,int C1,int R2,int C2,int flag) {
		int r = 0;
		int c = 0;
		if(flag==1) {
			r = R1;
			c = C1;
			while(r>=R2 && c<=C2) {
				System.out.println(arr[r--][c++]);
			}
		}
		else {
			r = R2;
			c = C2;
			while(r<=R1 && c>=C1) {
				System.out.println(arr[r++][c--]);
			}
		}
	}
	public static void zigZag(int[][] arr,int R1,int C1,int R2,int C2) {
		//(a1,b1)往右走，走到最右就往下走
		//(a2,b2)往下走，走到最下就往右边走
		int a1 = R1;
		int b1 = C1;
		int a2 = R1;
		int b2 = C1;
		int cnt = 1;
		int flag = 1;
		while(cnt<2) {
			if(b1==C2+1) {   //(a1,b1)走到最右
				a1++;
				b1=b1-1;
			}
			else if(a2==R2+1) {  //(a2,b2)走到最下
				a2=a2-1;
				b2++;
			}
			else if(a1>R2 || b1>C2) { //(a1,b1)走到终点
				cnt++;
			}
			else {
				obliqueLine(arr,a2,b2,a1,b1,flag);
				b1++;      //(a1,b1)往右走一步
				a2++;      //(a2,b2)往下走一步
				flag = -flag; //确定打印方向
			}
		}
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
		zigZag(arr,0,0,2,2);
	}

}

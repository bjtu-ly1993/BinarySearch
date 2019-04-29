package prj_03;
//�Լ�û�����
public class Code06_ZigZagMatrix {
	//��ӡ�Խ��ߵĺ���
	//(R1,C1)���½ǣ�(R2,C2)���Ͻ�
	//flag==1 �����½������ϽǴ�ӡ����--����++�����ټ�Ҳ����С�����½��б꣬���ټ�Ҳ���ܴ������Ͻ��б�
	//flag==-1�����Ͻ������½Ǵ�ӡ����++����--�����ټ�Ҳ���ܴ������½��б꣬���ټ�Ҳ����С�����½��б�
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
		//(a1,b1)�����ߣ��ߵ����Ҿ�������
		//(a2,b2)�����ߣ��ߵ����¾����ұ���
		int a1 = R1;
		int b1 = C1;
		int a2 = R1;
		int b2 = C1;
		int cnt = 1;
		int flag = 1;
		while(cnt<2) {
			if(b1==C2+1) {   //(a1,b1)�ߵ�����
				a1++;
				b1=b1-1;
			}
			else if(a2==R2+1) {  //(a2,b2)�ߵ�����
				a2=a2-1;
				b2++;
			}
			else if(a1>R2 || b1>C2) { //(a1,b1)�ߵ��յ�
				cnt++;
			}
			else {
				obliqueLine(arr,a2,b2,a1,b1,flag);
				b1++;      //(a1,b1)������һ��
				a2++;      //(a2,b2)������һ��
				flag = -flag; //ȷ����ӡ����
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

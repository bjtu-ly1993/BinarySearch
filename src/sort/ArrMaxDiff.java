package sort;
import java.util.Arrays;
public class ArrMaxDiff {
	public static void dataInBucket(int[] arr,int min,int max) {
		int[] buck_min = new int[arr.length+1];   //一个数组存最小数
		int[] buck_max = new int[arr.length+1];   //一个数组最大数
		boolean[] buck = new boolean[arr.length+1]; //一个数组判断是否有数存入
		int max_diff = 0;
		for(int i=0;i<arr.length;i++) {
			int buck_index = (int)(((arr[i]-min)/(float)(max-min+1))*(arr.length+1));
			buck_min[buck_index]=(arr[i]>buck_min[buck_index])&&(buck[buck_index]==true)?buck_min[buck_index]:arr[i];
		    buck_max[buck_index]=(arr[i]<buck_max[buck_index])&&(buck[buck_index]==true)?buck_max[buck_index]:arr[i];
			buck[buck_index]= true; //注意和上面两句话的先后顺序
		}
		int cur = 0;
		int cur_next = 1;
		while(cur<arr.length+1 && cur_next<arr.length+1) {
			if(buck[cur]) {
				if(buck[cur_next]) {
					max_diff = (buck_min[cur_next]-buck_max[cur])>max_diff?buck_min[cur_next]-buck_max[cur]:max_diff;
					cur = cur_next;
					cur_next++;
				}
				else
				{
					cur_next++;
				}
			}
			else {
				cur++;
			}
		}
	  System.out.println(max_diff);
	}
	public static void main(String[] args) {
		int[] arr= {47,88,500,2,12,25};
		int min_arr=arr[0];
		int max_arr=arr[0];
		for(int i=1;i<arr.length;i++) {
			min_arr = arr[i]<min_arr?arr[i]:min_arr;
			max_arr = arr[i]>max_arr?arr[i]:max_arr;
		}
		dataInBucket(arr,min_arr,max_arr);
	}

}

package prj_03;

public class Code00_ArraytoStack {
	public static class ArrayStack{
		private int init_stacksize;
		private int cur_stacksize;
		private int index;
		private int[] arr;
		public ArrayStack(int arr_initsize,int arr_index) {
			this.init_stacksize = arr_initsize;
			this.cur_stacksize = 0;
			this.index = arr_index;
		}
		public boolean isEmpty() {
			if(cur_stacksize==0) {
				return true;
			}
			else
				return false;
		}
		public void initStack() {
			arr=new int[init_stacksize];
		}
		public int top() {
			if(isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("Array is Empty!");
			}
			else
				return arr[index-1];
		}
		public void pop() {
			if(isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("Array is Empty!");
			}
			else {
				index--;
				this.cur_stacksize--;
			}
		}
		public void push(int elem) {
			if(cur_stacksize==init_stacksize) {
				throw new ArrayIndexOutOfBoundsException("Array is Full!");
			}
			else {
				arr[index++]=elem;
				this.cur_stacksize++;
			}
		}
		
	}
	public static class ArrayQueue{
		private int init_queuesize;
		private int cur_queuesize;
		private int front;
		private int end;
		private int[] arr;
		public ArrayQueue() {
			this.cur_queuesize = 0;
			this.front = 0;
			this.end = 0;
		}
		public void initQueue(int arr_initsize) {
			if(arr_initsize<0) {
				throw new IllegalArgumentException("The init size must be greater than 0!");
			}
			else {
				this.init_queuesize = arr_initsize;
				arr=new int[arr_initsize];
			}
		}
		public boolean isEmpty() {
			if(cur_queuesize==0) {
				return true;
			}
			else
				return false;
		}
		public int peek() {
			if(isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("Array is Empty!");
			}
			else
				return arr[front];
		}
		public void poll() {           //这里也可以返回队首元素
			if(isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("Array is Empty!");
			}
			else {
				if(front==init_queuesize)
					front = 0;
				front++;
				this.cur_queuesize--;
			}
		}
		public void push(int elem) {
			if(cur_queuesize==init_queuesize) {
				throw new ArrayIndexOutOfBoundsException("Array is Full!");
			}
			else {
				if(cur_queuesize<init_queuesize && end==init_queuesize)
					end = 0;
				arr[end++]=elem;
				this.cur_queuesize++;
			}
		}
		
	}
	public static void main(String[] args) {
//		ArrayStack mystack = new ArrayStack(3,0);
//		mystack.initStack();
//		int i=10;
//		while(mystack.cur_stacksize<mystack.init_stacksize) {
//			mystack.push(i++);
//		}
//		System.out.println(mystack.cur_stacksize);
//		mystack.pop();
//		System.out.println(mystack.cur_stacksize);
//		while(!mystack.isEmpty()) {
//			int temp = mystack.top();
//			System.out.println(temp);
//			mystack.pop();
//		}
//		System.out.println(mystack.cur_stacksize);
//		mystack.pop(); //抛出异常
//		while(mystack.cur_stacksize<mystack.init_stacksize) {
//			mystack.push(i++);
//		}
//		mystack.push(12); //抛出异常
		
		ArrayQueue myqueue = new ArrayQueue();
		myqueue.initQueue(3);
		int i=10;
		while(myqueue.cur_queuesize<myqueue.init_queuesize) {
			myqueue.push(i++);
		}
		System.out.println(myqueue.cur_queuesize);
		myqueue.poll();
		System.out.println(myqueue.cur_queuesize);
		while(!myqueue.isEmpty()) {
			int temp = myqueue.peek();
			System.out.println(temp);
			myqueue.poll();
		}
		System.out.println(myqueue.cur_queuesize);
		//mystack.pop(); //抛出异常
		while(myqueue.cur_queuesize<myqueue.init_queuesize) {
			myqueue.push(i++);
		}
		//mystack.push(12); //抛出异常
	}
}

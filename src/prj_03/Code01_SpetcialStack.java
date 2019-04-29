package prj_03;
import java.util.Stack;
import java.lang.Exception;
public class Code01_SpetcialStack {
	public static class MyStack{
		public Stack<Integer> datastack;
		public Stack<Integer> minstack;
		public MyStack() {
			this.datastack = new Stack<Integer>();
			this.minstack = new Stack<Integer>();
		}
		public void push(Integer elem) {
			this.datastack.push(elem);
			if(this.minstack.isEmpty()) {
				this.minstack.push(elem);
			}
			else {
				if(elem<this.minstack.peek()) {
					this.minstack.push(elem);
				}
				else {
					this.minstack.push(minstack.peek());
				}
			}
		}
		public Integer pop() {
			if(this.datastack.isEmpty()) {
				throw new RuntimeException("The Stack is Empty");
			}
			Integer temp = this.datastack.peek();
			this.datastack.pop();
			this.minstack.pop();
			return temp;
		}
		public Integer getMin() {
			if(this.datastack.isEmpty()) {
				throw new RuntimeException("The Stack is Empty");
			}
			return this.minstack.peek();
		}
		public void printStack() {
			while(!this.datastack.isEmpty()) {
				System.out.println(datastack.peek());
				this.datastack.pop();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack s = new MyStack();
		s.push(10);
		s.push(5);
		s.push(30);
		s.printStack();
	}

}

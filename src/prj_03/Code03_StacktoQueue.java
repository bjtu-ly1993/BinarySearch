package prj_03;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class Code03_StacktoQueue {
	public static class MyQueue{
		public Stack<Integer> stack1;
		public Stack<Integer> stack2;
		public MyQueue(){
			this.stack1 = new Stack<>();
			this.stack2 = new Stack<>();
		}
		public boolean isEmpty() {
			if(this.stack1.empty() && this.stack2.empty()) {
				return true;
			}
			else {
				return false;
			}
		}
		public void push(int elem) {
			this.stack1.push(elem);
		}
		public int poll() {
			if(!this.stack2.empty()) {
				return this.stack2.pop();
			}
			else {
				while(!this.stack1.empty()) {
					this.stack2.push(this.stack1.peek());
					this.stack1.pop();
				}
				return this.stack2.pop();
			}
		}
		public int peek() {
			if(!this.stack2.empty()) {
				return this.stack2.peek();
			}
			else {
				while(!this.stack1.empty()) {
					this.stack2.push(this.stack1.peek());
					this.stack1.pop();
				}
				return this.stack2.peek();
			}
		}
	}
	public static class MyStack{
		public Queue<Integer> q1;
		public Queue<Integer> q2;
		public MyStack() {
			this.q1 = new LinkedList<>();
			this.q2 = new LinkedList<>();
		}
		public void push(int elem) {
			if(this.q2.isEmpty() && !this.q1.isEmpty()) {
				this.q1.add(elem);
			}
			else if(this.q1.isEmpty() && !this.q2.isEmpty()) {
				this.q2.add(elem);
			}
			else
				this.q1.add(elem);
		}
		public int pop() {
			if(this.q2.isEmpty() && !this.q1.isEmpty()) {
				while(this.q1.size()>1) {
					this.q2.add(this.q1.poll());
				}
				return this.q1.poll();
			}
			else if(this.q1.isEmpty() && !this.q2.isEmpty()) {
				while(this.q2.size()>1) {
					this.q1.add(this.q2.poll());
				}
				return this.q2.poll();
			}
			else
				throw new RuntimeException("Queue is Empty!");		
		}
		public int top() {
			if(this.q2.isEmpty() && !this.q1.isEmpty()) {
				while(this.q1.size()>1) {
					this.q2.add(this.q1.poll());
				}
				return this.q1.peek();
			}
			else if(this.q1.isEmpty() && !this.q2.isEmpty()) {
				while(this.q2.size()>1) {
					this.q1.add(this.q2.poll());
				}
				return this.q2.peek();
			}
			else
				throw new RuntimeException("Queue is Empty!");
		}
		public boolean isEmpty() {
			if(this.q1.isEmpty() && this.q2.isEmpty())
				return true;
			else 
				return false;
		}
	}
	public static void main(String[] args) {
//		MyQueue q = new MyQueue();
//		q.push(10);
//		q.push(20);
//		q.push(30);
//		System.out.println(q.poll());
//		q.push(40);
//		while(!q.isEmpty()) {
//			System.out.println(q.poll());
//		}
		MyStack s = new MyStack();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop());
		s.push(40);
		s.push(50);
		while(!s.isEmpty()) {
		System.out.println(s.pop());
	    }
	}

}

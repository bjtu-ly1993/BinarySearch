package prj_04;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 20190506 PM
 * @author Liu
 * 二叉树先序反序列化
 * 非静态方法split()可以将字符串拆分成字符串数组
 * 静态方法Integer.parseInt()可以将字符串转化为整数
 * 思路：
 * 迭代函数不能处理的部分放在非迭代部分做，例如字符串拆分成字符串数组以及字符串数组入队列
 * 根据队首元素进行判断，若为"#"则弹出，返回。队长减1继续迭代
 * 打印二叉树的代码是左神写的
 * queue.offer比queue.add好
 * 先序反序列化函数：retUrn，preDeserialize
 * 按层反序列化函数：stringToNode，levelDeserialize
 */
public class Code_04_BTreeDeserialize {
	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
		public static Node retUrn(String str) {
			if(str.equals(null)) {
				return null;
			}
			Queue<String> myqueue = new LinkedList<>();
			String[] s = str.split("!");
			for(int i=0;i<s.length;i++) {
				myqueue.add(s[i]);
			}
			Node head = preDeserialize(myqueue);
			return head;
		}
		//先序解序列化
		public static Node preDeserialize(Queue<String> myqueue) {
			if(myqueue.peek().equals("#")) {
				myqueue.poll();
				return null;
			}
			else {
				Node head = new Node(Integer.parseInt(myqueue.poll()));
				head.left = preDeserialize(myqueue);
				head.right = preDeserialize(myqueue);
				return head;
			}
		}
		//按层解序列化:非常之不熟悉！！！
		//字符串映射函数："#"映射为null,其它映射为对应的node类型
		public static Node stringToNode(String str) {
			if(str.equals("#")) 
				return null;
			else
				return new Node(Integer.parseInt(str));
				
		}
		//一定注意要用原始节点保存树头
		public static Node levelDeserialize(String str) {
			if(str.equals(null)) {
				return null;
			}
			Queue<Node> myqueue = new LinkedList<>();
			String[] values = str.split("!");
			int index = 0;
			Node head = stringToNode(values[index++]);
			if(head!=null)
				myqueue.offer(head);
			Node node = null;
			while(!myqueue.isEmpty()) {
				node = myqueue.poll();
				node.left = stringToNode(values[index++]);
				node.right = stringToNode(values[index++]);
				if(node.left!=null)
					myqueue.offer(node.left);
				if(node.right!=null)
					myqueue.offer(node.right);
			}
			return head;
		}
		public static void printTree(Node head) {
			System.out.println("Binary Tree:");
			printInOrder(head, 0, "H", 17);
			System.out.println();
		}
		public static void printInOrder(Node head, int height, String to, int len) {
			if (head == null) {
				return;
			}
			printInOrder(head.right, height + 1, "v", len);
			String val = to + head.val + to;
			int lenM = val.length();
			int lenL = (len - lenM) / 2;
			int lenR = len - lenM - lenL;
			val = getSpace(lenL) + val + getSpace(lenR);
			System.out.println(getSpace(height * len) + val);
			printInOrder(head.left, height + 1, "^", len);
		}
		public static String getSpace(int num) {
			String space = " ";
			StringBuffer buf = new StringBuffer("");
			for (int i = 0; i < num; i++) {
				buf.append(space);
			}
			return buf.toString();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str = new String("1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!");
		String str = new String("1!2!3!4!5!6!7!#!#!#!#!#!#!#!#!");
		Node head = Node.levelDeserialize(str);
		Node.printTree(head);
	}

}

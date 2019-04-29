package sort;
import java.lang.String;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Code_0414_Comparator {
	public static class Student{
		public String name;
		public int age;
		public int id;
		public Student(String s_name,int s_age,int s_id) {
			this.name = s_name;
			this.age = s_age;
			this.id = s_id;
		}
		public static void printStu(Student[] st) {
			for(int i=0;i<st.length;i++) {
				System.out.print(st[i].name+" "+st[i].age+" "+st[i].id+"\n");
			}
		}
	}
	public static class IdAscending implements Comparator<Student>{
		public int compare(Student o1,Student o2) {
			return o1.id-o2.id;
		}
	}
	public static class AgeDscending implements Comparator<Student>{
		public int compare(Student o1,Student o2) {
			return o2.age-o1.age;
		}
	}
	public static void main(String[] args) {
		Student s1 = new Student("A",20,1);
		Student s2 = new Student("B",21,2);
		Student s3 = new Student("C",22,3);
		Student[] stu = new Student[] {s1,s2,s3};
		PriorityQueue<Student> heap = new PriorityQueue<>(new AgeDscending());
		heap.add(s1);
		heap.add(s2);
		heap.add(s3);
		
		while(!heap.isEmpty()) {
			Student s = heap.poll();
			System.out.print(s.name+" "+s.age+" "+s.id+"\n");
		}
//		Student.printStu(stu);
//		Arrays.sort(stu,new IdAscending());
//		Student.printStu(stu);
//		Arrays.sort(stu,new AgeDscending());
//		Student.printStu(stu);
	}

}

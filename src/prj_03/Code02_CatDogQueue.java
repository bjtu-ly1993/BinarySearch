package prj_03;
import java.util.Queue;
import java.util.LinkedList;
public class Code02_CatDogQueue {
	public static class Pet{
		private String type;
		public Pet(String type) {
			this.type = type;
		}
		public String getPetType() {
			return this.type;
		}
	}
	public static class Dog extends Pet{
		public Dog() {
			super("Dog");
		}
	}
	public static class Cat extends Pet{
		public Cat() {
			super("Cat");
		}
	}
	public static class DogPack{
		private Dog dog;
		private int index;
		public DogPack(int index) {
			this.dog = new Dog();
			this.index = index;
		}
	}
	public static class CatPack{
		private Cat cat;
		private int index;
		public CatPack(int index) {
			this.cat = new Cat();
			this.index = index;
		}
	}
	public static class CDQueue{
		public Queue<CatPack> catqueue;
		public Queue<DogPack> dogqueue;
		public CDQueue(){
			catqueue = new LinkedList<>();
			dogqueue = new LinkedList<>();
		}
		public void add(String type,int num) {
			if(type =="Cat") {
				CatPack ctemp = new CatPack(num);
				catqueue.add(ctemp);
			}
			else if(type =="Dog") {
				DogPack ctemp = new DogPack(num);
				dogqueue.add(ctemp);
			}
			else {
				return;
			}
		}
		public boolean isEmpty() {
			if(catqueue.isEmpty() && dogqueue.isEmpty()) {
				return true;
			}
			else
				return false;
		}
		public boolean isDogEmpty() {
			if(dogqueue.isEmpty()) {
				return true;
			}
			else
				return false;
		}
		public boolean isCatEmpty() {
			if(catqueue.isEmpty()) {
				return true;
			}
			else
				return false;
		}
		public void pollDog() {
			if(isDogEmpty()) {
				throw new RuntimeException("No Dog");
			}
			else {
				 while(!dogqueue.isEmpty()) {
					 DogPack d = dogqueue.poll();
					 System.out.println("Dog"+d.index);
				 }
			}
		}
		public void pollCat() {
			if(isCatEmpty()) {
				throw new RuntimeException("No Cat");
			}
			else {
				 while(!catqueue.isEmpty()) {
					 CatPack c = catqueue.poll();
					 System.out.println("Cat"+c.index);
				 }
			}
		}
		public void pollAll() {
			if(catqueue.isEmpty() && dogqueue.isEmpty()) {
				throw new RuntimeException("The Queue is Empty");
			}
			else if(!catqueue.isEmpty() && dogqueue.isEmpty()) {
				 while(!catqueue.isEmpty()) {
					 CatPack c = catqueue.poll();
					 System.out.println("Cat"+c.index);
				 }
			}
			else if(catqueue.isEmpty() && !dogqueue.isEmpty()) {
				 while(!dogqueue.isEmpty()) {
					 DogPack d = dogqueue.poll();
					 System.out.println("Dog"+d.index);
				 }
			}
			else {
				while(!catqueue.isEmpty() && !dogqueue.isEmpty()) {
					if(catqueue.peek().index<dogqueue.peek().index) {
						 CatPack c = catqueue.poll();
						 System.out.println("Cat"+c.index);
					}
					else {
						 DogPack d = dogqueue.poll();
						 System.out.println("Dog"+d.index);
					}
				}
				 while(!catqueue.isEmpty()) {
					 CatPack c = catqueue.poll();
					 System.out.println("Cat"+c.index);
				 }
				 while(!dogqueue.isEmpty()) {
					 DogPack d = dogqueue.poll();
					 System.out.println("Dog"+d.index);
				 }
				 
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DogPack d1 = new DogPack(1);
		CatPack c2 = new CatPack(2);
		DogPack d3 = new DogPack(3);
		CatPack c4 = new CatPack(4);
		CatPack c5 = new CatPack(5);
		CDQueue cd = new CDQueue();
		cd.add(d1.dog.getPetType(), 1);
		cd.add(c2.cat.getPetType(), 2);
		cd.add(d3.dog.getPetType(), 3);
		cd.add(c4.cat.getPetType(), 4);
		cd.add(c5.cat.getPetType(), 5);
		cd.pollCat();
		System.out.println(cd.isCatEmpty());
	}

}

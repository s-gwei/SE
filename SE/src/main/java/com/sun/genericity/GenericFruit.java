package com.sun.genericity;



/*
 * 无论何时，如果你能做到，你就该尽量使用泛型方法。也就是说，如果使用泛型方法将整个类泛型化，
 * 那么就应该使用泛型方法。另外对于一个static的方法而已，无法访问泛型类型的参数。
 * 所以如果static方法要使用泛型能力，就必须使其成为泛型方法。
 */


/* 泛型类中的实参与泛型类中泛型方法的实参是不保持一致的，
 * 在初始化泛型类时，实参是Fruit，泛型类中的非泛型方法必须用Fruit或者它的子类作为实参
 * 而泛型类中的泛型方法可以任意。
 */
public class GenericFruit {

	class Fruit {
		@Override
		public String toString() {
			return "Fruit [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}
	}

	class Apple extends Fruit {

		@Override
		public String toString() {
			return "apple [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ "]";
		}

	}

	class Penson {

		@Override
		public String toString() {
			return "Penson [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}
	}

	class GenericTset<T> {
		public void show1(T t) {
			System.out.println("泛型类中的普通方法");
		}

		public <E> void show2(E e) {
			System.out.println("泛型类中的泛型方法");
		}

		public <T> void show3(T t) {
			System.out.println("泛型类中的泛型方法");
		}
		public <T> void show4(T t){
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericFruit genericFruit = new GenericFruit();
		Fruit fruit = genericFruit.new Fruit();
		Penson people = genericFruit.new Penson();
		Apple apple = genericFruit.new Apple();
		GenericTset<Fruit> test = genericFruit.new GenericTset<Fruit>();
		// apple是Fruit的子类，所以这里可以
		test.show1(apple);
		// 编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
		// generateTest.show_1(person);

		// 使用这两个方法都可以成功
		test.show2(apple);
		test.show2(people);

		// 使用这两个方法也都可以成功
		test.show3(apple);
		test.show3(people);
	}

	// 可变数组
	public <T> void printMsg(T... args) {
		for (T t : args) {
			System.out.println(t);
		}
	}
	   /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
          "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t){

    }
}

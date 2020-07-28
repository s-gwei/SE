package com.sun.genericity;



//通过上面的两个例子可以看出：泛型的上下边界添加，必须与泛型的声明在一起 。
public class GenericLimit {

	class Generic1<T> {
		public Generic1() {
			// TODO Auto-generated constructor stub
		}

	}

	// 定义有上边界的泛型类
	public class Generic2<T extends Number> {
		private T key;

		public Generic2(T key) {
			this.key = key;
		}

		public T getKey() {
			return key;
		}
	}

	// 在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
	// public <T> T showKeyName(Generic<T extends Number>
	// container)，编译器会报错："Unexpected bound"
	// 通过上面的两个例子可以看出：泛型的上下边界添加，必须与泛型的声明在一起 。
	public <T extends Number> T showKeyName(Generic2<T> container)
			throws InstantiationException, IllegalAccessException {
		Class clazz = container.getClass();
		T test = (T) clazz.newInstance();
		return test;
	}

	
	// 类型实参只准传入某种类型的父类或某种类型的子类。
	// 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
		public static void show(Generic1<? extends Number> obj) {

		}
		
		public <T> void show3(T obj){
			
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericLimit genericLimit = new GenericLimit();
		Generic1<Integer> generic1 = genericLimit.new Generic1<Integer>();
		// 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
		Generic1<Object> generic2 = genericLimit.new Generic1<Object>();
		show(generic1);
		// show(generic2);

		Generic2<Integer> generic3 = genericLimit.new Generic2<Integer>(1);
		// 改泛型类上边界是Number,不能声明实参为String
		// Generic2<String> generic4 = genericLimit.new
		// Generic2<String>("11111");
	}

}

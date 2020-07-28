package com.sun.genericity;


public class MethodTest02 {
    //这个类是泛型类
	public class genericity<T>{
		//泛型类中的泛型变量在初始化时会确定类型，
		private T t;
		 //我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
        //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
        //所以在这个方法中才可以继续使用 T 这个泛型。
		public void add (){
			System.out.println("泛型类中的方法,但不是泛型方法");
		}
		public void get(T t){
			System.out.println("泛型测试");
		}
	      /**
         * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
        public E setKey(E key){
             this.key = keu
        }
        */
	}
	   /** 
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个 
     *    如：public <T,K> K showKeyName(Generic<T> container){
     *        ...
     *        }
     */
	public <T> void show(genericity<T> t) {
		    t.add();
	}
	public void show2(genericity<?> t){
		
	}
	//这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue1(){
    	genericity<Number> genericity1 = new genericity();
    	genericity<Integer> genericity2 = new genericity();
//    	genericity2.get(genericity2);
    }
    //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue2(genericity<?> obj){
    	System.out.println("泛型测试");
    }
    /**
     * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
     * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
     * 因为这不是一个泛型类，也不是一个泛型方法
     * 所以这也不是一个正确的泛型方法声明。
     */
//    public void showKeyValue3(T t){
//    	
//    }
    public static void main(String[] args) {
		
	}
}

package com.sun.connection;

/*
 * ArrayList详解
 */
public class ArrayList {

	/**
	 * Default initial capacity.默认初始容量
	 */
	private static final int DEFAULT_CAPACITY = 2;

	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
	// ArrayList最重要的两个元素，elementData和size
	transient Object[] elementData;// transient修饰是不被序列化，节省空间，

	private Object[] oldList;
	private int size;// list中元素个数,创建对象初始化默认值是0

	public ArrayList() {
		this.oldList = null;
	}

	/*
	 * ArrayList添加元素分为两步 1,判断是否扩容(最重要) 2,添加新元素
	 */
	//这个新增写的有问题，扩容之后newList引用传递给oldList
	public void add(Object obj) {
		// 判断是否扩容,当list元素个数大于数组长度时,数组扩容到原来的1.5倍,在第一次add时，将数组长度设置为10;
		if (oldList == null) {
			oldList = new Object[DEFAULT_CAPACITY];
		}
		if (size + 1 > oldList.length) {
		// << 和>>是java中的移位运算符，<<是左移位，>>是右移位，因为数据存储是二进制的所以左移1相当于乘以2的1次方，
		// 右移相当于乘以2的-1次方，例如
			int newLength = (oldList.length + oldList.length >> 1);
			Object[] newList = new Object[newLength];
			for (int i = 0; i < oldList.length; i++) {
				newList[i] = oldList[i];
			}
			newList[size++] = obj;// size++之后size已经+1,
		} else {
			oldList[size++] = obj;
		}

	}

	public boolean addOne(Object obj){
		if(oldList == null){
			oldList = new Object[DEFAULT_CAPACITY];
		}
		if(size +1 > oldList.length){
			//位移运算符优先级较低，如果8+8>>1会先执行加法，
			int newlength = size + (size>>1);
			Object[] newList = new Object[newlength];
			for(int i=0;i<oldList.length;i++){
				newList[i] = oldList[i];
			}
			oldList = newList;//扩容之后newList引用传递给oldList
		}
		oldList[size] = obj;
		size ++;
		return true;
	}
	// 获取list元素个数
	public int size() {
		return size;// size是此时List中元素格式，而不是数组长度;
	}

	// 判断list是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	//删除元素
	public boolean remove(Object obj){
		for(int i=0;i<size-1;i++){
			if(oldList[i].equals(obj)){
				if(i == size-1){
					oldList[i] = null;
				}
				for(int j = i;j<size-1;j++){
					oldList[j] = oldList[j+1];
				}
				oldList[size-1]=null;
				size--;
				return true;
			}
		}
		return false;
		
		
	}
}

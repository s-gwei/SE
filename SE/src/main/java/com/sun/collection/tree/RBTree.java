package com.sun.collection.tree;

public class RBTree <T extends Comparable<T>>{
	
	private RBTNode<T> mRoot;    // 根结点
	
	private static final boolean RED   = false;
	private static final boolean BLACK = true;
	
	   public class RBTNode<T extends Comparable<T>> {
	        boolean color;        // 颜色
	        T key;                // 关键字(键值)
	        RBTNode<T> left;    // 左孩子
	        RBTNode<T> right;    // 右孩子
	        RBTNode<T> parent;    // 父结点

	        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
	            this.key = key;
	            this.color = color;
	            this.parent = parent;
	            this.left = left;
	            this.right = right;
	        }

	    }
	   
	   //左旋
	   public void leftHead(RBTNode<T> p){
		   //p为左旋的节点
		   if(p == null ){
			   return ;
		   }
		   RBTNode<T> r = p.right;//r是与p进行左旋的节点；
		   //左旋分三步,第一步将r的左节点挂到p的右节点上
		   p.right = r.left;
		   if(r.left != null){
			   r.left.parent = p;
		   }
		   //第二步，将p的父节点变为r，r的left节点变为p
		   p.parent = r;
		   r.left = p;
		   //第三步，将p的父节点的子节点变为r,将r变成p的父节点的子节点
		   if(p.parent == null){//如果p的父节点为null，那p就是根节点，所以r就变成根节点
			   mRoot = r;
		   }if(p.parent.left == p){
			   p.parent.left = r;
		   }if(p.parent.right == p){
			   p.parent.right = r;
		   }
		   //此时节点的左旋就完成了
	   }
	   //右旋
	   public void rightHead(RBTNode<T> p){
		   //与左旋相同，右旋也是三步
		   if(p == null){
			   return;
		   }
		   RBTNode<T> r = p.left;
		   //第一步，将r的right节点替换p的左节点
		   p.right = r.right;
		   if(r.right != null){
			   r.right.parent = p;
		   }
		   //第二步,将p的parent节点替换成r的右节点
		   r.right = p;
		   p.parent = r;
		   //第三步 ，将p的父节点的子节点替换成r;
		   if(p.parent == null){
			   mRoot = r;
		   }if(p.parent.left == p){
			   p.parent.left =r;
		   }if(p.parent.right == p){
			   p.parent.right =r;
		   }
		   //右旋完成
	   }
	   
	   /* 
	    * 将结点插入到红黑树中
	    *
	    * 参数说明：
	    *     node 插入的结点        // 对应《算法导论》中的node
	    */
	   private void insert(RBTNode<T> node) {
	       int cmp;
	       RBTNode<T> y = null;
	       RBTNode<T> x = this.mRoot;

	       // 1. 将红黑树当作一颗二叉查找树，将节点添加到二叉查找树中。
	       while (x != null) {
	           y = x;
	           cmp = node.key.compareTo(x.key);
	           if (cmp < 0)
	               x = x.left;
	           else
	               x = x.right;
	       }

	       node.parent = y;
	       if (y!=null) {
	           cmp = node.key.compareTo(y.key);
	           if (cmp < 0)
	               y.left = node;
	           else
	               y.right = node;
	       } else {
	           this.mRoot = node;
	       }

	       // 2. 设置节点的颜色为红色
	       node.color = RED;

	       // 3. 将它重新修正为一颗二叉查找树
//	       insertFixUp(node);
	   }

	  /* 1. 如果插入的元素的父节点和叔叔节点都为红色。
	   处理方法：直接把叔叔节点和父节点染为黑色，爷爷节点要不是根节点的话染为红色即可
	   2. 如果父节点为红色，叔叔节点为空或者为黑色，并且父节点是爷爷节点是又子树，并且当前节点是父亲节点的左子树。 
	   处理方法：先把父节点右旋转一下， 然后把父节点染为黑色，爷爷节点染为红色，然后左旋转一下.
	   3. 如果父节点为红色， 叔叔节点为空或者黑色，并且父节点是爷爷节点的右子树，并且当前节点是父节点的右子树 
	   处理方法：把父节点染为黑色，爷爷节点染为红色，然后左旋转一下.
	   ４.　如果父节点为红色，叔叔节点为空或者黑色，并且父节点是爷爷节点的左子树，并且当前节点是父节点的右子树
	   处理方法： 先把父节点左旋转一下， 然后把父节点染为黑色，爷爷节点染为红色，然后右旋转一下.
	   5. 如果父节点为红色，叔叔记得为空或者黑色，并且父节点是爷爷节点的左子树，并且当前节点是父节点的左子树
	   处理方法：把父节点染为黑色，爷爷节点染为红色，然后右旋转一下.
	   */
	   public void insert(T key) {
	       RBTNode<T> node=new RBTNode<T>(key,BLACK,null,null,null);

	       // 如果新建结点失败，则返回。
	       if (node != null)
	           insert(node);
	   }


}

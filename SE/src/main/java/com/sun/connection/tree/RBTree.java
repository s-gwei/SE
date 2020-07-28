package com.sun.connection.tree;

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

	   /* 
	    * 新建结点(key)，并将其插入到红黑树中
	    *
	    * 参数说明：
	    *     key 插入结点的键值
	    */
	   public void insert(T key) {
	       RBTNode<T> node=new RBTNode<T>(key,BLACK,null,null,null);

	       // 如果新建结点失败，则返回。
	       if (node != null)
	           insert(node);
	   }

//	   
//	   /*
//	    * 红黑树插入修正函数
//	    *
//	    * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
//	    * 目的是将它重新塑造成一颗红黑树。
//	    *
//	    * 参数说明：
//	    *     node 插入的结点        // 对应《算法导论》中的z
//	    */
//	   private void insertFixUp(RBTNode<T> node) {
//	       RBTNode<T> parent, gparent;
//
//	       // 若“父节点存在，并且父节点的颜色是红色”
//	       while (((parent = parentOf(node))!=null) && isRed(parent)) {
//	           gparent = parentOf(parent);
//
//	           //若“父节点”是“祖父节点的左孩子”
//	           if (parent == gparent.left) {
//	               // Case 1条件：叔叔节点是红色
//	               RBTNode<T> uncle = gparent.right;
//	               if ((uncle!=null) && isRed(uncle)) {
//	                   setBlack(uncle);
//	                   setBlack(parent);
//	                   setRed(gparent);
//	                   node = gparent;
//	                   continue;
//	               }
//
//	               // Case 2条件：叔叔是黑色，且当前节点是右孩子
//	               if (parent.right == node) {
//	                   RBTNode<T> tmp;
//	                   leftRotate(parent);
//	                   tmp = parent;
//	                   parent = node;
//	                   node = tmp;
//	               }
//
//	               // Case 3条件：叔叔是黑色，且当前节点是左孩子。
//	               setBlack(parent);
//	               setRed(gparent);
//	               rightRotate(gparent);
//	           } else {    //若“z的父节点”是“z的祖父节点的右孩子”
//	               // Case 1条件：叔叔节点是红色
//	               RBTNode<T> uncle = gparent.left;
//	               if ((uncle!=null) && isRed(uncle)) {
//	                   setBlack(uncle);
//	                   setBlack(parent);
//	                   setRed(gparent);
//	                   node = gparent;
//	                   continue;
//	               }
//
//	               // Case 2条件：叔叔是黑色，且当前节点是左孩子
//	               if (parent.left == node) {
//	                   RBTNode<T> tmp;
//	                   rightRotate(parent);
//	                   tmp = parent;
//	                   parent = node;
//	                   node = tmp;
//	               }
//
//	               // Case 3条件：叔叔是黑色，且当前节点是右孩子。
//	               setBlack(parent);
//	               setRed(gparent);
//	               leftRotate(gparent);
//	           }
//	       }
//
//	       // 将根节点设为黑色
//	       setBlack(this.mRoot);
//	   }
//	   /* 
//	    * 删除结点(node)，并返回被删除的结点
//	    *
//	    * 参数说明：
//	    *     node 删除的结点
//	    */
//	   private void remove(RBTNode<T> node) {
//	       RBTNode<T> child, parent;
//	       boolean color;
//
//	       // 被删除节点的"左右孩子都不为空"的情况。
//	       if ( (node.left!=null) && (node.right!=null) ) {
//	           // 被删节点的后继节点。(称为"取代节点")
//	           // 用它来取代"被删节点"的位置，然后再将"被删节点"去掉。
//	           RBTNode<T> replace = node;
//
//	           // 获取后继节点
//	           replace = replace.right;
//	           while (replace.left != null)
//	               replace = replace.left;
//
//	           // "node节点"不是根节点(只有根节点不存在父节点)
//	           if (parentOf(node)!=null) {
//	               if (parentOf(node).left == node)
//	                   parentOf(node).left = replace;
//	               else
//	                   parentOf(node).right = replace;
//	           } else {
//	               // "node节点"是根节点，更新根节点。
//	               this.mRoot = replace;
//	           }
//
//	           // child是"取代节点"的右孩子，也是需要"调整的节点"。
//	           // "取代节点"肯定不存在左孩子！因为它是一个后继节点。
//	           child = replace.right;
//	           parent = parentOf(replace);
//	           // 保存"取代节点"的颜色
//	           color = colorOf(replace);
//
//	           // "被删除节点"是"它的后继节点的父节点"
//	           if (parent == node) {
//	               parent = replace;
//	           } else {
//	               // child不为空
//	               if (child!=null)
//	                   setParent(child, parent);
//	               parent.left = child;
//
//	               replace.right = node.right;
//	               setParent(node.right, replace);
//	           }
//
//	           replace.parent = node.parent;
//	           replace.color = node.color;
//	           replace.left = node.left;
//	           node.left.parent = replace;
//
//	           if (color == BLACK)
//	               removeFixUp(child, parent);
//
//	           node = null;
//	           return ;
//	       }
//
//	       if (node.left !=null) {
//	           child = node.left;
//	       } else {
//	           child = node.right;
//	       }
//
//	       parent = node.parent;
//	       // 保存"取代节点"的颜色
//	       color = node.color;
//
//	       if (child!=null)
//	           child.parent = parent;
//
//	       // "node节点"不是根节点
//	       if (parent!=null) {
//	           if (parent.left == node)
//	               parent.left = child;
//	           else
//	               parent.right = child;
//	       } else {
//	           this.mRoot = child;
//	       }
//
//	       if (color == BLACK)
//	           removeFixUp(child, parent);
//	       node = null;
//	   }
//
//	   /* 
//	    * 删除结点(z)，并返回被删除的结点
//	    *
//	    * 参数说明：
//	    *     tree 红黑树的根结点
//	    *     z 删除的结点
//	    */
//	   public void remove(T key) {
//	       RBTNode<T> node; 
//
//	       if ((node = search(mRoot, key)) != null)
//	           remove(node);
//	   }
}

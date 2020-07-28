package com.sun.connection.linked;

import javax.security.auth.callback.LanguageCallback;

class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
 
   public class Solution {
	   public static void main(String[] args) {
		   ListNode l1 = new ListNode(2);
		   l1.next = new ListNode(4);
		   l1.next.next = new ListNode(3);
		   ListNode l2 = new ListNode(5);
		   l2.next = new ListNode(6);
		   l2.next.next = new ListNode(4);
		   addTwoNumbers(l1,l2);
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        int size=0;
        int flag=0;
        while(l1 != null || l2 != null){
           if(l1 !=null && l2 !=null){
               Integer sum = l1.val+l2.val+flag;
               flag = 0;
               String sumStr = Integer.toString(sum);
               if(sumStr.length()>=2){
                   flag = 1;
                   String a = sumStr.substring(1);
                   sum = Integer.parseInt(a);
               }
               ListNode next = new ListNode(sum);
               if(size==0){
                  headNode = next;
                  size++;
                  l1 = l1.next;
                  l2 = l2.next;
                  continue;
               }else{
                   next.next = headNode;
                   headNode = next;
                   size++;
                   l1 = l1.next;
                   l2 = l2.next;
                   continue;
               }
           }else if(l1 !=null && l2 == null){
               ListNode next = new ListNode(l1.val+flag);
               flag=0;
                if(size==0){
                  headNode = next;
                  size++;
                  l1 = l1.next;
                  l2 = l2.next;
                  continue;
               }else{
                   next.next = headNode;
                   headNode = next;
                   size++;
                   l1 = l1.next;
                   l2 = l2.next;
                   continue;
               }
           }else if(l1 == null && l2 !=null){
                ListNode next = new ListNode(l2.val+flag);
                flag=0;
                if(size == 0){
                    headNode = next;
                    size++;
                    l1=l1.next;
                    l2=l2.next;
                    continue;
                }else{
                    next.next = headNode;
                    headNode = next;
                    size++;
                    l1 = l1.next;
                    l2 = l2.next;
                    continue;
                }
           }
        }
     ListNode resultNode = new ListNode(0);
     int count=0;
     ListNode node = headNode;
     while(node!=null){
        count++;
        node = node.next;
         }
         int[] a = new int[count];
         int temp = 0;
          while(headNode!=null){
        a[temp++] = headNode.val;
//        System.out.println(a[temp-1]);
        headNode = headNode.next;
         }
          for(int i=a.length - 1;i>=0;i--){
              if(i == a.length - 1){
                 resultNode.val = a[a.length - 1];
              }else{
                  ListNode c = new ListNode(a[i]);
                 resultNode.next = c;
              }
          }
         return resultNode;
     }
    
}

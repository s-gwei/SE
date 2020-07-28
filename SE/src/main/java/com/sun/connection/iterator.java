package com.sun.connection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String a = "h";
         System.out.println(a.hashCode());
	}
	public void ArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		int a = 1;
		a++;
		System.out.println(a);// a已经+1
		list.add("a");
		list.size();
		list.isEmpty();
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	public void set(){
		Set set = new HashSet();
		set.add("");
	}
	private int hash;
	
    public int hashCode(char[] value) {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }
}

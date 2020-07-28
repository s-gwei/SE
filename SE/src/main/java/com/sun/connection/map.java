package com.sun.connection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.text.html.parser.Entity;

import org.w3c.dom.Node;
public class map {

	public static void main(String[] args) {
		String[] str = {"1","2"};
		
		HashMap map = new HashMap();
		map.put("a", "a");
		map.put("a", "b");
		map.put("str", str);
		keyAndValue(map);
	}

	//循环打印HashMap中的key和value
	public static void keyAndValue(HashMap map){
		for(Object key : map.keySet()){
			System.out.println("key:"+key+","+"value:"+map.get(key).toString());
		}
	}


	//通过Iterator遍历HashMap
	public void show3(HashMap map){
		 Iterator<Object> iterator  = map.entrySet().iterator();
		 while(iterator.hasNext()){
			 Map.Entry<Object, Object> entry = (Entry<Object, Object>)iterator.next();
			 System.out.println("key:"+entry.getKey()+"value:"+entry.getValue());
		 }
	}


}

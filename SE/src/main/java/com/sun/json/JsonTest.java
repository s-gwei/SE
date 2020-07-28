package com.sun.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.pojo.User;

public class JsonTest {

	
//	@Test
	public void jsonOne(){
		//简单序列化
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "sungw");
		map.put("sex", "man");
		map.put("age", 22);
		map.put("major", new String[] { "理发", "挖掘机" });
		
		String json = JSON.toJSONString(map);
		System.out.println(json);
		  
	}
	
//	@Test
	public void jsonTwo(){
		//简单序列化
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "sungw");
		map.put("sex", "man");
		map.put("age", 22);
		map.put("major", new String[] { "理发", "挖掘机" });
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("name", "sungw");
		map1.put("sex", "man");
		map1.put("age", 22);
		map1.put("major", new String[] { "理发", "挖掘机" });
		list.add(map);
		list.add(map1);
		String json = JSON.toJSONString(list);
		System.out.println(json);
		  
	}
//	@Test
	public void jsonThree(){
		//对象序列化
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("sungw");
		User user1 = new User();
		user1.setId(1);
		user1.setName("sungw");
		list.add(user);
		list.add(user1);
		String json = JSON.toJSONString(list);
		System.out.println(json);
		  
	}
	
	@Test
	public void jsonFour(){
		//对象序列化
		User user = new User();
		user.setId(1);
		user.setName("sungw");
		//对象序列化
		String json = JSON.toJSONString(user,SerializerFeature.WriteClassName);
		System.out.println(json);
		//通过parse方法进行反序列化
		User user2 = (User)JSON.parse(json);
		System.out.println(user2.getName());
		  
	}
}

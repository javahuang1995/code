package com.huang.redis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huang.json.test.JsonUtils;
import com.huang.redis.util.JedisClientSingle;
import com.huang.redis.util.MyUser;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class RedisTest {

	private static final String HOST = "192.168.0.104";

	@Autowired
	private JedisClientSingle jedisClientSingle;

	@Test
	public void testClient() {
		// 连接对象可以直接new一个，也可以工厂创建
		Jedis jedis = new Jedis(HOST, 6379); // 新建Jedis对象
		jedis.select(0); // 切换Redis数据库
		
		
//		jedis.set("firstJedis", "hello,Jedis"); // 与Redis命令行操作基本一致
//		// hset实际上定义的一个hashMap,hashMap的名字是a,有2个k-v键值对，用的最多的还是这种。
//		jedis.hset("a", "xxx", "65"); // 同Redis命令行中的hset操作，如名为family的set不存在，则创建set并放入名为lbq的元素，值为65
//		jedis.hset("a", "zjz", "62"); // Redis不支持int类型，如不传String则会报错。
//
//		Map<String, String> testMap = new HashMap<String, String>();
//		testMap.put("num1", "1"); // 此处同上面，不能传非String型
//		testMap.put("num2", "15");
//		testMap.put("num3", "606");
//		testMap.put("num4", "1024");
//		jedis.hmset("testMap1", testMap); // 传入整个map对象入redis
//
//		// 如果是一个对象，可以放进去吗？？
		MyUser u = new MyUser("dd", "ddddf");
//		jedisClientSingle.setObject("uu", u);
//		MyUser getU = (MyUser)jedisClientSingle.getObject("uu");
//		System.out.println(getU.getName());//输出dd
//		
//		//List
//		jedis.lpush("list","dd","ss","lksdjd");//存放String类型的List
//		List<MyUser> myUserList = new ArrayList<MyUser>();//如果是存放对象List呢？ 也作为一个Object扔进去。。
//		myUserList.add(new MyUser("ggg","jpp"));
//		myUserList.add(new MyUser("xx","jpp"));
//		jedisClientSingle.setObject("myUserList", myUserList);
//		List<MyUser> getMyUserList = (List)jedisClientSingle.getObject("myUserList");
//		System.out.println(getMyUserList);
		
		
		//写入json对象
		jedisClientSingle.set("json", JsonUtils.objectToJson(u));


		jedis.close();

	}

	

}

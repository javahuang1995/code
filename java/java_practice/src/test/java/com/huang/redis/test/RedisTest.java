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
		// ���Ӷ������ֱ��newһ����Ҳ���Թ�������
		Jedis jedis = new Jedis(HOST, 6379); // �½�Jedis����
		jedis.select(0); // �л�Redis���ݿ�
		
		
//		jedis.set("firstJedis", "hello,Jedis"); // ��Redis�����в�������һ��
//		// hsetʵ���϶����һ��hashMap,hashMap��������a,��2��k-v��ֵ�ԣ��õ����Ļ������֡�
//		jedis.hset("a", "xxx", "65"); // ͬRedis�������е�hset����������Ϊfamily��set�����ڣ��򴴽�set��������Ϊlbq��Ԫ�أ�ֵΪ65
//		jedis.hset("a", "zjz", "62"); // Redis��֧��int���ͣ��粻��String��ᱨ��
//
//		Map<String, String> testMap = new HashMap<String, String>();
//		testMap.put("num1", "1"); // �˴�ͬ���棬���ܴ���String��
//		testMap.put("num2", "15");
//		testMap.put("num3", "606");
//		testMap.put("num4", "1024");
//		jedis.hmset("testMap1", testMap); // ��������map������redis
//
//		// �����һ�����󣬿��ԷŽ�ȥ�𣿣�
		MyUser u = new MyUser("dd", "ddddf");
//		jedisClientSingle.setObject("uu", u);
//		MyUser getU = (MyUser)jedisClientSingle.getObject("uu");
//		System.out.println(getU.getName());//���dd
//		
//		//List
//		jedis.lpush("list","dd","ss","lksdjd");//���String���͵�List
//		List<MyUser> myUserList = new ArrayList<MyUser>();//����Ǵ�Ŷ���List�أ� Ҳ��Ϊһ��Object�ӽ�ȥ����
//		myUserList.add(new MyUser("ggg","jpp"));
//		myUserList.add(new MyUser("xx","jpp"));
//		jedisClientSingle.setObject("myUserList", myUserList);
//		List<MyUser> getMyUserList = (List)jedisClientSingle.getObject("myUserList");
//		System.out.println(getMyUserList);
		
		
		//д��json����
		jedisClientSingle.set("json", JsonUtils.objectToJson(u));


		jedis.close();

	}

	

}

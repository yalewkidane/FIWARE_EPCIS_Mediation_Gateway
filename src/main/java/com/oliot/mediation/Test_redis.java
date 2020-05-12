//package com.oliot.mediation;
//
//import java.util.Map;
//
//import redis.clients.jedis.Jedis;
//
//public class Test_redis {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		
//		try {
//			Jedis jedi = new Jedis("localhost");
//			System.out.println("Connection Successfull");
//			System.out.println("Surver ping " + jedi.ping());
//			
//			String id_ = "xx1";
//			
//			jedi.lpush("xx1", "1", "2", "3", "4");
//			//jedi.lpush("xx2", "2");
//			//jedi.lpush("xx3", "3");
//			
//			System.out.println(jedi.llen("xx1"));
//			//System.out.println(jedi.llen("xx2"));
//			
//			jedi.hset("user#1", "name", "Peter");
//			jedi.hset("user#1", "job", "politician");
//			jedi.hset("user#1", "name", "Yalew");
//			jedi.hset("user#1", "name", "Yalew");
//			
//			jedi.hset("user#5", "val", "50.5");
//			
//			Double value = Double.parseDouble(jedi.hget("user#5", "val"));
//			System.out.println(value+34.5);       
//			String name = jedi.hget("user#2", "name");
//			         
//			Map<String, String> fields = jedi.hgetAll("user#1");
//			Map<String, String> fields2 = jedi.hgetAll("user#12");
//			System.out.println(fields);
//			if(name==null)
//				System.out.println("Null");
//			else
//				System.out.println(fields2);
//			String job = fields.get("job");
//			System.out.println(job);
//			
//			
//			jedi.close();
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//
//	}
//
//}

package com.xmx.redis.connection;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.redisson.Config;
import org.redisson.Redisson;

public class RedisUtil {
	// redis连接地址（这里是我的自己的电脑）
	private static final String address = "127.0.0.1:6379";
	// redis密码，有就需要，没有就不用（这里我设置了redis的密码）
	private static final String password = "123456";
	
	/**
	 * 1、初始化：获取redis连接
	 * @author xmx
	 * 2017年4月13日上午11:16:54
	 */
	public static Redisson getRedisConnection(){
        Config config = new Config();  
        config.setConnectionPoolSize(10);  
        config.addAddress(address);
        config.setPassword(password);
        Redisson redisson = Redisson.create(config);  
        System.out.println("reids连接成功...");  
        return redisson;
	}
	
	
	/**
	 * 2、测试concurrentMap,put方法的时候就会同步到redis中  
	 * @param redisson
	 * @author xmx
	 * 2017年4月13日上午11:22:16
	 */
	public static void putConcurrentMap(Redisson redisson){
        ConcurrentMap<String, Object> map = redisson.getMap("FirstMap");  
        map.put("wuguowei", "男");  
        map.put("zhangsan", "nan");  
        map.put("lisi", "女");  
  
        ConcurrentMap<String, String> resultMap = redisson.getMap("FirstMap");  
        System.out.println("resultMap==" + resultMap.keySet()); 
	}
	
	
	/**
	 * 3、测试Set集合  
	 * @param redisson
	 * @author xmx
	 * 2017年4月13日上午11:22:32
	 */
	public static void putSet(Redisson redisson){
        Set<String> mySet = redisson.getSet("MySet");  
        mySet.add("wuguowei");  
        mySet.add("lisi");  
  
        Set<String> resultSet = redisson.getSet("MySet");  
        System.out.println("resultSet===" + resultSet.size());  
	}
	
	/**
	 * 4、测试Queue队列  
	 * @param redisson
	 * @author xmx
	 * 2017年4月13日上午11:22:41
	 */
	public static void putQueue(Redisson redisson){
        Queue<String> myQueue = redisson.getQueue("FirstQueue");  
        myQueue.add("wuguowei");  
        myQueue.add("lili");  
        myQueue.add("zhangsan");  
        myQueue.peek();  
        myQueue.poll();  
  
        Queue<String> resultQueue=redisson.getQueue("FirstQueue");  
        System.out.println("resultQueue==="+resultQueue); 
	}
	
	/**
	 * 5、关闭连接  
	 * @param redisson
	 * @author xmx
	 * 2017年4月13日上午11:22:46
	 */
	public static void closeConnection(Redisson redisson){
        redisson.shutdown(); 
	}
	
	// test
	public static void main(String[] args) {
		Redisson redisson = getRedisConnection();
		putConcurrentMap(redisson);
		putSet(redisson);
		putQueue(redisson);
	}

}

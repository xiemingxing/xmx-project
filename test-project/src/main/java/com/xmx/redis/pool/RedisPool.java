package com.xmx.redis.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis连接池
 * @author xmx 
 * 2017年4月13日上午11:38:56
 */
public class RedisPool {
	// Redis服务器IP
	private static String ADDR = "127.0.0.1";

	// Redis的端口号
	private static int PORT = 6379;

	// 访问密码
	private static String AUTH = "123456";

	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_ACTIVE = 1024;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 200;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。
	// 如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 10000;

	private static int TIMEOUT = 10000;

	// 在borrow一个jedis实例时，是否提前进行validate操作；
	// 如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = true;

	private static JedisPool jedisPool = null;

	/**
	 * 静态块，初始化Redis连接池
	 */
	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			/*注意：
            	在高版本的jedis jar包，比如本版本2.9.0，JedisPoolConfig没有setMaxActive和setMaxWait属性了
            	这是因为高版本中官方废弃了此方法，用以下两个属性替换。
            	maxActive  ==>  maxTotal
            	maxWait==>  maxWaitMillis
			 */
			config.setMaxActive(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWait(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取Jedis实例
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 释放jedis资源
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		//方法参数被声明为final，表示它是只读的。
		if (jedis != null) {
			jedisPool.returnResource(jedis);
			//jedis.close()取代jedisPool.returnResource(jedis)方法将3.0版本开始
            //jedis.close();
		}
	}
	
	// test
	public static void main(String[] args) {
		RedisPool.getJedis().set("name", "李达康");
		System.out.println(RedisPool.getJedis().get("name"));
	}

}

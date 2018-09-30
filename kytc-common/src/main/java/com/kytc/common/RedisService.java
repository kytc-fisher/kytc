package com.kytc.common;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 何志同
 * @date 2016年4月5日上午9:39:55
 * @Description redis缓存
 */
@Resource(name="redisService")
public class RedisService {
    //操作redis客户端
    @Autowired
    @Qualifier("connectionFactory")
    private JedisConnectionFactory jedisConnectionFactory;
    @Autowired
    @Qualifier("jedisPool")
    private JedisPool jedisPool;
    /**
     * @author 何志同
     * @description 添加集合元素
     * @date 2017年6月20日下午10:15:55
     * @param key
     * @param members
     * @return Long
     */
    public Long sadd(String key,String...members){
    	Jedis jedis = null;
    	try{
    		jedis = this.getJedis();
        	return jedis.sadd(key, members);
    	}finally{
    		returnResource(jedis);
    	}
    }
    /**
     * @author 何志同
     * @description 判断是否是集合中的元素
     * @date 2017年6月20日下午10:16:08
     * @param key
     * @param member
     * @return Boolean
     */
    public Boolean sismember(String key,String member){
    	Jedis jedis = null;
    	try{
    		jedis = this.getJedis();
        	return jedis.sismember(key, member);
    	}finally{
    		returnResource(jedis);
    	}
    }
    /**
     * @author 何志同
     * @description 删除key
     * @date 2017年6月20日下午10:16:24
     * @param key
     * @return Long
     */
    public Long del(String key){
    	Jedis jedis = null;
    	try{
    		jedis = this.getJedis();
        	return jedis.del(key);
    	}finally{
    		returnResource(jedis);
    	}
    }
    /**
     * 获取jedis 客户端
     * @return
     */
    public Jedis getJedis() { 
        return jedisPool.getResource();
    } 
    public void returnResource(Jedis jedis){
    	if(jedis != null) {
    		jedisPool.returnResource(jedis);
        }
    }
    private RedisService (){
    }
}
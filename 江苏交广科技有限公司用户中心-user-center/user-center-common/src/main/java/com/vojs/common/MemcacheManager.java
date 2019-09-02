package com.vojs.common;

/**
 * Created by chenyunjie on 15/10/8.
 */

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeoutException;

/**
 * memcache管理
 */
@Repository
public class MemcacheManager {
    private Logger logger = LoggerFactory.getLogger(MemcacheManager.class);

    @Autowired
    private MemcachedClient memcachedClient;

    /**
     * memcache取值，默认超时时间500MS
     *
     * @param key
     * @return T
     * @throws
     * @Description:
     * @Title: get
     * @since CodingExample　Ver(编码范例查看) 1.1
     */
    public <T> T get(final String key) {
        try {
            return memcachedClient.get(key);
        } catch (TimeoutException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache get, TimeoutException, param=[key={}]", eArray);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache get, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache get, MemcachedException, param=[key={}]", eArray);
        }
        return null;
    }

    /**
     * memcache取值，会抛出异常
     *
     * @param key
     * @return T
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws net.rubyeye.xmemcached.exception.MemcachedException
     * @Description:
     * @Title: getWithException
     */
    public <T> T getWithException(final String key) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.get(key);
    }

    /**
     * memcache取值,会抛异常
     *
     * @param key     键
     * @param timeout 超时时间
     * @return object
     * @throws TimeoutException
     * @throws InterruptedException
     * @Description:
     */
    public <T> T get(final String key, final long timeout) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.get(key, timeout);
    }

    /**
     * 设置值，默认超时时间500MS
     *
     * @param key   键
     * @param exp   过期时间，单位秒
     * @param value 值
     * @return boolean
     * @Description:
     * @Title: set
     */
    public boolean set(final String key, final int exp, final Object value) {
        try {
            return memcachedClient.set(key, exp, value);
        } catch (TimeoutException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache set, TimeoutException, param=[key={}]", eArray);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache set, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache set, MemcachedException, param=[key={}]", eArray);
        }
        return false;
    }

    /**
     * 设置值，无响应式的，即不关心是否设置成功的情况下使用此方法
     *
     * @param key
     * @param exp   过期时间，单位秒
     * @param value void
     * @throws
     * @Description:
     * @Title: setNoReply
     */
    public void setNoReply(final String key, final int exp, final Object value) {
        try {
            memcachedClient.setWithNoReply(key, exp, value);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache set, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache set, MemcachedException, param=[key={}]", eArray);
        }
    }

    /**
     * 设置值，会抛异常
     *
     * @param key     键
     * @param exp     过期时间，单位秒
     * @param value   值
     * @param timeout 超时时间
     * @return boolean
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws net.rubyeye.xmemcached.exception.MemcachedException boolean
     * @Description:
     * @Title: set
     */
    public boolean set(final String key, final int exp, final Object value, final long timeout) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.set(key, exp, value, timeout);
    }

    /**
     * 根据key删除,默认超时时间
     *
     * @param key 键
     * @return boolean
     * @Description:
     * @Title: delete
     */
    public boolean delete(final String key) {
        try {
            return memcachedClient.delete(key);
        } catch (TimeoutException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache delete, TimeoutException, param=[key={}]", eArray);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache delete, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache delete, MemcachedException, param=[key={}]", eArray);
        }
        return false;
    }

    /**
     * 根据key删除，不返回成功或者失败
     *
     * @param key void
     * @throws
     * @Description:
     * @Title: deleteNoReply
     */
    public void deleteNoReply(final String key) {
        try {
            memcachedClient.deleteWithNoReply(key);
        } catch (InterruptedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache delete, InterruptedException, param=[key={}]", eArray);
        } catch (MemcachedException e) {
            Object[] eArray = new Object[]{key, e};
            logger.error("memcache delete, MemcachedException, param=[key={}]", eArray);
        }
    }

    /**
     * 根据key删除
     *
     * @param key     键
     * @param timeout 超时时间
     * @return boolean
     * @throws TimeoutException
     * @throws InterruptedException
     * @Description:
     * @Title: delete
     */
    public boolean delete(final String key, final long timeout) throws TimeoutException, InterruptedException, MemcachedException {
        return memcachedClient.delete(key, timeout);
    }

    /**
     * 获取memcached实例
     *
     * @return
     */
    public MemcachedClient getMemcachedClient() {
        return this.memcachedClient;
    }
}
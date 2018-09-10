package cn.study.share.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author asus
 * @Title: ShiroSpringCacheManager
 * @ProjectName ssmcrud
 * @Description: 重写shiro的cacheManager,使用redis作为缓存
 * @date 2018/8/29 8:39
 */
public class ShiroSpringCacheManager implements CacheManager, Destroyable {

    private org.springframework.cache.CacheManager cacheManager;

    private RedisTemplate redisTemplate;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        if (s == null) {
            return null;
        }
        // 返回实际的缓存处理器
        return new RedisCache<K, V>(120, redisTemplate);

    }

    @Override
    public void destroy() throws Exception {
        cacheManager = null;
    }

    public org.springframework.cache.CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}

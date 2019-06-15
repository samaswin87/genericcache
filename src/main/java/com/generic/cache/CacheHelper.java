package com.generic.cache;

import java.util.Map;

import com.generic.inter.Query;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheHelper<K, V> implements Query<K, V> {
	
	CacheManager cm;
	Cache cache;
	
	public CacheHelper() {
		cm = CacheManager.newInstance();
		cache = cm.getCache("cache1");
	}
	
	public void shutdown() {
		cm.shutdown();
	}

	@SuppressWarnings("unchecked")
	public Map<K, V> list() {
		return (Map<K, V>) cache.getAll(cache.getKeys());
	}

	public boolean save(K key, V value) {
		if (!cache.isKeyInCache(key)) {
			cache.put(new Element(key, value));
			return true;
		}
		return false;
	}

	public V update(K key, V value) {
		if (cache.isKeyInCache(key)) {
			cache.put(new Element(key, value));
			return findElement(key);
		}
		return null;
	}

	public boolean delete(K key) {
		if (cache.isKeyInCache(key)) {
			return cache.remove(key);
			
		}
		return false;
	}

	public V show(K key) {
		return findElement(key);
	}
	
	@SuppressWarnings("unchecked")
	private V findElement(K key) {
		Element element = cache.get(key);
		return (V) (element == null ? null : element.getObjectValue());
	}
}

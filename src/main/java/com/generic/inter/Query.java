package com.generic.inter;

import java.util.Map;

public interface Query<K, V> {
	
	public boolean save(K key, V value);
	public V update(K key, V value);
	public boolean delete(K key);
	public Map<K, V> list();
	public V show(K key);

}

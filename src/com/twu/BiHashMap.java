package com.twu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BiHashMap<K, V> extends HashMap<K, V> implements BiMap<K, V> {

    private final Map<V, K> invertedMap = new HashMap<>();

    @Override
    public Map<V, K> inverse() {
        return Collections.unmodifiableMap(invertedMap);
    }

    @Override
    public V put(K key, V value) {
        K poppedKey = invertedMap.put(value, key);
        if (poppedKey != null) {
            super.remove(poppedKey);
        }
        V poppedValue = super.put(key, value);
        if (poppedValue != null) {
            invertedMap.remove(poppedValue);
        }
        return poppedValue;
    }

    @Override
    public V remove(Object key) {
        V removedValue = super.remove(key);
        invertedMap.remove(removedValue);
        return removedValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }
}

package com.twu;

import java.util.Map;

public interface BiMap<K, V> extends Map<K, V> {
    Map<V, K> inverse();
}

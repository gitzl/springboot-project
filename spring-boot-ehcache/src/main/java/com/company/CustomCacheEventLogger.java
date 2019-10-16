package com.company;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CustomCacheEventLogger implements CacheEventListener<Object, Object> {

    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {

    }
}

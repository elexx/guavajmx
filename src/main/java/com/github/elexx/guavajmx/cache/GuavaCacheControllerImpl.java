package com.github.elexx.guavajmx.cache;

import com.google.common.cache.Cache;

public class GuavaCacheControllerImpl implements CacheController {

    /** Instance of the managed cache. */
    private final Cache cache;

    public GuavaCacheControllerImpl(Cache cache) {
        this.cache = cache;
    }

    @Override
    public long getRequestCount() {
        return cache.stats().requestCount();
    }

    @Override
    public long getHitCount() {
        return cache.stats().hitCount();
    }

    @Override
    public double getHitRate() {
        return cache.stats().hitRate();
    }

    @Override
    public long getMissCount() {
        return cache.stats().missCount();
    }

    @Override
    public double getMissRate() {
        return cache.stats().missRate();
    }

    @Override
    public long getLoadCount() {
        return cache.stats().loadCount();
    }

    @Override
    public long getLoadSuccessCount() {
        return cache.stats().loadSuccessCount();
    }

    @Override
    public long getLoadExceptionCount() {
        return cache.stats().loadExceptionCount();
    }

    @Override
    public double getLoadExceptionRate() {
        return cache.stats().loadExceptionRate();
    }

    @Override
    public long getTotalLoadTime() {
        return cache.stats().totalLoadTime();
    }

    @Override
    public double getAverageLoadPenalty() {
        return cache.stats().averageLoadPenalty();
    }

    @Override
    public long getEvictionCount() {
        return cache.stats().evictionCount();
    }

    @Override
    public long getSize() {
        return cache.size();
    }

    @Override
    public void cleanUp() {
        cache.cleanUp();
    }

    @Override
    public void invalidateAll() {
        cache.invalidateAll();
    }

}

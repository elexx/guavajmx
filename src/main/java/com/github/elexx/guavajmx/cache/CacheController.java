package com.github.elexx.guavajmx.cache;

/**
 * MBean interface for managing a guava {@link com.google.common.cache.Cache}.
 */
public interface CacheController {

    /** @see com.google.common.cache.CacheStats#requestCount() */
    long getRequestCount();

    /** @see com.google.common.cache.CacheStats#hitCount() */
    long getHitCount();

    /** @see com.google.common.cache.CacheStats#hitRate() */
    double getHitRate();

    /** @see com.google.common.cache.CacheStats#missCount() */
    long getMissCount();

    /** @see com.google.common.cache.CacheStats#missRate() */
    double getMissRate();

    /** @see com.google.common.cache.CacheStats#loadCount() */
    long getLoadCount();

    /** @see com.google.common.cache.CacheStats#loadSuccessCount() */
    long getLoadSuccessCount();

    /** @see com.google.common.cache.CacheStats#loadExceptionCount() */
    long getLoadExceptionCount();

    /** @see com.google.common.cache.CacheStats#loadExceptionRate() */
    double getLoadExceptionRate();

    /** @see com.google.common.cache.CacheStats#totalLoadTime() */
    long getTotalLoadTime();

    /** @see com.google.common.cache.CacheStats#averageLoadPenalty() */
    double getAverageLoadPenalty();

    /** @see com.google.common.cache.CacheStats#evictionCount() */
    long getEvictionCount();

    /** @see com.google.common.cache.Cache#size() */
    long getSize();

    /** @see com.google.common.cache.Cache#cleanUp() */
    void cleanUp();

    /** @see com.google.common.cache.Cache#invalidateAll() */
    void invalidateAll();
}

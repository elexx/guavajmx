/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.elexx.guavajmx.cache;

/**
 * MBean interface for managing a Guava {@link com.google.common.cache.Cache}.
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

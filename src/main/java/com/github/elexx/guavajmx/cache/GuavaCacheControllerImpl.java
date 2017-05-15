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

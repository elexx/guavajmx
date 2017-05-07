package com.github.elexx.guavajmx;

import com.github.elexx.guavajmx.cache.CacheController;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.testng.annotations.Test;

import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class CacheJmxTest {

    private MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

    @Test
    public void testRegisterCache() throws Exception {
        Cache<String, String> testCache = CacheBuilder.newBuilder().build();

        GuavaJmxManagementService.register(testCache, "testCache");

        testCache.put("key1", "value1");
        testCache.put("key2", "value2");

        testCache.getIfPresent("key1"); // HitCount 1
        testCache.getIfPresent("key2"); // HitCount 2
        testCache.getIfPresent("keyDoesNotExist"); // MissCount 1


        CacheController cacheBean = JMX.newMXBeanProxy(mBeanServer, new ObjectName("com.google.common.cache:type=Cache,name=testCache"), CacheController.class);
        assertThat(cacheBean.getHitCount()).isEqualTo(2);
        assertThat(cacheBean.getMissCount()).isEqualTo(1);
        // No need to test all cache statistics. If the registration is done and we find it, we consider the facade working.
    }

}

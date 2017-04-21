package com.github.elexx.guavajmx;

import com.github.elexx.guavajmx.cache.CacheController;
import com.github.elexx.guavajmx.cache.GuavaCacheControllerImpl;
import com.google.common.cache.Cache;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementFactory;

/**
 * Register Guava componentes with JMX.
 */
public class GuavaJmxManagementService {

    /**
     * Registers an Guava {@link Cache} with JMX. See {@link CacheController} for a full list of available methods and attributes.
     *
     * @param cache the cache to register.
     * @param cacheName the name to find the cache in the JMX client.
     */
    public static void register(Cache cache, String cacheName) throws JmxRegistrationException {
        try {
            StandardMBean mBean = new StandardMBean(new GuavaCacheControllerImpl(cache), CacheController.class);
            ManagementFactory.getPlatformMBeanServer().registerMBean(mBean, getJmxBeanName(Cache.class, cacheName));
        } catch (NotCompliantMBeanException | MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException e) {
            throw new JmxRegistrationException("Could not register cache with JMX", e);
        }
    }

    private static ObjectName getJmxBeanName(Class clazz, String name) throws MalformedObjectNameException {
        return new ObjectName(String.format("%s:type=%s,name=%s", clazz.getPackage().getName(), clazz.getSimpleName(), name));
    }
}

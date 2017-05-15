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

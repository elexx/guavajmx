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

import com.github.elexx.guavajmx.eventbus.EventBusController;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.testng.annotations.Test;

import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class EventBusJmxTest {

    private MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

    @Test
    public void testEventBus() throws Exception {
        String eventBusName = "testEventBus";
        EventBus testBus = new EventBus(eventBusName);

        GuavaJmxManagementService.register(testBus, eventBusName);

        Subscriber subscriber = new Subscriber();
        testBus.register(subscriber);

        MyEvent event = new MyEvent();
        event.value = "someTestValue";

        testBus.post(event);

        assertThat(subscriber.value).isEqualTo("someTestValue");

        EventBusController eventBusBean = JMX.newMBeanProxy(mBeanServer, new ObjectName("com.google.common.eventbus:type=EventBus,name=testEventBus"), EventBusController.class);
        assertThat(eventBusBean.getTotalRunningTime()).isGreaterThan(Duration.ZERO);
        assertThat(eventBusBean.getTotalAmountOfEvents()).isEqualTo(1);
        assertThat(eventBusBean.getAverageEventsPerMillisecond()).isGreaterThan(0);
    }

    public static class MyEvent {
        public String value;
    }

    public static class Subscriber {
        public String value;

        @Subscribe
        public void sub(MyEvent event) {
            value = event.value;
        }
    }
}

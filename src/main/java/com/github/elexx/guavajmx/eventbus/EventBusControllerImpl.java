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
package com.github.elexx.guavajmx.eventbus;

import com.google.common.eventbus.Subscribe;

import java.time.Duration;
import java.time.Instant;

public class EventBusControllerImpl implements EventBusController {
    private Instant registerTime = Instant.now();
    private long totalAmountOfEvents = 0;

    @Subscribe
    public void sub(Object o) {
        totalAmountOfEvents++;
    }

    @Override
    public Duration getTotalRunningTime() {
        return Duration.between(registerTime, Instant.now());
    }

    @Override
    public long getTotalAmountOfEvents() {
        return totalAmountOfEvents;
    }

    @Override
    public double getAverageEventsPerMillisecond() {
        return totalAmountOfEvents / (double) getTotalRunningTime().toMillis();
    }
}

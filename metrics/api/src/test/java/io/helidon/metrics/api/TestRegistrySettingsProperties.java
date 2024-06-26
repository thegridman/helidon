/*
 * Copyright (c) 2021 Oracle and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.helidon.metrics.api;

import io.helidon.config.Config;
import io.helidon.config.ConfigSources;

import org.eclipse.microprofile.metrics.MetricRegistry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestRegistrySettingsProperties {

    private static Config metricsConfig;

    @BeforeAll
    static void prep() {
        metricsConfig = Config.create(ConfigSources.classpath("registrySettings.properties")).get("metrics");
    }

    @Test
    void testInclude() {
        MetricsSettings metricsSettings = MetricsSettings.create(metricsConfig);
        assertThat("'pass.me' metric is enabled",
                   metricsSettings.registrySettings(MetricRegistry.Type.VENDOR).isMetricEnabled("pass.me"),
                   is(true));
    }

    @Test
    void testExclude() {
        MetricsSettings metricsSettings = MetricsSettings.create(metricsConfig);
        assertThat("'ignore.me' metric is enabled",
                   metricsSettings.registrySettings(MetricRegistry.Type.VENDOR).isMetricEnabled("ignore.me"),
                   is(false));
    }
}

/*
 * Copyright (c) 2019, 2021 Oracle and/or its affiliates.
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
package io.helidon.microprofile.metrics;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.metrics.annotation.Counted;

/**
 *
 */
@RequestScoped
public class ResourceWithLegallyReusedMetrics {

    @GET
    @Path("method1")
    @Counted(name = "reusedName", absolute = true)
    public String method1() {
        return "Hi from method 1";
    }

    @GET
    @Path("method2")
    @Counted(name = "reusedName", absolute = true)
    public String method2() {
        return "Hi from method 2";
    }
}
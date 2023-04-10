#!/bin/bash -e
#
# Copyright (c) 2023 Oracle and/or its affiliates.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# mvn clean install
clear
echo "RUN 1: (GUICE)"
java -jar guice/target/helidon-examples-pico-logger-guice-4.0.0-SNAPSHOT-jar-with-dependencies.jar "hello guice"
echo "RUN 2: (GUICE)"
java -jar guice/target/helidon-examples-pico-logger-guice-4.0.0-SNAPSHOT-jar-with-dependencies.jar "hello guice"
echo "========================"
echo "RUN 1: (PICO)"
java -jar pico/target/helidon-examples-pico-logger-pico-4.0.0-SNAPSHOT-jar-with-dependencies.jar "hello pico"
echo "RUN 2: (PICO)"
java -jar pico/target/helidon-examples-pico-logger-pico-4.0.0-SNAPSHOT-jar-with-dependencies.jar "hello pico"
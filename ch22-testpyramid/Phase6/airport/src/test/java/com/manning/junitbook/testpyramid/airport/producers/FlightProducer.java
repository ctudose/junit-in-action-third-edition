/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package com.manning.junitbook.testpyramid.airport.producers;

import com.manning.junitbook.testpyramid.airport.FlightBuilderUtil;
import com.manning.junitbook.testpyramid.airport.Flight;
import com.manning.junitbook.testpyramid.airport.annotations.FlightNumber;

import javax.enterprise.inject.Produces;
import java.io.IOException;

public class FlightProducer {

    @Produces
    @FlightNumber(number = "AA1234")
    public Flight createFlight() throws IOException {
        return FlightBuilderUtil.buildFlightFromCsv("AA1234", 50, "src/test/resources/flights_information.csv");
    }

    @Produces
    @FlightNumber(number = "AA1235")
    public Flight createFlight2() throws IOException {
        Flight flight = FlightBuilderUtil.buildFlightFromCsv("AA1235", 36, "src/test/resources/flights_information2.csv");
        return flight;
    }

    @Produces
    @FlightNumber(number = "AA1236")
    public Flight createFlight3() throws IOException {
        Flight flight = FlightBuilderUtil.buildFlightFromCsv("AA1236", 24, "src/test/resources/flights_information3.csv");
        return flight;
    }
}

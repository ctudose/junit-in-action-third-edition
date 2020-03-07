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
package com.manning.junitbook.testpyramid.airport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FlightBuilderUtil {

    public static Flight buildFlightFromCsv(String flightNumber, int seats, String fileName) throws IOException {
        Flight flight = new Flight(flightNumber, seats);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        flight.setDistance(2100);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            do {
                line = reader.readLine();
                if (line != null) {
                    String[] passengerString = line.toString().split(";");
                    Passenger passenger = new Passenger(passengerString[0].trim(), passengerString[1].trim(), passengerString[2].trim());
                    if (passengerString.length == 4) {
                        if ("Y".equals(passengerString[3].trim())) {
                            passenger.setVip(true);
                        }
                    }
                    flight.addPassenger(passenger);
                }
            } while (line != null);

        }

        return flight;
    }
}

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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DistancesManager {
    private static final int DISTANCE_FACTOR = 10;

    private Map<Passenger, Integer> passengersDistancesMap = new HashMap<>();
    private Map<Passenger, Integer> passengersPointsMap = new HashMap<>();

    public Map<Passenger, Integer> getPassengersDistancesMap() {
        return Collections.unmodifiableMap(passengersDistancesMap);
    }

    public Map<Passenger, Integer> getPassengersPointsMap() {
        return Collections.unmodifiableMap(passengersPointsMap);
    }

    public void addDistance(Passenger passenger, int distance) {
        if (passengersDistancesMap.containsKey(passenger)) {
            passengersDistancesMap.put(passenger, passengersDistancesMap.get(passenger) + distance);
        } else {
            passengersDistancesMap.put(passenger, distance);
        }
    }

    public void calculateGivenPoints() {
        for (Passenger passenger : getPassengersDistancesMap().keySet()) {
            passengersPointsMap.put(passenger, getPassengersDistancesMap().get(passenger)/ DISTANCE_FACTOR);
        }
    }

}

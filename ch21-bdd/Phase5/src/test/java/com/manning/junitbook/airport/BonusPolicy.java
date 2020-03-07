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
package com.manning.junitbook.airport;

import com.manning.junitbook.mileage.Mileage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class BonusPolicy {
    private Passenger mike;
    private Passenger john;
    private Mileage mileage;


    @Given("we have a regular passenger with a mileage")
    public void givenWeHaveARegularPassengerWithAMileage() {
        mike = new Passenger("Mike", false);
        mileage = new Mileage();
    }

    @When("the regular passenger travels <mileage1> and <mileage2> and <mileage3>")
    public void whenTheRegularPassengerTravelsMileageAndMileageAndMileage(@Named("mileage1") int mileage1, @Named("mileage2") int mileage2, @Named("mileage3") int mileage3) {
        mileage.addMileage(mike, mileage1);
        mileage.addMileage(mike, mileage2);
        mileage.addMileage(mike, mileage3);
    }

    @Then("the bonus points of the regular passenger should be <points>")
    public void thenTheBonusPointsOfTheRegularPassengerShouldBePoints(@Named("points") int points) {
        mileage.calculateGivenPoints();
        assertEquals(points, mileage.getPassengersPointsMap().get(mike).intValue());
    }

    @Given("we have a VIP passenger with a mileage")
    public void givenWeHaveAVipPassengerWithAMileage() {
        john = new Passenger("John", true);
        mileage = new Mileage();
    }

    @When("the VIP passenger travels <mileage1> and <mileage2> and <mileage3>")
    public void whenTheVipPassengerTravelsMileageAndMileageAndMileage(@Named("mileage1") int mileage1, @Named("mileage2") int mileage2, @Named("mileage3") int mileage3) {
        mileage.addMileage(john, mileage1);
        mileage.addMileage(john, mileage2);
        mileage.addMileage(john, mileage3);
    }

    @Then("the bonus points of the VIP passenger should be <points>")
    public void thenTheBonusPointsOfTheVipPassengerShouldBePoints(@Named("points") int points) {
        mileage.calculateGivenPoints();
        assertEquals(points, mileage.getPassengersPointsMap().get(john).intValue());
    }
}

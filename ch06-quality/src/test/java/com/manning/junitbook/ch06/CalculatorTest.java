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
package com.manning.junitbook.ch06;


import com.manning.junitbook.ch06.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        double sum = calculator.add(10, 50);
        assertEquals(60, sum, 0);
    }

    @Test
    void testSqrt() {
        double sqrt = calculator.sqrt(2);
        assertEquals(1.41421356, sqrt, 0.000001);
    }

    @Test
    void testDivide() {
        double quotient = calculator.divide(1, 3);
        assertEquals(0.33333333, quotient, 0.000001);
    }

    @Test
    void expectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(-1));
    }

    @Test
    void expectArithmeticException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}

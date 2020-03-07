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
package com.manning.junitbook.ch08.configurations;

/**
 * Mock implementation of the configuration interface.
 */
public class MockConfiguration implements Configuration {

    /**
     * Sets the sql query.
     *
     * @param sqlString
     */
    public void setSQL(String sqlString) {
    }

    /**
     * Gets the sql query.
     *
     * @param sqlString
     * @return
     */
    public String getSQL(String sqlString) {
        return null;
    }

}

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
package com.manning.junitbook.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.manning.junitbook.databases.ConnectionManager.closeConnection;
import static com.manning.junitbook.databases.ConnectionManager.openConnection;

public class CountriesLoader {

    private static final String LOAD_COUNTRIES_SQL = "insert into country (name, code_name) values ";

    public static final String[][] COUNTRY_INIT_DATA = { { "Australia", "AU" }, { "Canada", "CA" }, { "France", "FR" },
            { "Germany", "DE" }, { "Italy", "IT" }, { "Japan", "JP" }, { "Romania", "RO" },
            { "Russian Federation", "RU" }, { "Spain", "ES" }, { "Switzerland", "CH" },
            { "United Kingdom", "UK" }, { "United States", "US" } };

    public void loadCountries() {
        for (String[] countryData : COUNTRY_INIT_DATA) {
            String sql = LOAD_COUNTRIES_SQL + "('" + countryData[0] + "', '" + countryData[1] + "');";
            try {
                Connection connection = openConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                closeConnection();
            }
        }
    }
}

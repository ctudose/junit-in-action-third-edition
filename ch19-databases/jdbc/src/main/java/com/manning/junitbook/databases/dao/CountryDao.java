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
package com.manning.junitbook.databases.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manning.junitbook.databases.model.Country;

import static com.manning.junitbook.databases.ConnectionManager.closeConnection;
import static com.manning.junitbook.databases.ConnectionManager.openConnection;

public class CountryDao {
    private static final String GET_ALL_COUNTRIES_SQL = "select * from country";
    private static final String GET_COUNTRIES_BY_NAME_SQL = "select * from country where name like ?";

    public List<Country> getCountryList() {
        List<Country> countryList = new ArrayList<>();

        try {
            Connection connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_COUNTRIES_SQL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                countryList.add(new Country(resultSet.getString(2), resultSet.getString(3)));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }

        return countryList;
    }

    public List<Country> getCountryListStartWith(String name) {
        List<Country> countryList = new ArrayList<>();

        try {
            Connection connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(GET_COUNTRIES_BY_NAME_SQL);
            statement.setString(1, name + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                countryList.add(new Country(resultSet.getString(2), resultSet.getString(3)));
            }

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }

        return countryList;
    }


}

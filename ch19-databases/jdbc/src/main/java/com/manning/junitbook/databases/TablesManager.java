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

public class TablesManager {

    public static void createTable() {
        String sql = "CREATE TABLE COUNTRY( ID IDENTITY, NAME VARCHAR(255), CODE_NAME VARCHAR(255) );";
        executeStatement(sql);
    }

    public static void dropTable() {
        String sql = "DROP TABLE IF EXISTS COUNTRY;";
        executeStatement(sql);
    }

    private static void executeStatement(String sql) {
        PreparedStatement statement;

        try {
            Connection connection = openConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

}

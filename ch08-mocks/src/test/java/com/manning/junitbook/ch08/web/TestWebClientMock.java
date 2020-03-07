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
package com.manning.junitbook.ch08.web;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A test-case to test the WebClient class
 * by means of the custom mock object.
 */
public class TestWebClientMock {
    @Test
    public void testGetContentOk()
            throws Exception {
        MockHttpURLConnection mockConnection = new MockHttpURLConnection();
        mockConnection.setExpectedInputStream(new ByteArrayInputStream("It works".getBytes()));

        TestableWebClient client = new TestableWebClient();
        client.setHttpURLConnection(mockConnection);

        String result = client.getContent(new URL("http://localhost"));

        assertEquals("It works", result);
    }

    /**
     * An inner, private class that extends WebClient and allows us
     * to override the createHttpURLConnection method.
     */
    private class TestableWebClient
            extends WebClient1 {
        /**
         * The connection.
         */
        private HttpURLConnection connection;

        /**
         * Setter method for the HttpURLConnection.
         *
         * @param connection
         */
        public void setHttpURLConnection(HttpURLConnection connection) {
            this.connection = connection;
        }

        /**
         * A method that we overwrite to create the URL connection.
         */
        public HttpURLConnection createHttpURLConnection(URL url)
                throws IOException {
            return this.connection;
        }
    }
}

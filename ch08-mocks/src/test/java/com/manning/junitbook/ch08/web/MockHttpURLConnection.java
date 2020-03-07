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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The mock implementation of the HttpURLConnection.
 */
public class MockHttpURLConnection
        extends HttpURLConnection {
    /**
     * The input stream for the connection.
     */
    private InputStream stream;

    /**
     * Constructor.
     */
    public MockHttpURLConnection() {
        super(null);
    }

    /**
     * Constructor that accepts the URL of the connection as a parameter.
     *
     * @param url
     */
    protected MockHttpURLConnection(URL url) {
        super(url);
    }

    /**
     * Setup the input stream expectation.
     *
     * @param stream
     */
    public void setExpectedInputStream(InputStream stream) {
        this.stream = stream;
    }

    /**
     * Return the input stream
     *
     * @return
     * @throws IOException
     */
    public InputStream getInputStream()
            throws IOException {
        return this.stream;
    }

    /**
     * Disconnect the connection.
     */
    public void disconnect() {
    }

    /**
     * Connect the connection.
     *
     * @throws IOException
     */
    public void connect()
            throws IOException {
    }

    /**
     * Are we using a proxy?
     *
     * @return
     */
    public boolean usingProxy() {
        return false;
    }
}

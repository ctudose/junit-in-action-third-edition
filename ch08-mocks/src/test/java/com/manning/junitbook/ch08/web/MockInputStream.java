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

/**
 * A custom mock input stream to use in our tests.
 */
public class MockInputStream
        extends InputStream {
    /**
     * Buffer to read in.
     */
    private String buffer;

    /**
     * Current position in the stream.
     */
    private int position = 0;

    /**
     * How many times the close method was called.
     */
    private int closeCount = 0;

    /**
     * Sets the buffer.
     *
     * @param buffer
     */
    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    /**
     * Reads from the stream.
     *
     * @return
     */
    public int read()
            throws IOException {
        if (position == this.buffer.length()) {
            return -1;
        }

        return buffer.charAt(this.position++);
    }

    /**
     * Close the stream.
     */
    public void close()
            throws IOException {
        closeCount++;
        super.close();
    }

    /**
     * Verify how many times the close method was called.
     *
     * @throws java.lang.AssertionError
     */
    public void verify()
            throws java.lang.AssertionError {
        if (closeCount != 1) {
            throw new AssertionError("close() should " + "have been called once and once only");
        }
    }
}

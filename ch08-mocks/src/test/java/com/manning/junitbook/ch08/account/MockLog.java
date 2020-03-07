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
package com.manning.junitbook.ch08.account;

import org.apache.commons.logging.Log;

/**
 * Mock implementation of the Log interface.
 */
public class MockLog implements Log {
    public void debug(Object arg0, Throwable arg1) {
    }

    public void debug(Object arg0) {
    }

    public void error(Object arg0, Throwable arg1) {
    }

    public void error(Object arg0) {
    }

    public void fatal(Object arg0, Throwable arg1) {
    }

    public void fatal(Object arg0) {
    }

    public void info(Object arg0, Throwable arg1) {
    }

    public void info(Object arg0) {
    }

    public boolean isDebugEnabled() {
        return false;
    }

    public boolean isErrorEnabled() {
        return false;
    }

    public boolean isFatalEnabled() {
        return false;
    }

    public boolean isInfoEnabled() {
        return false;
    }

    public boolean isTraceEnabled() {
        return false;
    }

    public boolean isWarnEnabled() {
        return false;
    }

    public void trace(Object arg0, Throwable arg1) {
    }

    public void trace(Object arg0) {
    }

    public void warn(Object arg0, Throwable arg1) {
    }

    public void warn(Object arg0) {
    }
}

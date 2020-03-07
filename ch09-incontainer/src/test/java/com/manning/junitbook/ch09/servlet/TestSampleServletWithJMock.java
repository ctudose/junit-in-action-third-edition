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
package com.manning.junitbook.ch09.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jmock.Expectations;
import org.jmock.Mockery;

import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 * A JUnit4 TestCase for the SampleServlet object, using JMock mocking library.
 *
 * @version $Id$
 */

public class TestSampleServletWithJMock {
    @RegisterExtension
    Mockery context = new JUnit5Mockery();

    private HttpServletRequest request;

    private HttpSession session;

    private SampleServlet servlet;

    @BeforeEach
    public void setUp() {
        request = context.mock(HttpServletRequest.class);
        session = context.mock(HttpSession.class);

        servlet = new SampleServlet();
    }

    @Test
    public void testIsAuthenticatedAuthenticated() {
        // expectations
        context.checking(new Expectations() {
            {
                oneOf(request).getSession(false);
                will(returnValue(session));
            }
        });

        context.checking(new Expectations() {
            {
                oneOf(session).getAttribute("authenticated");
                will(returnValue("true"));
            }
        });

        // execute
        assertTrue(servlet.isAuthenticated(request));
    }

    @Test
    public void testIsAuthenticatedNotAuthenticated() {
        // expectations
        context.checking(new Expectations() {
            {
                oneOf(request).getSession(false);
                will(returnValue(session));
            }
        });

        context.checking(new Expectations() {
            {
                oneOf(session).getAttribute("authenticated");
                will(returnValue("false"));
            }
        });

        // execute
        assertFalse(servlet.isAuthenticated(request));
    }

    @Test
    public void testIsAuthenticatedNoSession() {
        // expectations
        context.checking(new Expectations() {
            {
                oneOf(request).getSession(false);
                will(returnValue(null));
            }
        });

        // execute
        assertFalse(servlet.isAuthenticated(request));
    }
}
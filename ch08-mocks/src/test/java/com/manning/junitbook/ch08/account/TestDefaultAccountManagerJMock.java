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

import com.manning.junitbook.ch08.configurations.Configuration;
import org.apache.commons.logging.Log;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

/**
 * This is another test-case for the DefaultAccountManager class. We use here the Jmock library to mock the logger and
 * the configuration.
 */
public class TestDefaultAccountManagerJMock {
    @RegisterExtension
    Mockery context = new JUnit5Mockery();

    private Configuration configuration;
    private Log logger;

    @BeforeEach
    public void setUp() {
        configuration = context.mock(Configuration.class);
        logger = context.mock(Log.class);
    }

    @Test
    public void testFindAccountByUser() {
        context.checking(new Expectations() {
            {
                oneOf(logger).debug("Getting account for user [1234]");

                oneOf(configuration).getSQL("FIND_ACCOUNT_FOR_USER");
                will(returnValue("SELECT ..."));
            }
        });

        DefaultAccountManager2 am = new DefaultAccountManager2(logger, configuration);
        @SuppressWarnings("unused")
        Account account = am.findAccountForUser("1234");

        // Perform asserts here
    }
}

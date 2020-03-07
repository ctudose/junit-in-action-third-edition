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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

/**
 * This is another test-case for the DefaultAccountManager class. We use here the Mockito library to mock the logger and
 * the configuration.
 */
@ExtendWith(MockitoExtension.class)
public class TestDefaultAccountManagerMockito {

    @Mock
    private Configuration configuration;

    @Mock
    private Log logger;


    @Test
    public void testFindAccountByUser() {
        when(configuration.getSQL("FIND_ACCOUNT_FOR_USER")).thenReturn("Getting account for user [1234]");

//        context.checking( new Expectations()
//        {
//            {
//                oneOf (logger).debug("Getting account for user [1234]");
//
//                oneOf (configuration).getSQL( "FIND_ACCOUNT_FOR_USER" );
//                will( returnValue( "SELECT ..." ) );
//            }
//        } );

        DefaultAccountManager2 am = new DefaultAccountManager2(logger, configuration);
        @SuppressWarnings("unused")
        Account account = am.findAccountForUser("1234");

        // Perform asserts here
    }
}

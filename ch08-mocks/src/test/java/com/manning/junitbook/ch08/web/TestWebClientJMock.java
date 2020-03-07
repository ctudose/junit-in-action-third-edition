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

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test the WebClient class using the JMock mocking library.
 */
public class TestWebClientJMock
{
    @RegisterExtension
    Mockery context = new JUnit5Mockery()
    {
        {
            setImposteriser( ClassImposteriser.INSTANCE );
        }
    };

    @Test
    public void testGetContentOk() throws Exception
    {
        ConnectionFactory factory = context.mock( ConnectionFactory.class );
        InputStream mockStream = context.mock( InputStream.class );

        context.checking( new Expectations()
        {
            {
                oneOf( factory ).getData();
                will( returnValue( mockStream ) );

                atLeast(1).of(mockStream).read();
                will( onConsecutiveCalls( returnValue( Integer.valueOf( (byte) 'W' ) ),
                                          returnValue( Integer.valueOf( (byte) 'o' ) ),
                                          returnValue( Integer.valueOf( (byte) 'r' ) ),
                                          returnValue( Integer.valueOf( (byte) 'k' ) ),
                                          returnValue( Integer.valueOf( (byte) 's' ) ),
                                          returnValue( Integer.valueOf( (byte) '!' ) ),
                                          returnValue( -1 ) ) );

                oneOf( mockStream ).close();
            }
        } );

        WebClient2 client = new WebClient2();

        String workingContent = client.getContent( factory );

        assertEquals( "Works!", workingContent );
    }

    @Test
    public void testGetContentCannotCloseInputStream()
        throws Exception
    {

        ConnectionFactory factory = context.mock( ConnectionFactory.class );
        InputStream mockStream = context.mock( InputStream.class );

        context.checking( new Expectations()
        {
            {
                oneOf( factory ).getData();
                will( returnValue( mockStream ) );
                oneOf( mockStream ).read();
                will( returnValue( -1 ) );
                oneOf( mockStream ).close();
                will( throwException( new IOException( "cannot close" ) ) );
            }
        } );

        WebClient2 client = new WebClient2();

        String workingContent = client.getContent( factory );

        assertNull( workingContent );
    }
}

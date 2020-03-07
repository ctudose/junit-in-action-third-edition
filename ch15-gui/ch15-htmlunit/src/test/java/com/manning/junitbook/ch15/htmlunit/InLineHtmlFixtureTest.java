/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.manning.junitbook.ch15.htmlunit;

import java.io.IOException;
import java.net.URL;

import com.gargoylesoftware.htmlunit.MockWebConnection;
import com.gargoylesoftware.htmlunit.WebAssert;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;

/**
 * Demonstrates using in-line HTML fixtures in test methods.
 */
public class InLineHtmlFixtureTest extends ManagedWebClient {

    @Test
    public void testInLineHtmlFixture() throws IOException {
        final String expectedTitle = "Hello 1!";
        String html = "<html><head><title>" + expectedTitle + "</title></head></html>";
        MockWebConnection connection = new MockWebConnection();
        connection.setDefaultResponse(html);
        webClient.setWebConnection(connection);
        HtmlPage page = webClient.getPage("http://page");
        WebAssert.assertTitleEquals(page, expectedTitle);
    }

    @Test
    public void testInLineHtmlFixtures() throws IOException {
        final URL page1Url = new URL("http://Page1/");
        final URL page2Url = new URL("http://Page2/");
        final URL page3Url = new URL("http://Page3/");

        MockWebConnection connection = new MockWebConnection();
        connection.setResponse(page1Url, "<html><head><title>Hello 1!</title></head></html>");
        connection.setResponse(page2Url, "<html><head><title>Hello 2!</title></head></html>");
        connection.setResponse(page3Url, "<html><head><title>Hello 3!</title></head></html>");
        webClient.setWebConnection(connection);

        HtmlPage page1 = webClient.getPage(page1Url);
        WebAssert.assertTitleEquals(page1, "Hello 1!");

        HtmlPage page2 = webClient.getPage(page2Url);
        WebAssert.assertTitleEquals(page2, "Hello 2!");

        HtmlPage page3 = webClient.getPage(page3Url);
        WebAssert.assertTitleEquals(page3, "Hello 3!");
    }

}

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
package com.manning.junitbook.ch15.htmlunit;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.html.HtmlListItem;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Tests navigating the HtmlUnit SourceForge site.
 */
public class HtmlUnitPageTest extends ManagedWebClient {

    @Test
    public void homePage() throws IOException {
        HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());

        String pageAsXml = page.asXml();
        assertTrue(pageAsXml.contains("<div class=\"container-fluid\">"));

        String pageAsText = page.asText();
        assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
    }

    @Test
    public void testClassNav() throws IOException {
        HtmlPage mainPage = webClient.getPage("http://htmlunit.sourceforge.net/apidocs/index.html");
        HtmlPage packagePage = (HtmlPage) mainPage.getFrameByName("packageFrame").getEnclosedPage();
        HtmlListItem htmlListItem = (HtmlListItem) packagePage.getElementsByTagName("li").item(0);
        assertEquals("AboutURLConnection", htmlListItem.getTextContent());
    }
}

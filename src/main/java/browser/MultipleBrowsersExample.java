/*
 * Copyright (c) 2017 seleniumQuery authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package browser;

import io.github.seleniumquery.SeleniumQueryBrowser;

import java.io.File;
import java.io.IOException;

public class MultipleBrowsersExample {

    public static void main(String[] args) {
        String demoPage = "https://cdn.rawgit.com/seleniumQuery/seleniumQuery-showcase/master/Agent.html";

        // using two drivers (chrome and firefox) at the same time
        SeleniumQueryBrowser chrome = new SeleniumQueryBrowser();
        chrome.$.driver().useHtmlUnit().emulatingChrome().autoQuitDriver();
        chrome.$.url(demoPage);

        SeleniumQueryBrowser firefox = new SeleniumQueryBrowser();
        firefox.$.driver().useHtmlUnit().emulatingFirefox().autoQuitDriver();
        firefox.$.url(demoPage);

        chrome.$("#agent").assertThat().text().contains("Chrome");
        firefox.$("#agent").assertThat().text().contains("Firefox");

        System.out.println("All good!");
    }

}

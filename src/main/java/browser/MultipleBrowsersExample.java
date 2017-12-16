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

    private static final File DEMO_PAGE_FILE = new File("src/main/resources/Agent.html");

    public static void main(String[] args) {
        SeleniumQueryBrowser chrome = new SeleniumQueryBrowser();
        chrome.$.driver().useHtmlUnit().emulatingChrome();
        chrome.$.url(DEMO_PAGE_FILE);

        SeleniumQueryBrowser firefox = new SeleniumQueryBrowser();
        firefox.$.driver().useHtmlUnit().emulatingFirefox();
        firefox.$.url(DEMO_PAGE_FILE);

        System.out.println("Chrome's page title: "+chrome.$.driver().get().getTitle());
        System.out.println("Firefox's page title: "+firefox.$.driver().get().getTitle());

        System.out.println("Chrome's agent: "+chrome.$("#agent").text());
        System.out.println("Firefox's agent: "+firefox.$("#agent").text());

        chrome.$.quit();
        firefox.$.quit();
    }

}

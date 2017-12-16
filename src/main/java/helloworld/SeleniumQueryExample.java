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

package helloworld;

import static io.github.seleniumquery.SeleniumQuery.$; // this will allow the short $() syntax

public class SeleniumQueryExample {

    public static void main(String[] args) {
        // The WebDriver will be instantiated only when first used
        $.driver()
            .useChrome() // sets Chrome as the driver (this is optional, if omitted, will default to HtmlUnit)
            .headless() // configures chrome to be headless
            .autoDriverDownload() // automatically downloads and configures chromedriver.exe
            .autoQuitDriver(); // automatically quits the driver when the JVM shuts down

        // or, instead, use any previously existing driver
        // $.driver().use(myExistingInstanceOfWebDriver);

        // starts the driver (if not started already) and opens the URL
        $.url("http://www.google.com/?hl=en");

        // interact with the page
        $(":text[name='q']").val("seleniumQuery"); // the keys are actually typed!

        // Besides the short syntax and the jQuery behavior you already know,
        // other very useful function in seleniumQuery is .waitUntil(),
        // handy for dealing with user-waiting actions (specially in Ajax enabled pages):

        // the command below waits until the button is visible and then performs a real user click (not just the JS event)
        $(":button[value='Google Search']").waitUntil().isVisible().then().click();

        // this waits for the #resultStats to be visible using a selector and, when it is visible, returns its text content
        String resultsText = $("#resultStats").waitUntil().is(":visible").then().text();

        // .assertThat() functions: fluently asserts that the text contains the string "seconds", ignoring case
        $("#resultStats").assertThat().text().containsIgnoreCase("seconds");

        System.out.println(resultsText);
        // should print something like: About 4,100 results (0.42 seconds)

        // $.quit(); // would quit the driver, but it is not needed as .autoQuitDriver() was used
    }

}

package hello;

import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.seleniumquery.SeleniumQuery.$; // this will allow the short $() syntax

public class SeleniumQueryExample {

    public static void main(String[] args) {
        // sets Firefox as the driver (this is optional, if omitted, will default to HtmlUnit)
        $.driver().useFirefox(); // The WebDriver will be instantiated only when first used

        // or use ("decorate") any previously existing driver
        $.driver().use(new FirefoxDriver());

        // starts the driver (if not started already) and opens the URL
        $.url("http://www.google.com/?hl=en");

        // interact with the page
        $(":text[name='q']").val("selenium"); // the keys are actually typed!
        $(":button[name=btnG]").click(); // simulates a real user click (not just the JS event)

        // Besides the short syntax and the jQuery behavior you already know,
        // other very useful function in seleniumQuery is .waitUntil(),
        // handy for dealing with user-waiting actions (specially in Ajax enabled pages):
        String resultsText = $("#resultStats").waitUntil().is(":visible").then().text();

        System.out.println(resultsText);
        // should print something like: About 24,900,000 results (0.37 seconds)

        $.quit(); // quits the currently used driver (firefox)
    }

}

package other;

import static io.github.seleniumquery.SeleniumQuery.$;

public class SeleniumQueryExample {
  public static void main(String[] args) {
    // sets Firefox as the driver (this is optional, if omitted, will default to HtmlUnit)
    $.driver().useFirefox(); // The WebDriver will be instantiated only when first used

    $.url("http://www.google.com/?hl=en");

    $(":text[name='q']").val("selenium"); // the keys are actually typed!
    $(":button[name=btnG]").click(); // simulates a real user click (not just the JS event)

    // Besides the short syntax and the jQuery behavior you already know,
    // other very useful function in seleniumQuery is .waitUntil(),
    // handy for dealing with user-waiting actions (specially in Ajax enabled pages):
    String resultsText = $("#resultStats").waitUntil().is(":visible").then().text();

    System.out.println(resultsText);
    // should print something like: About 24,800,000 results (0.48 seconds)

    $.quit(); // quits the currently used driver (firefox)
  }
}
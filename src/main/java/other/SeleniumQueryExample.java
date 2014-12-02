package other;

import static io.github.seleniumquery.SeleniumQuery.$; // this will allow the short syntax

public class SeleniumQueryExample {
  public static void main(String[] args) {
    // sets Firefox as the driver (this is optional, if omitted, will default to HtmlUnit)
    $.driver().useFirefox().withoutJavaScript(); // JavaScript will be disabled!

    $.url("http://www.google.com/?hl=en");

    $(":text[name='q']").val("selenium"); // the keys are actually typed!
    $(":button:contains('Google Search')").click();
    // Another way: $(":text[name='q']").val("selenium").submit();

    // Besides the short syntax and the jQuery behavior you already know,
    // other very useful function in seleniumQuery is .waitUntil(),
    // handy for dealing with user-waiting actions (specially in Ajax enabled pages):
    String resultsText = $("#resultStats").waitUntil().is(":visible").then().text();
    System.out.println(resultsText);

    $.quit(); // quits the currently used driver (firefox)
  }
}
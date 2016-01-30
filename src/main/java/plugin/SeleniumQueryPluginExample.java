package plugin;

import static io.github.seleniumquery.SeleniumQuery.$;

public class SeleniumQueryPluginExample {

    public static void main(String[] args) {
        $.driver().useFirefox();
        $.url("https://github.com/seleniumQuery/seleniumQuery");

        int theSize = $("div.container").as(SizerPlugin.SIZER).gimmeTheSize();

        System.out.println("The size: "+ theSize);

        $.quit();
    }

}
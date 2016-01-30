package plugin;

import io.github.seleniumquery.SeleniumQueryObject;
import io.github.seleniumquery.functions.as.SeleniumQueryPlugin;

public class SizerPlugin {

    public static final SeleniumQueryPlugin<SizerPlugin> SIZER = new SeleniumQueryPlugin<SizerPlugin>() {
        @Override
        public SizerPlugin as(SeleniumQueryObject seleniumQueryObject) {
            return new SizerPlugin(seleniumQueryObject);
        }
    };

    private SeleniumQueryObject seleniumQueryObject;
    private SizerPlugin(SeleniumQueryObject seleniumQueryObject) {
        this.seleniumQueryObject = seleniumQueryObject;
    }

    public int gimmeTheSize() {
        return this.seleniumQueryObject.get().size();
    }

}
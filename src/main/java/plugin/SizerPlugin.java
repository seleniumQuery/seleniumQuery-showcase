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

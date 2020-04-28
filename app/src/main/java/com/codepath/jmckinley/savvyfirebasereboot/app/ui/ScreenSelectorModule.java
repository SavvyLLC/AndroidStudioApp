package com.codepath.jmckinley.savvyfirebasereboot.app.ui;

import com.codepath.jmckinley.savvyfirebasereboot.app.ApplicationScope;
import com.twilio.video.app.ui.ProductionScreenSelector;
import com.twilio.video.app.ui.ScreenSelector;

import dagger.Module;
import dagger.Provides;

@Module
public class ScreenSelectorModule {

    @Provides
    @ApplicationScope
    ScreenSelector providesScreenSelector() {
        return new ProductionScreenSelector();
    }
}

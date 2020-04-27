package com.codepath.jmckinley.savvyfirebasereboot.app.ui;

import com.twilio.video.app.ApplicationScope;

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

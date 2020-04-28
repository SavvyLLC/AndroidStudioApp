package com.twilio.video.app.ui.room

import android.app.Application
import android.content.SharedPreferences
import com.codepath.jmckinley.savvyfirebasereboot.app.ApplicationModule
import com.codepath.jmckinley.savvyfirebasereboot.app.ApplicationScope
import com.codepath.jmckinley.savvyfirebasereboot.app.data.api.VideoAppServiceModule

import com.twilio.video.app.data.DataModule
import com.twilio.video.app.data.api.TokenService
import dagger.Module
import dagger.Provides


@Module(includes = [
    ApplicationModule::class,
    DataModule::class,
    VideoAppServiceModule::class])
class RoomManagerModule {

    @Provides
    @ApplicationScope
    fun providesRoomManager(
        application: Application,
        sharedPreferences: SharedPreferences,
        tokenService: TokenService
    ): RoomManager {
        return RoomManager(application, sharedPreferences, tokenService)
    }
}
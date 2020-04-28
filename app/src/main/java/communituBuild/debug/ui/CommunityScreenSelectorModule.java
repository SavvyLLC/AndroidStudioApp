package communituBuild.debug.ui;

import com.twilio.video.app.ApplicationScope;
import com.twilio.video.app.ui.CommunityScreenSelector;
import com.twilio.video.app.ui.ScreenSelector;

import dagger.Module;
import dagger.Provides;

@Module
public class CommunityScreenSelectorModule {

    @Provides
    @ApplicationScope
    ScreenSelector providesScreenSelector() {
        return new CommunityScreenSelector();
    }
}

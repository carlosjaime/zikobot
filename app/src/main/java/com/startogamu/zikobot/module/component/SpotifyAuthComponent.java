package com.startogamu.zikobot.module.component;


import com.startogamu.zikobot.module.spotify_api.SpotifyApiBaseComponent;
import com.startogamu.zikobot.module.spotify_api.SpotifyApiModule;
import com.startogamu.zikobot.module.spotify_auth.SpotifyAuthBaseComponent;
import com.startogamu.zikobot.module.spotify_auth.SpotifyAuthModule;
import com.startogamu.zikobot.viewmodel.activity.ActivityAlarmsVM;
import com.startogamu.zikobot.viewmodel.activity.ActivitySettingsVM;
import com.startogamu.zikobot.viewmodel.activity.ActivityWakeUpVM;
import com.startogamu.zikobot.viewmodel.fragment.SpotifyConnectViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * {@link SpotifyAuthComponent} use {@link SpotifyApiBaseComponent} pour l'injecter dans les vues
 * qui utiliseront les méthodes {@link SpotifyApiModule}
 */
@Singleton
@Component(modules = SpotifyAuthModule.class)
public interface SpotifyAuthComponent extends SpotifyAuthBaseComponent {
    void inject(SpotifyConnectViewModel spotifyConnectViewModel);

    void inject(ActivitySettingsVM activitySettingsVM);

    void inject(ActivityAlarmsVM activityAlarmsVM);

    void inject(ActivityWakeUpVM activityWakeUpVM);

    //inject
}
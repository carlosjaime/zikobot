package com.startogamu.zikobot.module.component;

import android.content.Context;

import com.startogamu.zikobot.module.content_resolver.ContentResolverModule;
import com.startogamu.zikobot.module.lyrics.LyricsApiModule;
import com.startogamu.zikobot.module.soundcloud.SoundCloudApiModule;
import com.startogamu.zikobot.module.spotify_api.SpotifyApiModule;
import com.startogamu.zikobot.module.spotify_auth.SpotifyAuthModule;

public enum Injector {

    INSTANCE;
    private SpotifyApiComponent spotifyApiComponent;
    private SpotifyAuthComponent spotifyAuthComponent;
    private ContentResolverComponent contentResolverComponent;
    private SoundCloudApiComponent soundCloudApiComponent;
    private LyricsComponent lyricsComponent;
    public void init(Context context){
        initSpotifyApi(context);
        initSpotifyAuth(context);
        initContentResolver(context);
        initSoundCloudApi(context);
        initLyrics(context);
    }

    private void initLyrics(Context context) {
        lyricsComponent = DaggerLyricsComponent.builder().lyricsApiModule(new LyricsApiModule(context)).build();
    }

    public void initSpotifyApi(Context context) {
        //   spotifyApiComponent = DaggerSpotifyComponent
        spotifyApiComponent = DaggerSpotifyApiComponent.builder().spotifyApiModule(new SpotifyApiModule(context)).build();
    }

    public void initSpotifyAuth(Context context) {
        spotifyAuthComponent = DaggerSpotifyAuthComponent.builder().spotifyAuthModule(new SpotifyAuthModule(context)).build();
    }

    public void initContentResolver(Context context) {
        contentResolverComponent = DaggerContentResolverComponent.builder().contentResolverModule(new ContentResolverModule(context)).build();
    }


    public void initSoundCloudApi(Context context) {
        soundCloudApiComponent = DaggerSoundCloudApiComponent.builder().soundCloudApiModule(new SoundCloudApiModule(context)).build();
    }
    public SpotifyAuthComponent spotifyAuth() {
        return spotifyAuthComponent;
    }

    public ContentResolverComponent contentResolverComponent() {
        return contentResolverComponent;
    }

    public SpotifyApiComponent spotifyApi() {
        return spotifyApiComponent;
    }

    public SoundCloudApiComponent soundCloudApi() {
        return soundCloudApiComponent;
    }

    public LyricsComponent lyricsComponent() {
        return lyricsComponent;
    }
}

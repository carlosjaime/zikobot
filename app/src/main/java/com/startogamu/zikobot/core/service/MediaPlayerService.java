package com.startogamu.zikobot.core.service;

import android.app.IntentService;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import com.orhanobut.logger.Logger;

import lombok.Setter;

/**
 * Created by josh on 10/04/16.
 */
public class MediaPlayerService extends IntentService implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {

    private static final String TAG = MediaPlayerService.class.getSimpleName();
    MediaPlayer mediaPlayer;
    private final IBinder musicBind = new MediaPlayerServiceBinder();
    @Setter
    private OnDisconnectListener onDisconnectListener;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * */
    public MediaPlayerService() {
        super(TAG);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setWakeMode(getApplicationContext(),
                PowerManager.PARTIAL_WAKE_LOCK);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnErrorListener(this);
    }

    public void playUrlSong(String url) {
        //play
        mediaPlayer.reset();
        //set the data source
        try {
            mediaPlayer.setDataSource(url);
        } catch (Exception e) {
            Log.e(MediaPlayerService.class.getSimpleName(), "Error setting data source", e);
        }
        mediaPlayer.prepareAsync();
    }

    //play a song
    public void playSong(Uri uri) {
        //play
        mediaPlayer.reset();
        //set the data source
        try {
            mediaPlayer.setDataSource(getApplicationContext(), uri);
        } catch (Exception e) {
            Log.e(MediaPlayerService.class.getSimpleName(), "Error setting data source", e);
        }
        mediaPlayer.prepareAsync();
    }


    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer = mp;
        mediaPlayer.start();
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        mediaPlayer.setOnCompletionListener(onCompletionListener);
    }


    /***
     *
     */
    public void pause() {
        mediaPlayer.pause();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void resume() {
        mediaPlayer.start();
    }


    public class MediaPlayerServiceBinder extends Binder {
        public MediaPlayerService getService() {
            return MediaPlayerService.this;
        }
    }

    //activity will bind to service
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }


    //release resources when unbind
    @Override
    public boolean onUnbind(Intent intent) {
        mediaPlayer.stop();
        mediaPlayer.release();
        if (onDisconnectListener != null)
            onDisconnectListener.onDisconnect();
        Logger.d("INTEND UNBIND MEDIA PLAYER");
        return false;
    }

    public void seek(int position) {
        mediaPlayer.seekTo(position);
    }

    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    public interface OnDisconnectListener {
        void onDisconnect();
    }
}

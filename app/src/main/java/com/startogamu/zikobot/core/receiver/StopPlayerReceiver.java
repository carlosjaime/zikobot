package com.startogamu.zikobot.core.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.orhanobut.logger.Logger;
import com.startogamu.zikobot.core.event.player.EventStopPlayer;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by josh on 14/06/16.
 */
public class StopPlayerReceiver extends BroadcastReceiver {


    public static final String TAG = StopPlayerReceiver.class.getSimpleName();

    public StopPlayerReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        EventBus.getDefault().post(new EventStopPlayer());
        Logger.d(TAG);
    }

}

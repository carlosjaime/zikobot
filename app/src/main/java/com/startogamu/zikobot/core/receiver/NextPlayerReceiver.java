package com.startogamu.zikobot.core.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.orhanobut.logger.Logger;
import com.startogamu.zikobot.module.component.Injector;


/**
 * Created by josh on 14/06/16.
 */
public class NextPlayerReceiver extends BroadcastReceiver {


    public static final String TAG = NextPlayerReceiver.class.getSimpleName();

    public NextPlayerReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Injector.INSTANCE.playerComponent().manager().next();
        Logger.d(TAG);
    }

}

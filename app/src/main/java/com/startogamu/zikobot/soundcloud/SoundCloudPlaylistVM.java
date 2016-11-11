package com.startogamu.zikobot.soundcloud;

import android.content.Context;
import android.databinding.Bindable;
import android.view.View;

import com.joxad.easydatabinding.base.BaseVM;
import com.startogamu.zikobot.R;
import com.startogamu.zikobot.core.event.soundcloud.SelectSCItemPlaylistEvent;
import com.startogamu.zikobot.core.module.soundcloud.model.SoundCloudPlaylist;

import org.greenrobot.eventbus.EventBus;


/***
 * ViewModel that will represent the playlist of a user on spotify
 */
public class SoundCloudPlaylistVM extends BaseVM<SoundCloudPlaylist> {


    /***
     * @param context
     * @param model
     */
    public SoundCloudPlaylistVM(Context context, SoundCloudPlaylist model) {
        super(context, model);
    }

    @Override
    public void onCreate() {

    }

    /***
     * Click event of an item of alarm
     *
     * @param view
     */
    public void onItemClick(View view) {
        EventBus.getDefault().post(new SelectSCItemPlaylistEvent(model));
    }


    @Bindable
    public String getName() {
        return model.getTitle();
    }


    @Bindable
    public String getImageUrl() {
        if (model.getSoundCloudTracks().isEmpty()) return "";
        return model.getSoundCloudTracks().get(0).getArtworkUrl();
    }

    @Bindable
    public String getNbSongs() {
        return String.format(context.getString(R.string.playlist_total_tracks),
                model.getTrackCount());
    }

}

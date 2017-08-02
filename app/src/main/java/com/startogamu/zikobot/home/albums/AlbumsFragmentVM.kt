package com.startogamu.zikobot.home.albums

import android.os.Bundle
import com.joxad.easydatabinding.fragment.v4.FragmentRecyclerBaseVM
import com.joxad.zikobot.data.db.model.ZikoAlbum
import com.joxad.zikobot.data.module.localmusic.manager.LocalMusicManager
import com.raizlabs.android.dbflow.sql.language.SQLite
import com.startogamu.zikobot.BR
import com.startogamu.zikobot.R
import com.startogamu.zikobot.databinding.AlbumsFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Generated by generator-android-template
 */
class AlbumsFragmentVM(fragment: AlbumsFragment, binding: AlbumsFragmentBinding, savedInstance: Bundle?) :
        FragmentRecyclerBaseVM< AlbumVM, AlbumsFragment, AlbumsFragmentBinding>(fragment, binding, savedInstance) {
    override fun itemLayoutResource(): Int {
        return R.layout.album_item
    }

    override fun itemData(): Int {
        return BR.albumVM
    }

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        LocalMusicManager.INSTANCE.share().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { o ->
                    val list = SQLite.select()
                            .from(ZikoAlbum::class.java)
                            .queryList()
                    items.clear()
                    for (album in list) {
                        items.add(AlbumVM(fragment.context, album))
                    }
                }

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {

        private val TAG = AlbumsFragmentVM::class.java.simpleName
    }
}

package com.startogamu.zikobot.search

import com.joxad.easydatabinding.activity.ActivityBase
import com.startogamu.zikobot.R
import com.startogamu.zikobot.BR
import com.startogamu.zikobot.databinding.SearchActivityBinding

import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Generated by generator-android-template
 */
class SearchActivity : ActivityBase<SearchActivityBinding, SearchActivityVM>() {
    override fun data(): Int {
        return BR.searchActivityVM
    }

    override fun layoutResources(): Int {
        return R.layout.search_activity
    }

    override fun baseActivityVM(binding: SearchActivityBinding, savedInstanceState: Bundle): SearchActivityVM {
        return SearchActivityVM(this, binding, savedInstanceState)
    }

    companion object {

        /***
         * Generate the intent for the activity
         * Use this to start the activity
         */
        fun newInstance(context: Context): Intent {
            return Intent(context, SearchActivity::class.java)
        }
    }
}

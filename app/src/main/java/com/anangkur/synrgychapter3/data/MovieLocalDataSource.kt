package com.anangkur.synrgychapter3.data

import com.anangkur.synrgychapter3.ui.activity.navigationcomponent.fragment.second.data.Movie

interface MovieLocalDataSource {
    fun storeDataToLocalDb(data: Movie)
}
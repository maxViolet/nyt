package com.maxviolet.nytimes.models

import androidx.room.PrimaryKey

data class NytNewsItem(

    @PrimaryKey(autoGenerate = true)
    var id: Long

)
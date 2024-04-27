package com.dicoding.myfavmakanan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    var name: String,
    var description: String,
    var photo: String
) : Parcelable



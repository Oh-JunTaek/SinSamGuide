package com.eunma.sinsamguide.ui.contents

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentsData(
    val imageResId: Int,
    val text: String,
    val detail: String
) : Parcelable
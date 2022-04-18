package com.github.mstavares.cm.aula6

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
class OperationUi(var expression: String, var result: String) : Parcelable {
    var holeThing = "$expression=$result"
}
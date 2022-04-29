package com.github.mstavares.cm.aula6

import java.util.*

data class Operation(val expression:String, val result: Double ) {
    val timestamp : Long = Date().time
}
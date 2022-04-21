package com.hegunhee.wirebarleytest.ui

sealed class Switch {
    object Uninitalized : Switch()
    object Clicked : Switch()
}

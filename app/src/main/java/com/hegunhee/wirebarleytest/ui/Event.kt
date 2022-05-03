package com.hegunhee.wirebarleytest.ui

sealed class Event {
    object Uninitalized : Event()
    object Clicked : Event()
}

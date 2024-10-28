package com.yourpackage

class AppBlocker {
    private val blockedApps = setOf(
        "com.facebook.katana",
        "com.instagram.android",
        "com.twitter.android",
        "com.google.android.youtube"
    )

    fun isAppBlocked(packageName: String): Boolean {
        return blockedApps.contains(packageName)
    }
}

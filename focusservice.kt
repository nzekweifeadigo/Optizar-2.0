package com.yourpackage

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.provider.Settings

class FocusService : Service() {
    private val overlayManager = OverlayManager()
    private val appBlocker = AppBlocker()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "ACTION_START_FOCUS" -> startFocusMode()
            "ACTION_STOP_FOCUS" -> stopFocusMode()
        }
        return START_STICKY
    }

    private fun startFocusMode() {
        if (Settings.canDrawOverlays(this)) {
            overlayManager.showBlueLight(this)
            appBlocker.enableBlocking()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}

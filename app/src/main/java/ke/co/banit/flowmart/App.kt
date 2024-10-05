package ke.co.banit.flowmart

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var application: Application
            private set
    }
}
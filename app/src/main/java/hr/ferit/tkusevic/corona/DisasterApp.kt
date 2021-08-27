package hr.ferit.tkusevic.corona

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class DisasterApp : Application() {

    companion object {
        lateinit var instance: DisasterApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

}
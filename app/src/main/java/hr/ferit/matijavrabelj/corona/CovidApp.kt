package hr.ferit.matijavrabelj.corona

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class CovidApp : Application() {

    companion object {
        lateinit var instance: CovidApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

}
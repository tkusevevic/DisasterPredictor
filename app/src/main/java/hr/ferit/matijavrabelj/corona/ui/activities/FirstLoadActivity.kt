package hr.ferit.matijavrabelj.corona.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FirstLoadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPrefs()
    }

    private fun checkPrefs() = startCorona()

    private fun startCorona() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
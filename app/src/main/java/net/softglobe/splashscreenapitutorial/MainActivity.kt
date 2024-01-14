package net.softglobe.splashscreenapitutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var isLoading = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                setLoadTime()
                isLoading
            }
        }
        setContentView(R.layout.activity_main)
    }

    private fun setLoadTime() {
        lifecycleScope.launch {
            delay(5000)
            isLoading = false
        }
    }
}
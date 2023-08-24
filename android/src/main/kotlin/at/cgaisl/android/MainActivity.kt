package at.cgaisl.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import at.cgaisl.common.KodeeLoginScreen
import at.cgaisl.common.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(typography = typography()) {
                KodeeLoginScreen()
            }
        }
    }
}

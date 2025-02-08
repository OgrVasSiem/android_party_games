package com.ogrvassiem.partygames

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import com.ogrvassiem.partygames.aplication.LocalActivity
import com.ogrvassiem.partygames.ui.ApplicationRootUI
import com.ogrvassiem.partygames.ui.theme.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(Color.TRANSPARENT)
        )

        setContent {
            CompositionLocalProvider(LocalActivity provides this@MainActivity) {
                Theme {
                    ApplicationRootUI(
                    )
                }
            }
        }
    }
}



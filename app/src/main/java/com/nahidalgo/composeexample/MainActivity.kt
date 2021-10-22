package com.nahidalgo.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.nahidalgo.composeexample.ui.component.MessagesScreen
import com.nahidalgo.composeexample.ui.theme.ComposeExampleTheme
import com.nahidalgo.composeexample.ui.viewmodel.MessagesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: MessagesViewModel by viewModel()

        setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MessagesScreen(model)
                }
            }
        }
    }
}
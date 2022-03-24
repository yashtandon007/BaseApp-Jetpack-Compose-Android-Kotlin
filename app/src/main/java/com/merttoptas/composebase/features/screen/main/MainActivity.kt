package com.merttoptas.composebase.features.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.merttoptas.composebase.RickAndMortyApp
import com.merttoptas.composebase.features.navigation.NavGraph
import com.merttoptas.composebase.features.ui.theme.ComposeBaseTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var application: RickAndMortyApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBaseTheme(darkTheme = application.isDark.value) {
                NavGraph()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBaseTheme {
        NavGraph()
    }
}
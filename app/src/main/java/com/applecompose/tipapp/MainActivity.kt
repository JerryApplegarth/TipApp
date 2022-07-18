package com.applecompose.tipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import com.applecompose.tipapp.presentation.screens.HomeScreen
import com.applecompose.tipapp.ui.theme.TipAppTheme

class MainActivity : ComponentActivity() {

	@OptIn(ExperimentalComposeUiApi::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TipAppTheme {
				HomeScreen()
			}
		}
	}
}





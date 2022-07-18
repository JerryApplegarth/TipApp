package com.applecompose.tipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.applecompose.tipapp.presentation.components.TipCalculator
import com.applecompose.tipapp.ui.theme.TipAppTheme
import com.applecompose.tipapp.ui.theme.newBackgroundColor

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TipAppTheme {
				MyApp()
			}
		}
	}
}


@Composable
fun MyApp(){
	TipCalculator()

	TipAppTheme {
		Surface(color = MaterialTheme.colors.newBackgroundColor) {
		}
	}
}





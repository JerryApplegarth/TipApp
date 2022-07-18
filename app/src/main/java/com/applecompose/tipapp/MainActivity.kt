package com.applecompose.tipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applecompose.tipapp.presentation.components.MainContent
import com.applecompose.tipapp.presentation.components.TopAppBar
import com.applecompose.tipapp.presentation.components.TopHeader
import com.applecompose.tipapp.ui.theme.TipAppTheme
import com.applecompose.tipapp.ui.theme.newBackgroundColor

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TipAppTheme {
				HomeScreen()
			}
		}
	}
}

@ExperimentalComposeUiApi
@Composable
fun HomeScreen() {
	Column() {
		Column() {
			Row(
				modifier = Modifier
					.fillMaxWidth()
			) {
				TopAppBar()
			}


		}
		TopHeader()
	}





}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
	TipAppTheme {
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colors.newBackgroundColor
		) {
			HomeScreen()
		}
	}
}
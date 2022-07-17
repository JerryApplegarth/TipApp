package com.applecompose.tipapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar() {


		Scaffold(
			Modifier
				.fillMaxWidth()
				.height(44.dp),
			topBar = {
				TopAppBar(
					title = {
						Text(
							text = "Tip App",
							fontSize = 16.sp,
							color = Color.White
						)
					}
				)
			}
		){


	}



}

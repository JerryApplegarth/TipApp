package com.applecompose.tipapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TipCalculator() {
	Surface(modifier = Modifier
		.padding(12.dp)) {
		Column() {
			MainContent()
		}
	}

}
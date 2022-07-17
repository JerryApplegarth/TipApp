package com.applecompose.tipapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.applecompose.tipapp.ui.theme.Shapes

@Composable
fun MainContent() {
	Surface(
		modifier = Modifier
			.padding(6.dp)
			.fillMaxWidth()
			.height(300.dp),
		shape = RoundedCornerShape(corner = CornerSize(8.dp)),
		border = BorderStroke(width = 3.dp, color = MaterialTheme.colors.primary),
	) {
		Column() {
			Text(text = "More text goes here")
		}

	}


}
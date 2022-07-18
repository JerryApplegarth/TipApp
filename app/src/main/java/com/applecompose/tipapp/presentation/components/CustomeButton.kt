package com.applecompose.tipapp.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
	modifier: Modifier = Modifier,
	count: Int = 1,
	signLabel: String = "+",
	onClickButton: (Int) -> Unit = {},
) {

	Button(onClick = {
		if (signLabel == "-"){

			onClickButton(count - 1)
		}else {
			onClickButton(count + 1)
		}

		// Log.d("TAG", "CustomButton: ${count}")
	},
		modifier = modifier
			.width(40.dp)
			.height(40.dp),
		colors  = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFe9d7f7))) {
		Text(text = signLabel,
			style = TextStyle(fontWeight = FontWeight.ExtraBold)
		)

	}

}
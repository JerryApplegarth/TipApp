package com.applecompose.tipapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun MainContent() {
	val totalBillState = remember { mutableStateOf("")}
	val validState = remember(totalBillState.value) { totalBillState.value.trim().isNotEmpty() }
	val keyboardController = LocalSoftwareKeyboardController.current
	Surface(
		modifier = Modifier
			.padding(12.dp)
			.fillMaxWidth()
			.height(300.dp),
		shape = RoundedCornerShape(corner = CornerSize(8.dp)),
		border = BorderStroke(width = 3.dp, color = MaterialTheme.colors.primary),
	) {
		Column {
			InputField(
				valueState = totalBillState,
				labelId = "Enter Bill Amount",
				enabled = true,
				singleLine = true,
				onAction = KeyboardActions {
					if (!validState) return@KeyboardActions
					// To Do
					if (keyboardController != null) {
						keyboardController.hide()
					}
				}
			)


			Text(text = "More text goes here")
		}

	}


}
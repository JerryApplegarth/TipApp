package com.applecompose.tipapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applecompose.tipapp.R
import com.applecompose.tipapp.ui.theme.mediumGreen

@Composable
fun InputField(
	modifier: Modifier = Modifier,
	valueState: MutableState<String>,
	labelId: String,
	enabled: Boolean,
	singleLine: Boolean,
	keyboardType: KeyboardType = KeyboardType.Number,
	imeAction: ImeAction = ImeAction.Next,
	onAction: KeyboardActions = KeyboardActions.Default


) {
	OutlinedTextField(
	value = valueState.value,
	onValueChange = { valueState.value = it },
	label = { Text(text =  labelId) },
	leadingIcon = { Icon(imageVector = Icons.Rounded.AttachMoney,
		contentDescription = stringResource(R.string.money_icon)
			)
	},
		singleLine = singleLine,
		textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colors.mediumGreen),
		modifier = modifier
			.padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
		enabled = enabled,
		keyboardOptions = KeyboardOptions(keyboardType = keyboardType,
			imeAction = imeAction
		),
		keyboardActions = onAction,
		)

}
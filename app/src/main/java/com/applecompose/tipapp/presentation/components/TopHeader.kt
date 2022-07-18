package com.applecompose.tipapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.applecompose.tipapp.R
import com.applecompose.tipapp.ui.theme.cardBackground


@Composable
fun TopHeader(totalPerPers: Double = 0.0) {
	TopAppBar()

	Surface(modifier = Modifier
		.fillMaxWidth()
		.height(150.dp)
		.padding(12.dp)
		.clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
		color = MaterialTheme.colors.cardBackground
	) {

		Column(
			modifier = Modifier.padding(12.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center) {

			Text(text = stringResource(id = R.string.total_per_person),
				style = MaterialTheme.typography.subtitle1)
			val total =  "%.2f".format(totalPerPers)
			Text(text = "\$$total",
				style = MaterialTheme.typography.h4)


		}

	}

}
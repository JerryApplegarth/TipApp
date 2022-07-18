package com.applecompose.tipapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applecompose.tipapp.R
import com.applecompose.tipapp.ui.theme.cardBackground
import com.applecompose.tipapp.ui.theme.newBackgroundColor

@ExperimentalComposeUiApi
@Composable
fun TopHeader(totalPerPerson: Double = 12.56) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(MaterialTheme.colors.newBackgroundColor),
		//horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Top
	) {
		Card(
			modifier = Modifier
				.fillMaxWidth()
				.height(150.dp)
				.padding(16.dp)
				.clip(shape = CircleShape.copy(all = CornerSize(16.dp)))
				.background(MaterialTheme.colors.cardBackground),
			elevation = 6.dp,

		) {
			Column(
				modifier = Modifier
					.background(MaterialTheme.colors.cardBackground, shape = RectangleShape)
			) {
				val total = "%.2f".format(totalPerPerson)
				Text(
					modifier = Modifier
						.padding(6.dp)
						.fillMaxWidth(),
					text = stringResource(R.string.total_per_person),
					textAlign = TextAlign.Center,
					fontSize = 24.sp
					)


				Text(
					modifier = Modifier
						.fillMaxWidth(),
					text = "$ $total",
					textAlign = TextAlign.Center,
					fontSize = 36.sp,
					fontFamily = FontFamily.SansSerif,
					fontStyle = FontStyle.Italic,
					fontWeight = FontWeight.Bold
					)
			}
		}
		Column(
			modifier = Modifier
				.padding(6.dp),
			horizontalAlignment = Alignment.Start
		) {
			MainContent()
		}
	}
}
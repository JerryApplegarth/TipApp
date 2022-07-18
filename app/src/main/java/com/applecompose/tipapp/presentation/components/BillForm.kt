package com.applecompose.tipapp.presentation.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.applecompose.tipapp.R
import kotlin.math.roundToInt


@Composable
fun BillForm(modifier: Modifier = Modifier,
             onValChange: (String) -> Unit
) {

	val splitBy = remember {
		mutableStateOf(1)
	}

	var sliderPosition by remember {
		mutableStateOf(0f)
	}
	val totalTipAmt = remember {
		mutableStateOf(0.0)
	}
	val totalPerPerson = remember {
		mutableStateOf(0.0)
	}

	val tipPercentage = (sliderPosition * 30).roundToInt()
	val totalBill = rememberSaveable{ mutableStateOf("") }

	val valid = remember(totalBill.value) {
		totalBill.value.trim().isNotEmpty()
	}

	TopHeader(totalPerPers = totalPerPerson.value)

	Surface(modifier = Modifier
		.padding(2.dp)
		.fillMaxWidth()
		.height(260.dp),
		shape = CircleShape.copy(all = CornerSize(8.dp)),
		border = BorderStroke(width = 1.dp, color = Color.LightGray)) {

		Column(modifier = Modifier.padding(6.dp),
			verticalArrangement = Arrangement.Top,
			horizontalAlignment = Alignment.Start) {

			InputField(
				valueState = totalBill, labelId = stringResource(R.string.bill_amount) ,
				enabled = true, onAction = KeyboardActions {
					if (!valid) return@KeyboardActions
					onValChange(totalBill.value.trim())

				}, )
			Row(modifier = Modifier.padding(3.dp),
				horizontalArrangement = Arrangement.Start) {
				Text(text = "Split", modifier = Modifier
					.align(alignment = Alignment.CenterVertically))

				Spacer(modifier = Modifier.width(120.dp))

				Row(modifier = Modifier.padding(horizontal = 3.dp),
					horizontalArrangement = Arrangement.End) {
					CustomButton(signLabel = "-"){
						splitBy.value = if (splitBy.value > 1) splitBy.value - 1 else  1
						totalPerPerson.value = calculateTotalPerPerson(
							totalBill = totalBill.value.toDouble(),
							splitBy = splitBy.value,
							tipPercent = tipPercentage)
						// Log.d("TAG", "BillForm-Minus: ${splitCounter.value}")
					}
					Text(text = "${splitBy.value}",
						Modifier
							.align(alignment = Alignment.CenterVertically)
							.padding(start = 9.dp, end = 9.dp))
					CustomButton(count = splitBy.value, signLabel = "+"){ newVal ->
						splitBy.value = newVal
						totalPerPerson.value = calculateTotalPerPerson(
							totalBill = totalBill.value.toDouble(),
							splitBy = splitBy.value,
							tipPercent = tipPercentage)
						Log.d("TAG", "BillForm: ${splitBy.value}")
					}

				}
			}
			//Tip Row
			Row(modifier = Modifier
				.padding(horizontal = 3.dp)
				.padding(vertical = 12.dp),
				horizontalArrangement = Arrangement.End) {
				Text(text = "Tip", modifier = Modifier
					.align(alignment = Alignment.CenterVertically))

				Spacer(modifier = Modifier.width(200.dp))

				Text(text = "$${totalTipAmt.value}", modifier = Modifier
					.align(alignment = Alignment.CenterVertically))

			}

			//Slider
			Column(verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally) {

				Text(text = "$tipPercentage %")
				Spacer(modifier = Modifier.height(14.dp))
				Slider(value = sliderPosition, onValueChange = { newVal ->
					sliderPosition = newVal
					totalTipAmt.value = calculateTotalTip(totalBill = totalBill.value.toDouble(),
						tipPercent = tipPercentage)

					totalPerPerson.value = calculateTotalPerPerson(
						totalBill = totalBill.value.toDouble(),
						splitBy = splitBy.value,
						tipPercent = tipPercentage)
					Log.d("Slider", "Total Bill-->: ${"%.2f".format(totalTipAmt.value)}")
				}, modifier = Modifier.padding(start = 16.dp, end = 16.dp),
					steps = 5,
					onValueChangeFinished = {
						Log.d("Finished", "BillForm: $tipPercentage")
						//This is were the calculations should happen!
					})

			}

		}

	}


}

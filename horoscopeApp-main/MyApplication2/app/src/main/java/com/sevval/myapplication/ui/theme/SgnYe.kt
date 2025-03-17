@file:OptIn(DelicateCoroutinesApi::class)

package com.sevval.myapplication.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sevval.myapplication.Network.Modelview
import kotlinx.coroutines.DelicateCoroutinesApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleOwner
import com.sevval.myapplication.Network.ApiResponse



@Composable
fun SgnYe(modelView: Modelview = viewModel()) {

    modelView.getHoroscopeFromAPI("gemini")

    var horoscope by remember {
        mutableStateOf(ApiResponse(0, "", "", "", ""))
    }
    modelView.response.observe(LocalContext.current as LifecycleOwner) {
        horoscope=it
    }
    if(horoscope.horoscope!="") {
        MyUi(horoscope)
    }


}
@Composable
fun MyUi(fact: ApiResponse,modifier: Modifier = Modifier) {

    Log.d("hatam", fact.horoscope+"dsad")
    //(initial = ApiResponse("", "", "", 0, ""))
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Horoscope:", modifier.padding(bottom = 25.dp), fontSize = 26.sp)
        Text(
            text = fact.horoscope, fontSize = 26.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center
        )

    }
}


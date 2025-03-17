package com.sevval.myapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sevval.myapplication.Network.ApiResponse
import com.sevval.myapplication.Network.HoroscopeCharacteristics
import com.sevval.myapplication.Network.Modelview


@Composable
fun SgnBa(sign:String,characteristics: HoroscopeCharacteristics,modelView: Modelview = viewModel()) {
    modelView.getHoroscopeFromAPI(sign)

    var horoscope by remember {
        mutableStateOf(ApiResponse(0, "", "", "", ""))
    }
    modelView.response.observe(LocalContext.current as LifecycleOwner) {
        horoscope=it
    }

    LazyColumn( horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple80), contentPadding = PaddingValues(16.dp) ) {
        item{
            Spacer(modifier = Modifier.height(39.dp))
            Box(
                modifier = Modifier
                    .background(PurpleGrey40)
                    .border(3.dp, Color.White)
                    .padding(20.dp)
                    .height(50.dp)
                    .width(330.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "${horoscope.sign}",
                    fontSize = 40.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${horoscope.sign} General Characteristics", fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Serif
            )

            Box(
                modifier = Modifier
                    .border(3.dp, Color.White)
                    .background(PurpleGrey40)
                    .padding(20.dp)
                    .height(500.dp)
                    .width(400.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = horoscope.horoscope,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Horoscope Characteristics", fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Serif
            )
            Box(
                modifier = Modifier
                    .border(3.dp, Color.White)
                    .background(PurpleGrey40)
                    .padding(20.dp)
                    .height(500.dp)
                    .width(400.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Text(
                    text =  "* Ruling Planet: ${characteristics.RulingPlanet}\n" +
                            "* Element: ${characteristics.Element}\n" +
                            "* Attribute:  ${characteristics.Attribute}\n"+
                            "* Lucky Numbers: ${characteristics.LuckyNumber}\n"+
                            "* Day: ${characteristics.Day}\n"+
                            "* Lucky Stone: ${characteristics.LuckyStone}\n"+
                            "* Colour: ${characteristics.Color}\n"+
                            "* Tarot card: ${characteristics.TarotCard}\n"+
                            "* Animal: ${characteristics.Animal} \n"+
                            "* Plant: ${characteristics.Plant}\n"+
                            "* Precious Stone: ${characteristics.PreciousStone} \n"+
                            "* Precious Mineral:  ${characteristics.PreciousMineral}",
                    color = Color.White


                )



            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

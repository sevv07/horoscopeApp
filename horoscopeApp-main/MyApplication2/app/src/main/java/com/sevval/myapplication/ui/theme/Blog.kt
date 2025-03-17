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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Blog(){
    LazyColumn( horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple80), contentPadding = PaddingValues(16.dp) ) {
        item {
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
                    text = "Blog ",
                    fontSize = 40.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "What is Astrology?", fontSize =30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Serif
            )
            Box(
                modifier = Modifier
                    .border(3.dp, Color.White)
                    .background(PurpleGrey40)
                    .padding(20.dp)
                    .height(1700.dp)
                    .width(400.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "Astrology literally means \"the discourse of the stars\"." +
                            " In ancient Greek, it is formed by the combination of the words aster (star) and logos (discourse). " +
                            "Reading and listening to the discourse of the stars develops our familiarity with ourselves. In this way, " +
                            "this familiarity with ourselves contributes to the development of our personality and the shaping of our behaviour. When we take control of ourselves, " +
                            "we neither tangent nor submit to the events in our lives. On the contrary, we live more meaningful lives as individuals who act and direct." +
                            "Astrology reminds us that we should not forget that events do not go towards people, but people go towards events. As people who have an impact on our own lives, when we take control of what we experience, we can become the masters of our own destiny and get away from the troubles caused by future anxiety.\n" +
                            "\n" +
                            "Astrology addresses our mental faculties. Our mental faculties are our most powerful characteristics. It carries great potentials within it. " +
                            "Every human being has the opportunity to develop the potentials they are born with. Most of the time, we block these opportunities that we were born with psychological problems from our childhood or our past. " +
                            "We have to realise these negative points in our experiences that create problems for us. Astrology, through the interpretation of the birth chart, reveals other positive points that we cannot see next to the negative points." +
                            "\n" +
                            "Astrology is not only a personal ear, a support for realising our projects, but also a helping hand that offers suggestions for better living and allows us to get to know ourselves. " +
                            "The idea that the discourse of the stars increases our awareness as a mirror held up to us began in history with the approach of Pythagoras. Pythagoras thought that all stars had a life and were equipped with a mind." +
                            " He saw the universe as a cosmic stringed instrument, a lyre. As this instrument played, songs would come to life. Chinese Taoists, at the same time as Pythagoras, thought that everything in space emitted a sound. Today, the discovery that planets and stars in space are sources of radiophonic sound was not alien to the thoughts of the ancients." +
                            " Before Pythagoras, the Babylonians believed that man was a toy in the hands of fate. Pythagoras, on the other hand, was of the opinion that man did not submit to his fate. With this approach, he changed the view of astrology in many respects. Mesopotamians followed this approach. " +
                            "For a long time afterwards, astrology had an impact on what was happening in the world as a field that kings, rulers and statesmen took into consideration and consulted." ,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
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
fun SgnOg(){
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
                    text = "Capricorn",
                    fontSize = 40.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Capricorn General Characteristics", fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Serif
            )
            Box(
                modifier = Modifier
                    .border(3.dp, Color.White)
                    .background(PurpleGrey40)
                    .padding(20.dp)
                    .height(1500.dp)
                    .width(400.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Text(
                    text =  "Capricorn Woman General Characteristics\n" +
                            "\n" +
                            "Capricorn woman attracts attention with her ambitious, cheerful, homebody, hardworking and honest structure. The wealth of knowledge and culture is also important to her.\n" +
                            "\n" +
                            "Capricorn woman builds a wall for herself due to her pessimistic mood and puts obstacles in front of herself. However, its ambitious and strong structure is at the forefront enough. Capricorn woman, who is always confident, does not easily trust those around her and is conservative. Their movements are measured. They are so frugal in material matters that this is to the extent of stinginess.\n" +
                            "\n" +
                            "They attach great importance to knowledge. Politeness and culture are very important for them, so they work hard to improve themselves. They are very ambitious and assertive about work. They are capable of succeeding in all the work they put their hands on.\n" +
                            "\n" +
                            "The Capricorn woman is quite logical and realistic, so she can develop a quicker decision in the face of events.\n" +
                            "\n" +
                            "Capricorn woman owns the man she loves very much and wants it to be the way she wants it to be. Especially kindness and honesty in the opposite sex is very important. He tries to choose his partner carefully. Capricorn woman who loves to live life to the fullest wants to have a social partnership with the person she loves. She will be a cheerful and loving mother to her children. However, due to excessive possessive motive, it may be in a somewhat commanding attitude.\n" +
                            "\n" +
                            "Capricorn Man General Characteristics\n" +
                            "\n" +
                            "Capricorn man attracts attention with his hardworking, determined, ambitious and affectionate behaviour. He is fond of materialism and enjoys working. He is good at making money. Knows well to utilise opportunities. He is frugal and loves saving.\n" +
                            "\n" +
                            "Capricorn man is reliable, rule and disciplined. He likes things that are systematic and organised. He usually has a sceptical attitude. He evaluates and interprets events according to his own truth and does not show his feelings immediately. It has a cold-blooded appearance.\n" +
                            "\n" +
                            "Capricorn man attaches great importance to friendship and examines and selects the people he makes friends with. It has strict rules and does not want to go out of these rules easily.\n" +
                            "\n" +
                            "Capricorn man is fond of his freedom and does not like the other party to direct and restrict him in bilateral relationships. He will be happy with a woman suitable for his personality. When he loves, he becomes a loyal and jealous spouse. He likes women who are more intelligent, well-groomed, know what they want and have personality. His relationships are long lasting. He has a personality suitable for marriage. He is an ideal husband and an ideal father. He will mobilise all his best efforts to raise his children in the best way.\n" +
                            "\n",
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
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .border(3.dp, Color.White)
                    .background(PurpleGrey40)
                    .padding(20.dp)
                    .height(1100.dp)
                    .width(400.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Text(
                    text ="* Ruling Planet: Saturn\n" +
                            "* Element: Soil\n" +
                            "* Attribute:  Pioneer\n"+
                            "* Lucky Numbers: 2, 8\n"+
                            "* Day: Saturday\n"+
                            "* Lucky Stone: Grena\n"+
                            "* Colour: Dark green, brown\n"+
                            "* Tarot card: The Devil\n"+
                            "* Animal: Goats and other horned animals\n"+
                            "* Plant: Carnation, ivy, pine, poplar, elm\n"+
                            "* Precious Stone: Black diamond, amber \n"+
                            "* Precious Mineral:  Lead"
                ,color = Color.White)
            }

        }
    }
}
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
fun SgnAr(){

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
                    text = "Aries ",
                    fontSize = 40.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Aries General Characteristics ", fontSize =30.sp,
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
                    text =
                    "Aries Woman General Characteristics" +
                            "\n"+
                            "Aries woman draws attention with her active, talkative and entrepreneurial structure. It is also quite humorous. It is attractive, athletic and delicate. It always expresses criticism and things it does not like. It attracts attention with its glamour and difference in society.\n" +
                            "\n" +
                            "Aries woman is very ambitious and idealistic in business life. She wants to realise what she has put in her mind and proceeds on the path she has drawn, knows how to use time well and is hardworking. Aries woman is a fun friend sought after in the circle of friends, especially with her sincere and sympathetic demeanour. She is a little uneasy and restless inside. She criticises herself too much and always struggles with herself as if she is in a race. He attaches great importance to his friends and loved ones and is very self-sacrificing.\n" +
                            "\n" +
                            "Since his emotional structure is quite sensitive, negative criticism can hurt him a lot. He is very fond of his home and family and is a perfectionist in this regard as in every subject.\n" +
                            "\n" +
                            "The Aries woman, who likes to be constantly active, enjoys social activities, doing sports and spending time with her friends in her free time.\n" +
                            "\n" +
                            "Aries Man General Characteristics\n" +
                            "\n" +
                            "Aries man is recognised in the society with his self-confident, active and energetic structure. He is authoritarian and enjoys establishing authority. He is stubborn and does not want to accept it when he makes a mistake and exhibits selfish behaviour.\n" +
                            "\n" +
                            "Aries man is very fond of his freedom. There is nothing he will not do for his friends and friends. He likes to help people and share their problems. He is generous and likes to be financially free. It is much more attractive for them to establish and run their own business.\n" +
                            "\n" +
                            "When the Aries man is hurt, he becomes quite offensive and does not mince his words. He is critical, he can criticise with a harsh language. He is very fond of home life and family, but he also loves his life outside. This is due to his restless and mobile structure. He always wants to feel peaceful and comfortable at home.\n",
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
                    text =  "* Ruling Planet: Mars\n" +
                            "* Element: Fire\n" +
                            "* Attribute:  Pioneer\n"+
                            "Lucky Numbers: 1,9\n"+
                            "*Day: Tuesday\n"+
                            "* Lucky Stone: Ruby\n"+
                            "* Colour: Red \n"+
                            "* Animal: Sheep\n"+
                            "* Plant: Geranium, Honeysuckle, Pars Lily\n"+
                            "* Precious Stone: Diamond \n"+
                            "*Precious Mineral: Iron",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
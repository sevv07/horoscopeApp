package com.sevval.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.sevval.myapplication.ui.theme.Black
import com.sevval.myapplication.ui.theme.Purple40
import com.sevval.myapplication.ui.theme.Purple80

@SuppressLint("UnrememberedMutableState")
@Composable
fun Logın(navController: NavController) {


    var name by remember { mutableStateOf("") }
    var surname by  remember{ mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
     //val name = remember {mutableStateOf(TextFieldValue())}
    //val password = remember {mutableStateOf(TextFieldValue())}

    val icon: Painter = if (passwordVisibility)
        painterResource(id = R.drawable.eye)
    else
        painterResource(id = R.drawable.ofeye)

    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier= Modifier
            .fillMaxWidth()
            .background(Purple80))
    {

        Spacer(modifier = Modifier.height(32.dp))

        boxMenu(resId = R.drawable.account, description = "user" )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Log In",
            fontSize = 40.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif )

        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = name, onValueChange = {name=it},
            placeholder = { Text(text = "Your Email") },
            label ={ Text(text="Your email") },
            singleLine = true ,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        Text(text =name, fontSize = 25.sp )

        TextField(value = surname, onValueChange = {surname=it},
            placeholder = { Text(text = "User name") },
            label ={ Text(text="user name") } ,
            singleLine = true ,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ))
        Text(text =surname, fontSize = 25.sp )

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password") },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(60.dp))

        Row (modifier= Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){

            Button(onClick = {

                navController.navigate("HomeScreen")

            } //, enabled = isNameValid && isPasswordValid
                     ) {
                Text(text = "Log ın", fontSize= 25.sp)
            }

        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "or",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier= Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Button(onClick = {
               navController.navigate("Sıgn up")
            }) {
                Text(text = "Sign up", fontSize= 25.sp)
            }
            Spacer(modifier = Modifier.height(200.dp))
        }
    }
}

@Composable
fun  boxMenu(
    resId: Int,
    description: String,
    ıconColor: Color?= Black,
    bColor: Color?= Purple40,
    size: Int?=148,
    ıconSize: Int=100)
{
    Box(modifier = Modifier
        .size(size!!.dp)
        .clip(RoundedCornerShape(90.dp))
        .background(bColor!!),contentAlignment = Alignment.Center)
    {
        Icon(
            painter= painterResource(id=resId),
            contentDescription= description,
            modifier = Modifier.size(ıconSize.dp),
            tint= ıconColor!!
        )
    }





}

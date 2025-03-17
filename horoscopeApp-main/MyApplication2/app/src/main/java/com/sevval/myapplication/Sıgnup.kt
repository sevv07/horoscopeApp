package com.sevval.myapplication

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.data.UiToolingDataApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.TextUtils
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.sevval.myapplication.ui.theme.Purple80
import kotlinx.coroutines.launch

@Composable
fun Sıgnup(navController: NavController) {
    // context
    val context = LocalContext.current

    var name by remember { mutableStateOf(" ") }
    var surname by  remember{ mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

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
            text = "Sign Up",
            fontSize = 40.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif )

        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = name, onValueChange = {name=it},
            placeholder = { Text(text = "example@gmail.com") },
            label ={ Text(text="Enter Your email") },
            singleLine = true ,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )

        Text(text =name, fontSize = 25.sp )

        TextField(value = surname, onValueChange = {surname=it},
            placeholder = { Text(text = "username") },
            label ={ Text(text="Enter your username") } ,
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
            label = { Text(text = "Create Your Password") },
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
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT).show()
                } else if (TextUtils.isEmpty(surname)) {
                    Toast.makeText(context, "Please enter user name", Toast.LENGTH_SHORT).show()
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(context, "Please enter password", Toast.LENGTH_SHORT).show()
                } else {
                    // on below line adding data to
                    // firebase firestore database.
                    addDataToFirebase(
                        name,
                        surname,
                        password, context
                    )
                }
            }) {
                Text(text = "Save", fontSize= 25.sp)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row (modifier= Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Button(onClick = {
               navController.navigate("Log ın")
            }) {
                Text(text = "Log In", fontSize= 25.sp)
            }
            Spacer(modifier = Modifier.height(200.dp))
        }


    }
}

fun addDataToFirebase(
    name: String,
    surname: String,
    password: String,
    context: Context
) {
    // on below line creating an instance of firebase firestore.
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    //creating a collection reference for our Firebase Firestore database.
    val dbCourses: CollectionReference = db.collection("user")
    //adding our data to our courses object class.
    val user = User(name , surname, password  )

    //below method is use to add data to Firebase Firestore.
    dbCourses.add(user).addOnSuccessListener {
        // after the data addition is successful
        // we are displaying a success toast message.
        Toast.makeText(
            context,
            "Your information has been added to Firebase Firestore",
            Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        // this method is called when the data addition process is failed.
        // displaying a toast message when data addition is failed.
        Toast.makeText(context, "Fail to add course \n$e", Toast.LENGTH_SHORT).show()
    }

}








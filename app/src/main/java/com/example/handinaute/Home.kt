package com.example.handinaute

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AdminPanelSettings
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.handinaute.ui.theme.HandinauteThemeSingleColorLite
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


/*
class Boarding : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
                ),
        )

        setContent {
            HandinauteThemeSingleColorLite {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Column(
                       modifier = Modifier
                           .fillMaxSize()
                           .background(Color.Red),

                   ){

                   }
                }
            }
        }
    }
}
*/


/*

 */

@Destination
@Composable
fun HomeScreen(
navigator: DestinationsNavigator?,

){
    HandinauteThemeSingleColorLite {


        val image   = listOf(
            R.drawable.wheelchair1,
            R.drawable.wheelchair2,
            R.drawable.wheelchair3,
            R.drawable.wheelchair4)
        var currentIndex= remember {
            mutableIntStateOf(0)
        }

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource( R.drawable.background_home2),
            contentDescription = "background_admin",
            contentScale =  ContentScale.FillBounds,
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .statusBarsPadding()
                .navigationBarsPadding(),

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),

                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f),
                    horizontalArrangement = Arrangement.Start

                ) {

                    Text(
                        text = "IconeClient",
                        fontWeight = FontWeight.Bold,
                        fontSize =  26.sp,
                    )
                }

                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f)
                    ,
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Outlined.AdminPanelSettings ,
                        contentDescription = "adminIcon"
                    )


                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )

                    Text(
                        text = "Administration" ,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize =  26.sp,
                        textDecoration = TextDecoration.Underline,
                    )
                }

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.Center

                ) {
                    Text(
                        text = "Bienvenu a bord Du Handinaute",
                        fontWeight = FontWeight.Bold,
                        fontSize =  26.sp,
                    )

                }

                Image(
                    modifier = Modifier.padding(bottom = 30.dp),
                    painter = painterResource(id = image[currentIndex.value]),
                    contentDescription = "Tuto d'embarquement"
                )

                Box (
                    modifier= Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(bottom = 20.dp)
                    ,
                    contentAlignment = Alignment.Center,
                ){


                    Button(
                        shape= MaterialTheme.shapes.small,
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            modifier=Modifier.padding(15.dp),
                            text = "Commencer l'embarquement",
                            fontWeight= FontWeight.Bold,
                            fontSize = 26.sp
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun ImageSlider(){}
@Composable
fun DotIndicator(){}
@Composable

fun ImageSliderIndicator(){}




@Composable
fun LoginFormAdmin(modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier

            .wrapContentSize()
            .clip(MaterialTheme.shapes.medium) // Ajouter des coins légèrement arrondis
            .background(MaterialTheme.colorScheme.tertiaryContainer),


        ) {

        Column(
            // Ajouter un padding intérieur de 20dp au Column
            modifier= Modifier
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .padding(20.dp)
            ,



            ) {
            // Ajouter un espace de 15dp entre les deux EditText
            Spacer(modifier=Modifier.height(15.dp))

            var filledTextMail by remember {
                mutableStateOf("")
            }

            TextField(


                value = filledTextMail ,
                onValueChange ={filledTextMail=it},
                textStyle = LocalTextStyle.current.copy(),
                label = {
                    Text(text = "Email")
                },
                placeholder = {
                    Text(text = "exemple@mail.com")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Mail , contentDescription = "mail_icon" )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next ,
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Email,


                    ) ,
                modifier=Modifier
                    .background(Color.White)
                ,
            )

            Spacer(modifier=Modifier.height(15.dp))

            var filledTextPassword by remember {
                mutableStateOf("")
            }

            TextField(

                value = filledTextPassword ,
                onValueChange ={filledTextPassword=it},
                textStyle = LocalTextStyle.current.copy(),
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Enter Password")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Lock , contentDescription = "mail_icon" )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Password,
                ),
                visualTransformation = PasswordVisualTransformation(),
            )

            Spacer(modifier=Modifier.height(15.dp))

            Button(

                onClick = {
                    // Action à effectuer lors du clic sur le bouton de connexion
                },
                modifier = Modifier
                    .wrapContentSize()
                    .height(50.dp)
                    .clip(MaterialTheme.shapes.medium) // Ajouter des coins arrondis
                    .align(Alignment.CenterHorizontally),
            ) {
                Text(
                    text="Connexion",
                    style = LocalTextStyle.current.copy(
                        fontSize = 20.sp,
                        //fontWeight = FontWeight.Normal,
                        //fontStyle = FontStyle.Normal,
                    )
                )
            }

        }



    }

}



@Preview(showBackground = true, device = "spec:width=1080dp,height=600dp,dpi=240")
@Composable
fun GreetingPreview3() {

HomeScreen( navigator = null)


}
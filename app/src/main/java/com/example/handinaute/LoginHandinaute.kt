package com.example.handinaute

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.WheelchairPickup
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.handinaute.destinations.HomeScreenDestination
import com.example.handinaute.ui.theme.BluePrimery
import com.example.handinaute.ui.theme.HandinauteThemeSingleColorScheme
import com.example.handinaute.ui.theme.WhitePurpleH
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination(start = true)
@Composable()
fun LoginHandinauteScreen(
    navigator:DestinationsNavigator?,

) {


    HandinauteThemeSingleColorScheme {
        // A surface container using the 'background' color from the theme
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BluePrimery),
            contentAlignment = Alignment.Center,
        ) {

            Image(
                modifier = Modifier.fillMaxHeight(),
                painter = painterResource( R.drawable.background_admin2),
                contentDescription = "background_admin",
                contentScale = ContentScale.FillBounds,

                )

            Row (
                modifier= Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround

            ){

                Icon(
                    painter = painterResource(id = R.drawable.icone_aurizeo_vert),
                    contentDescription ="logo_handinaute",
                    tint = WhitePurpleH,
                    modifier= Modifier.size(120.dp),
                )
                Column (
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End

                )
                {
                    Text(
                        text = "Handinaute",
                        style = LocalTextStyle.current.copy(
                            fontSize = 25.sp,
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            fontStyle = FontStyle.Italic
                        )

                    )
                    Text(
                        text = "by aurizeo",
                        style = LocalTextStyle.current.copy(
                            color=Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

            }

           LoginFormHandinaute(navigator = navigator)

        }

    }

}






@Composable
fun LoginFormHandinaute(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator?,

) {
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
                    Text(text = "N° handinaute")
                        },
                placeholder = {
                    Text(text = "")
                              },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.WheelchairPickup , contentDescription = "mail_icon" )
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

            Button(

                onClick = {
                    navigator?.navigate(
                        HomeScreenDestination()
                    )
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





@Preview(showBackground = true,device = "spec:width=1080dp,height=600dp,dpi=241")

@Composable
fun GreetingPreview() {

    LoginHandinauteScreen( null)

}


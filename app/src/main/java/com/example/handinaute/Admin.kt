package com.example.handinaute

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.handinaute.custom.AutoResizedText
import com.example.handinaute.destinations.HomeScreenDestination
import com.example.handinaute.destinations.LoginHandinauteScreenDestination
import com.example.handinaute.ui.theme.HandinauteThemeSingleColorLite
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/*
class AdminScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HandinauteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

*/
@Destination
@Composable
fun Admin (
    navigator: DestinationsNavigator?

){
    HandinauteThemeSingleColorLite {

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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 20.dp, end = 20.dp, top = 40.dp)
                ,

                // horizontalArrangement = Arrangement.End,
                //verticalAlignment = Alignment.CenterVertically,

            ) {
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center),


                    ) {

                    Text(
                        text = "Panel administrateur",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize =  30.sp,
                    )
                }

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterEnd),

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = Icons.Outlined.ExitToApp ,
                        contentDescription = "adminIcon"
                    )


                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )

                    Text(
                        text = "Deconnexion" ,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize =  26.sp,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable {
                            navigator?.navigate(HomeScreenDestination())
                        }
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
                        text = "vitesse maximale",
                        fontWeight = FontWeight.Bold,
                        fontSize =  26.sp,
                    )

                }

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(shape = CircleShape)
                        .background(MaterialTheme.colorScheme.errorContainer)

                    ,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {

                    Row (
                        modifier = Modifier.padding(40.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom
                    ){
                        AutoResizedText(

                            text = "7",
                            maxLine = 1,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 100.sp,
                            ),

                            //fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        AutoResizedText(
                            maxLine = 1,
                            text = "km/h",
                            modifier = Modifier.padding(bottom = 15.dp),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp,
                            ),

                            //fontWeight = FontWeight.Bold,

                        )
                    }


                }

            }


            Box (
                modifier= Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 20.dp)
                ,
                contentAlignment = Alignment.Center,
            ){

                Text(
                    modifier= Modifier
                        .padding(15.dp)
                        .clickable { navigator?.navigate(LoginHandinauteScreenDestination) },
                    text = "Dissocier la tablette du handinaute",
                    fontWeight= FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.error,
                    textDecoration = TextDecoration.Underline
                )

            }

        }
    }

}


@Preview(showBackground = true, device = "spec:width=1080dp,height=600dp,dpi=240")
@Composable
fun GreetingPreview5() {
    Admin(navigator = null)

}

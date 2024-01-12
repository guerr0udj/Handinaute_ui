package com.example.handinaute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.handinaute.ui.theme.HandinauteThemeSingleColorLite
import com.example.handinaute.ui.theme.TurquoisTertiary

class Bording : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HandinauteThemeSingleColorLite {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, device = "spec:width=1080dp,height=600dp,dpi=240" )
@Composable
fun GreetingPreview4() {
    HandinauteThemeSingleColorLite {


        val image = listOf(
            R.drawable.wheelchair1,
            R.drawable.wheelchair2,
            R.drawable.wheelchair3,
            R.drawable.wheelchair4
        )
        var currentIndex = remember {
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


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center

                ) {
                    Text(
                        text = "Tutorial d'embarquement",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                    )

                }

                Image(
                    painter = painterResource(id = image[currentIndex.value]),
                    contentDescription = "Tuto d'embarquement"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(20.dp),

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {


                    Button(
                        shape = MaterialTheme.shapes.small,
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            modifier = Modifier.padding(15.dp),
                            text = "Annuler",
                            fontWeight = FontWeight.Bold,
                            fontSize = 26.sp

                        )
                    }

                    Spacer(modifier = Modifier.width(60.dp))

                    Button(

                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.buttonColors(TurquoisTertiary),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 15.dp, bottom = 15.dp),
                            text = "Suivant",
                            fontWeight = FontWeight.Bold,
                            fontSize = 26.sp
                        )
                    }

                }

            }


        }
    }
}
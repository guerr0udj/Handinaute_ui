package com.example.handinaute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.handinaute.custom.AutoResizedText
import com.example.handinaute.ui.theme.BluePrimery
import com.example.handinaute.ui.theme.HandinauteThemeSingleColorScheme
import com.example.handinaute.ui.theme.OrangeH

class Board : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)




        setContent {
            HandinauteThemeSingleColorScheme (){
                // A surface container using the 'background' color from the theme
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }*/


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "6.66",
                            fontSize = 140.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "km/h",
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(40.dp)
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "123 km parcourus",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { /* Action à effectuer lors du clic */ },
                            modifier = Modifier
                                .wrapContentHeight()
                                .background(MaterialTheme.colorScheme.secondary)
                        ) {
                            Text(
                                text = "Terminer la session",
                                fontSize = 40.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { /* Action à effectuer lors du clic */ },
                            modifier = Modifier
                                .size(130.dp)
                                .background(MaterialTheme.colorScheme.error)
                                .clip(CircleShape)
                        ) {
                            Text(
                                text = "Help",
                                fontSize = 40.sp
                            )
                        }
                    }
                }
            }

        }
    }

}



@Preview(showBackground = true , device = "spec:width=950dp,height=500dp,dpi=240")
@Composable
fun GreetingPreview2() {

    HandinauteThemeSingleColorScheme {

Box(modifier = Modifier
    .fillMaxSize()
    .background(color=BluePrimery)

) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,

        ) {
        Spacer(modifier = Modifier.size(40.dp))
        Row(
            modifier = Modifier
                .wrapContentSize(),

            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = "6.66",
                fontSize = 140.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,

                )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "km/h",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }


        Box(
            modifier = Modifier
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                    .padding(40.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {

                    /*
                   Text(

                        modifier = Modifier
                        .weight(1f),
                        text = "123 km parcourus",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        softWrap = true,
                        maxLines = 2,
                        )

                    */

                    AutoResizedText(
                        text = "123 km parcourus",
                        maxLine = 2,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.widthIn(max = 230.dp),
                    )
                }




                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .weight(2f),

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,


                    ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(OrangeH),
                        onClick = { /* Action à effectuer lors du clic */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        shape = RoundedCornerShape(20),

                        ) {
/*
                      Text(
                          text = "Terminer la session",
                          fontSize = 30.sp,
                          textAlign= TextAlign.Center,
                          fontFamily = FontFamily(Font(R.font.bc_alphapipe_l_regular)),
                          softWrap = true,
                          maxLines = 2,
                        )
*/

                        AutoResizedText(
                            text = "Terminer la session",
                            maxLine = 2,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier,
                            fontSize = 30.sp,
                        )

                    }

                }



                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .weight(1f),

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,


                    ) {

                    Button(

                        onClick = { /* Action à effectuer lors du clic */ },

                        modifier = Modifier.height(100.dp),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.errorContainer),
                        // .weight(1f),
                        shape = CircleShape,


                        ) {
                        /*
                            Text(
                                text = "Help",
                                fontSize = 30.sp,
                                textAlign= TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.bc_alphapipe_l_regular)),
                                softWrap = false,
                            )

                         */


                        AutoResizedText(
                            text = "Help",
                            maxLine = 1,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                            ),
                            fontSize = 30.sp,
                            modifier = Modifier,

                            )


                    }
                }

            }
        }
    }
}
    }


}


